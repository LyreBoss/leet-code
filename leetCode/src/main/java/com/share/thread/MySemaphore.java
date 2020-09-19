package com.share.thread;

/**
 * @author Lgq create on 2020/9/19
 */
public class MySemaphore {
    /**
     * 信号量S
     */
    private int s;

    public MySemaphore(int s) {
        this.s = s;
    }

    /**
     * P原语，原子操作
     * <p>
     * S减decr，如果S小于0，阻塞当前线程
     */
    public synchronized void p(int decr) {
        s -= decr;
        if (s < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                // ...
            }
        }
    }

    /**
     * V原语，原子操作
     * <p>
     * S加incr，如果S小于等于0，唤醒一个等待中的线程
     */
    public synchronized void v(int incr) {
        s += incr;
        if (s <= 0) {
            notify();
        }
    }
}
