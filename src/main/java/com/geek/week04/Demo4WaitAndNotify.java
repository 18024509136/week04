package com.geek.week04;

/**
 * 通过子线程的notify去唤醒主线程的wait
 */
public class Demo4WaitAndNotify {

    /**
     * 承载子线程处理结果的变量
     */
    private static volatile String RETURN_VALUE;

    public static void main(String[] args) {
        System.out.println("主线程开始");
        Demo4WaitAndNotify demo4WaitAndNotify = new Demo4WaitAndNotify();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RETURN_VALUE = "子线程的处理结果";

            synchronized (demo4WaitAndNotify) {
                // 唤醒主线程
                demo4WaitAndNotify.notifyAll();
            }
        });
        thread.start();

        synchronized (demo4WaitAndNotify) {
            try {
                // 主线程等待
                demo4WaitAndNotify.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("主线程获取到子线程处理结果：" + RETURN_VALUE);
    }
}
