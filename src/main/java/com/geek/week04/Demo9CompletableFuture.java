package com.geek.week04;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture实现
 */
public class Demo9CompletableFuture {

    public static void main(String[] args) {
        System.out.println("主线程开始");

        String result = CompletableFuture.supplyAsync(() -> {
            return "子线程处理结果";
        }).join();

        System.out.println("主线程获取到子线程处理结果：" + result);
    }
}
