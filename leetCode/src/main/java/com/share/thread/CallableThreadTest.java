package com.share.thread;


import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Lgq create on 2020/9/22
 */
public class CallableThreadTest {


    Semaphore semaphore = new Semaphore(4);


    public void test() {


        try {
            semaphore.acquire();

            System.out.println("111");


            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
