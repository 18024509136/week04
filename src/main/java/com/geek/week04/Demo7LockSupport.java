package com.geek.week04;

import java.util.concurrent.locks.LockSupport;

/**
 * 通过lock support实现
 * 子线程可能比较难拿到主线程的线程对象去unpark。但是子线程和父线程属于同一线程组，
 * 可以通过线程组的interrupt()方法来唤醒主线程的park
 */
public class Demo7LockSupport {

    /**
     * 承载子线程处理结果的变量
     */
    private static volatile String RETURN_VALUE;

    public static void main(String[] args) {
        System.out.println("主线程开始");

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RETURN_VALUE = "子线程的处理结果";

            /**
             * 这里可能比较难拿到主线程的线程对象去unpark。但是子线程和父线程属于同一线程组，
             * 可以通过线程组的interrupt()方法来唤醒主线程的park
             */
            Thread.currentThread().getThreadGroup().interrupt();
        });
        thread.start();

        LockSupport.park();

        System.out.println("主线程获取到子线程处理结果：" + RETURN_VALUE);
    }
}
