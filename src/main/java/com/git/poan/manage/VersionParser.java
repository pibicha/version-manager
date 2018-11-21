package com.git.poan.manage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.git.poan.bean.User;
import com.git.poan.bean.VersionAble;
import com.git.poan.common.VersionEnum;
import com.git.poan.common.VersionNeed;

import java.lang.reflect.Field;

/**
 * @Author: panbenxing
 * @Date: 2018/11/21
 * @Description:
 */
public class VersionParser {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        User user = new User();
        user.setVersion("1.0.0");
        user.setName("张三");
        pass(user);
    }

    public static <T extends VersionAble> void pass(T t) throws IllegalAccessException, InstantiationException {
        // 反射获取FeatureReq的属性注解，结合req实例，判断是否有传入必须字段
        Class<? extends VersionAble> reqCls = t.getClass();
        Field[] fields = reqCls.getDeclaredFields();
        for (Field field : fields) {
            boolean annotationPresent = field.isAnnotationPresent(VersionNeed.class);
            if (annotationPresent) {
                VersionNeed versionNeed = field.getAnnotation(VersionNeed.class);
                VersionEnum[] version = versionNeed.version();
                String reqVersion = t.getVersion();
                if (reqVersion == null || "".equals(reqVersion)) {
                    // todo 版本必须传
                    System.out.println("version is required");
                }

                for (VersionEnum versionEnum : version) {
                    if (reqVersion.equals(versionEnum.version)) {
                        // 判断该值是否存在
                        field.setAccessible(true);
                        Object o = field.get(t);
                        if (null == o) {
                            // todo 提示改字段在该版本必须传入
                            System.out.println(field.getName() + " in " + versionEnum.version + " is required");
                        } else {
                            System.out.println(field.getName() + " : " + o);
                        }
                    }
                }
            }
        }
    }
}
