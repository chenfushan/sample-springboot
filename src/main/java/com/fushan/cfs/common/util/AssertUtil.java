package com.fushan.cfs.common.util;

import com.fushan.cfs.common.exception.SampleException;
import org.apache.commons.lang3.StringUtils;

/**
 * Assert utils
 * Created by alps on 2020/1/18.
 */
public class AssertUtil {

    /**
     * string equal util
     * if not equal throw sample exception
     * @param s1 first string
     * @param s2 second string
     */
    public static void equals(String s1, String s2) {
        if (!StringUtils.equals(s1, s2)) {
            throw new SampleException("string is not equals: s1="+s1+", s2="+s2);
        }
    }

    /**
     * bool value is true util
     * if not true throw sample exception
     * @param val bool value
     * @throws SampleException sample exception
     */
    public static void isTrue(boolean val) {
        if (!val) {
            throw new SampleException("val is not true.");
        }
    }
}
