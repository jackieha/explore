package com.gsf.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author shuaifeng.gao
 * @since 2020-05-04 16:01
 **/
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
            System.out.println("1MB");
        }
    }

}
