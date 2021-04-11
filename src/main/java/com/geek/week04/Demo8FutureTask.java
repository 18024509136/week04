package com.geek.week04;

import java.util.concurrent.FutureTask;

/**
 * FutureTask方式
 */
public class Demo8FutureTask {

    public static void main(String[] args) throws Exception {
        System.out.println("主线程开始");

        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            Thread.sleep(4000);
            return "子线程的处理结果";
        });

        new Thread(futureTask).start();

        String result = futureTask.get();
        System.out.println("主线程获取到子线程处理结果：" + result);
    }
}
