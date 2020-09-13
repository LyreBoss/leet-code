package com.share.design;

/**
 * @author Lgq create on 2020/9/10
 */
public class ThreadTest {


    private int threadId = 1;

    public void testA() throws InterruptedException {
        synchronized (this) {
            while (threadId != 1) {
                this.wait();
            }
            System.out.println("A");
            threadId = 2;
            this.notifyAll();
        }
    }

    public void testB() throws InterruptedException {
        synchronized (this) {
            while (threadId != 2) {
                this.wait();
            }
            System.out.println("B");
            threadId = 3;
            this.notifyAll();
        }
    }

    public void testC() throws InterruptedException {
        synchronized (this) {
            while (threadId != 3) {
                this.wait();
            }
            System.out.println("C");
            threadId = 1;
            this.notifyAll();
        }
    }
}
