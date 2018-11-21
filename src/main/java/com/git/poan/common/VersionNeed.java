package com.git.poan.common;

import java.lang.annotation.*;

/**
 * @Author: panbenxing
 * @Date: 2018/11/21
 * @Description:
 */
@Inherited
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VersionNeed {

    public VersionEnum[] version();

}
