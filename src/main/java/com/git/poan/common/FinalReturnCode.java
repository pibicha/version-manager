package com.git.poan.common;

/**
 * Created by qiuyujiang on 2018/2/26.
 */
public enum FinalReturnCode {

    // 通用信息 ↓
    SUCCESS("200", "成功"),
    NO_MATCHED("407", "无匹配信息"),
    EXCEPTION("500", "其它异常"),
    // 通用信息 ↑

    // 校验错误信息 ↓
    NO_REQ("10", "请求报文为null或空字符串"),
    NO_ID("12", "请求报文无id"),
    WRONG_APP_YM_FORMAT("13", "appym格式错误，应为yyyy-MM格式"),
    ILLEGAL_JSON_FORMAT("14", "非法的JSON格式"),
    TOKEN_NOT_FOUNT("15", "秘钥错误"),
    VERSION_NOT_FOUND("17", "请求报文未提供版本号"),
    VERSION_NOT_SUPPORT("18", "暂不支持该版本"),
    FEATURE_SET_NOT_FOUND("19", "请求报文未找到featureSetCode"),
    FEATURE_SET_NO_VALID("20", "无效的featureSetCode"),

    ID_TYPE_NOT_FOUND("21", "请求报文中未提供idType"),
    ID_TYPE_INVALID("22", "请求报文中含有无效的idType"),
    OUT_OF_RATE_LIMIT_THRESHOLD("23", "流量超出阈值"),

    REQ_METAS_IS_NULL("24", "请求报文未提供reqMetas"),

    // 25对应的是Hbase超时，由于超时被安排成“其他异常”，所以为了逻辑划分，写到了ReturnCode类中
    DATE_ERROR("26","基线日期不合法"),
    CALL_SNO_MISS("5001","请求报文未提供callSno"),


    // 校验错误信息 ↑

    ;

    private String code;
    private String message;

    FinalReturnCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
