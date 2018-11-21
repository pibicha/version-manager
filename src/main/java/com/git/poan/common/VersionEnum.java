package com.git.poan.common;

/**
 * @Author: panbenxing
 * @Date: 2018/11/21
 * @Description:
 */
public enum VersionEnum {


    /**
     * 1.0.0版本
     */
    V1_0_0("1.0.0"),
    V1_0_1("1.0.1"),

    //
    ;

    public String version;

    VersionEnum(String version) {
        this.version = version;
    }
}
