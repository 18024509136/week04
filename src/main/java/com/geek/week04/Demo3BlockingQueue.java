package com.geek.week04;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 使用BlockingQueue的take或者poll的阻塞特性完成
 */
public class Demo3BlockingQueue {

    private static ArrayBlockingQueue<String> resultQueue = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) throws Exception {
        System.out.println("主线程开始");

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(4000);
                resultQueue.put("子线程的处理结果");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        String result = resultQueue.poll(10000, TimeUnit.MILLISECONDS);
        System.out.println("主线程获取到子线程处理结果：" + result);
    }
}
