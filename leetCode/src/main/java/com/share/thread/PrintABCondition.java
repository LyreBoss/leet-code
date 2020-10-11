package com.share.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印abc
 *
 * @author Lgq create on 2020/10/8
 */
public class PrintABCondition {

    private ReentrantLock lock = new ReentrantLock(true);

    private Condition conditionA = lock.newCondition();

    private Condition conditionB = lock.newCondition();


    //决定打印A or 打印B 条件是否满足
    private volatile boolean printA = true;

    public void printA() throws InterruptedException{
        try {
            lock.lock();
            while (!printA) {
                //打印A的条件未满足,挂起线程,放弃cpu,进入WAITING状态
                conditionA.await();
            }
            //打印A的条件满足了,打印A
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName() + " print A");
            }
            //模拟方法执行耗时
            Thread.sleep(1500);
            //A 已经打印完毕, 使得打印B的条件满足, 接下来发送通知 唤醒打印B的线程
            printA = false;
            //conditionB.signal();
        }finally {
            lock.unlock();
        }
    }

    public void printB() throws InterruptedException{
        try {
            lock.lock();
            while (printA) {
                //打印B的条件未满足,挂起线程,放弃cpu,进入WAITING状态
                conditionB.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " print B");
            }
            Thread.sleep(2000);
            //B 已打印完毕,使得打印A的条件满足,接下来发送通知 唤醒打印A的线程
            printA = true;
            //conditionA.signal();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        PrintABCondition pab = new PrintABCondition();
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    pab.printA();
                } catch (InterruptedException e) {
                    //响应中断
                    break;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    pab.printB();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
