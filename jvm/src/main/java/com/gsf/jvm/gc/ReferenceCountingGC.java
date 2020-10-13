package com.gsf.jvm.gc;

/**
 * @author shuaifeng.gao
 * @since 2020-05-04 16:12
 **/
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;


    private byte[] bigSzie = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();
        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        System.gc();
    }

}
