package com.git.poan.common;

import java.util.HashMap;
import java.util.Map;

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

    private static Map<String, VersionEnum> cacheMap = new HashMap<>();

    static {
        for (VersionEnum versionEnum : VersionEnum.values()) {
            cacheMap.put(versionEnum.version, versionEnum);
        }
    }

    public static VersionEnum getByVal(String versoin) {
        return cacheMap.get(versoin);
    }
}
