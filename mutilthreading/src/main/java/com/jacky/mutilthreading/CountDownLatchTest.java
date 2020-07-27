package com.jacky.mutilthreading;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchTest
 *
 * @author liyj
 * @date 2020/7/27
 */

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "线程准备就绪");
                latch.countDown();
            }).start();
//            Thread.sleep(1000);
        }

//        latch.await();
        System.out.println(Thread.currentThread().getName() + "线程执行完毕");
    }

}
