package com.solution;


import com.share.solution.base.ListNode;
import com.sun.corba.se.spi.ior.iiop.IIOPFactories;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lgq create on 2020/10/2
 */
class Foo {


    private AtomicInteger num = new AtomicInteger();
    private ReentrantLock lock = new ReentrantLock();

    private Condition first = lock.newCondition();
    private Condition second = lock.newCondition();
    private Condition third = lock.newCondition();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        try {
            lock.lock();

            while (num.get() != 1) {
                first.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            num.getAndIncrement();
            second.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            lock.lock();

            while (num.get() != 2) {
                second.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            num.getAndIncrement();
            third.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        try {
            lock.lock();
            while (num.get() != 3) {
                third.wait();
            }
            printThird.run();
            num.decrementAndGet();
            first.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        // printThird.run() outputs "third". Do not change or remove this line.

    }


    public int maxArea(int[] height) {
        int len = height.length;
        if (len == 2) {
            return height[0] > height[1] ? height[1] * height[1] : height[0] * height[0];
        }

        int left = 0;

        int right = len - 1;

        int res = 0;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            res = Math.max(res, min * Math.abs(right - left));
            if (min == height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }


    public int maxValue(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];


        dp[0][0] = grid[0][0];
        dp[0][1] = grid[0][1] + dp[0][0];
        dp[1][0] = grid[1][0] + dp[0][0];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[row - 1][col - 1];
    }


    public ListNode sortList(ListNode head) {

        ListNode dummy = new ListNode(null);

        ListNode tem = head;
        while (head.next != null) {

            if (head.val > head.next.val) {
                dummy.next = head.next;
            }
        }
        return head;
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = mid(head);

        ListNode rev = rev(mid);

        boolean res = false;

        while (rev != null) {
            if (mid.val != rev.val) {
                return false;
            }
            mid = mid.next;
            rev = rev.next;
        }

        return true;

    }

    private ListNode rev(ListNode mid) {

        ListNode pre = null;

        ListNode curr = mid;

        ListNode temp = null;

        while (curr != null) {
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;
    }

    private ListNode mid(ListNode head) {
        ListNode k = head;
        ListNode m = head;
        while (k != null && k.next != null) {
            m = m.next;
            k = k.next.next;
        }

        return k;
    }

    //给定 nums = [2, 7, 11, 15], target = 9
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];

    }

    public static void main(String[] args) throws InterruptedException {

        Foo foo = new Foo();

        int i = foo.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }

}