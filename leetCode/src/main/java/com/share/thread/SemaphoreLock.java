package com.share.thread;

/**
 * @author Lgq create on 2020/9/19
 */
public class SemaphoreLock {

    private final MySemaphore semaphore = new MySemaphore(1);

    public void lock() {
        semaphore.p(1);
    }

    public void unlock() {
        semaphore.v(1);
    }

}
