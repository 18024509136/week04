package com.geek.week04;

/**
 * 使用标记变量和存储结果容器完成
 */
public class Demo1Flag {

    /**
     * 标识子线程结果可见的flag
     */
    private static volatile boolean FLAG = false;

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
            RETURN_VALUE = "子线程处理结果";
            FLAG = true;
        });
        thread.start();

        /**
         * 循环检查FLAG，直到子线程修改FLAG为true
         */
        while (!FLAG) {
            Thread.sleep(500);
        }

        System.out.println("主线程获取到子线程处理结果：" + RETURN_VALUE);


    }


}
