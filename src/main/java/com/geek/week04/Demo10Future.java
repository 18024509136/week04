package com.geek.week04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 通过线程池submit实现
 */
public class Demo10Future {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        System.out.println("主线程开始");

        Future<String> future = executorService.submit(() -> {
            return "子线程的处理结果";
        });

        String result = future.get();
        System.out.println("主线程获取到子线程处理结果：" + result);
    }
}
