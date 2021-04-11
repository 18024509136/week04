package com.geek.week04;

/**
 * 通过子线程的join来阻塞主线程
 */
public class Demo5Join {

    /**
     * 承载子线程处理结果的变量
     */
    private static volatile String RETURN_VALUE;

    public static void main(String[] args) throws Exception {
        System.out.println("主线程开始");

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RETURN_VALUE = "子线程的处理结果";
        });
        thread.start();

        thread.join();

        System.out.println("主线程获取到子线程处理结果：" + RETURN_VALUE);
    }
}
