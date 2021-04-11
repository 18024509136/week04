package com.geek.week04;

/**
 * 隐含notifyAll()唤醒主线程的wait
 * 用线程对象本身作为锁，在线程业务逻辑跑完后，隐含调用了线程对象的notifyAll
 */
public class Demo12ImplicitWaitAndNotify {

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
            RETURN_VALUE = "子线程处理的结果";
        });

        thread.start();

        synchronized (thread) {
            thread.wait();
        }

        System.out.println("主线程获取到子线程处理结果：" + RETURN_VALUE);
    }
}
