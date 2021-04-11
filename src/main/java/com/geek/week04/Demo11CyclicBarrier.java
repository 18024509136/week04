package com.geek.week04;

import java.util.concurrent.*;

/**
 * 通过CyclicBarrier实现
 */
public class Demo11CyclicBarrier {

    /**
     * 承载子线程处理结果的变量
     */
    private static volatile String RETURN_VALUE;

    public static void main(String[] args) throws Exception {
        System.out.println("主线程开始");

        // 只要有2个线程调用了cyclicBarrier.await()，则2个线程均被唤醒继续
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            RETURN_VALUE = "子线程的处理结果";
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        cyclicBarrier.await();

        System.out.println("主线程获取到子线程处理结果：" + RETURN_VALUE);
    }
}
