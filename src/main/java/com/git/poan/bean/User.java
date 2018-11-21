package com.git.poan.bean;


import com.git.poan.common.VersionEnum;
import com.git.poan.common.VersionNeed;

public class User implements VersionAble {

    @VersionNeed(version = {VersionEnum.V1_0_0, VersionEnum.V1_0_1})
    private String name;

    @VersionNeed(version = {VersionEnum.V1_0_0, VersionEnum.V1_0_1})
    private String identity;

    private String birth;

    private String version;

    @Override
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
