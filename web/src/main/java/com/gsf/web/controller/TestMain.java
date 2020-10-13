package com.gsf.web.controller;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shuaifeng.gao
 * @since 2019-11-01 17:32
 **/
public class TestMain {

    public static void main(String[] args) {
        ExecutorService e = Executors.newSingleThreadExecutor();
        e.submit(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("!!!!!!!!");
            }
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

}
