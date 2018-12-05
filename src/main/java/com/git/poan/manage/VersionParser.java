package com.git.poan.manage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.git.poan.bean.User;
import com.git.poan.bean.VersionAble;
import com.git.poan.common.FinalReturnCode;
import com.git.poan.common.VersionEnum;
import com.git.poan.common.VersionNeed;
import com.git.poan.exception.ValidateException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author: panbenxing
 * @Date: 2018/11/21
 * @Description:
 */
public class VersionParser {

    public static void main(String[] args) throws ValidateException {
        User user = new User();
        user.setVersion("1.0.0");
        user.setName("张三");
        pass(user);
    }

    public static <T extends VersionAble> void pass(T t) throws ValidateException {
        // 反射获取FeatureReq的属性注解，结合req实例，判断是否有传入必须字段
        Class<? extends VersionAble> reqCls = t.getClass();
        Field[] fields = reqCls.getDeclaredFields();

        String paramJson = JSON.toJSONString(t);
        String reqVersion = t.getVersion();
        if (reqVersion == null || "".equals(reqVersion)) {
//            logger.error("params -{},version is required!", paramJson);
            throw new ValidateException(FinalReturnCode.VERSION_NOT_FOUND.getMessage());
        }
        List<VersionEnum> allVersion = Arrays.asList(VersionEnum.values());
        VersionEnum currVersion = VersionEnum.getByVal(reqVersion);
        if (!allVersion.contains(currVersion)) {
//            logger.error("不支持传入的{}版本", reqVersion);
            throw new ValidateException(FinalReturnCode.VERSION_NOT_SUPPORT.getMessage());
        }

        try {
            for (Field field : fields) {
                boolean annotationPresent = field.isAnnotationPresent(VersionNeed.class);
                if (annotationPresent) {
                    VersionNeed versionNeed = field.getAnnotation(VersionNeed.class);
                    VersionEnum[] versions = versionNeed.version();
                    List<VersionEnum> versionEnums = Arrays.asList(versions);
                    if (versionEnums.contains(currVersion)) {
                        // 判断该值是否存在
                        field.setAccessible(true);
                        String fieldName = field.getName();
                        Object o = field.get(t);
                        if (null == o) {
//                            logger.error("params -{},{} is required!", paramJson, fieldName);
                            throw new ValidateException(fieldName + "is Null");
                        }
                        // 如果该参数是字符类型，空串判断
                        if (o instanceof String) {
                            String str = (String) o;
                            if ("".equals(str.trim())) {
                                throw new ValidateException(fieldName + "is Null");
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
//            logger.error("field access grant error!", e);
        }
    }
}
