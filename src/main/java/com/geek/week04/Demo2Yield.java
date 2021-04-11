package com.geek.week04;

/**
 * 使用存储结果容器和主线程让步完成
 */
public class Demo2Yield {

    /**
     * 承载子线程处理结果的变量
     */
    private static volatile String RETURN_VALUE;

    public static void main(String[] args) throws Exception {

        int initialThreadCount = Thread.activeCount();
        System.out.println("刚刚开始的线程总数为：" + initialThreadCount);

        System.out.println("主线程开始");

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RETURN_VALUE = "子线程处理结果";
        });
        thread.start();

        /**
         * 通过循环对比当前活动线程数和初始线程数，直到子线程销毁
         */
        while (Thread.activeCount() > initialThreadCount) {
            Thread.yield();
        }

        System.out.println("主线程获取到子线程处理结果：" + RETURN_VALUE);


    }


}
