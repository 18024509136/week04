package com.geek.week04;

import java.util.concurrent.CountDownLatch;

public class Demo6CountDownLatch {

    /**
     * 承载子线程处理结果的变量
     */
    private static volatile String RETURN_VALUE;

    public static void main(String[] args) throws Exception {
        System.out.println("主线程开始");

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RETURN_VALUE = "子线程的处理结果";
            countDownLatch.countDown();
        });
        thread.start();

        countDownLatch.await();
        System.out.println("主线程获取到子线程处理结果：" + RETURN_VALUE);
    }
}
