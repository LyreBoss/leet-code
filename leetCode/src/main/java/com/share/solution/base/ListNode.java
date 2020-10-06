package com.share.solution.base;

/**
 * @author Lgq create on 2020/9/19
 */
public class ListNode {

    public ListNode next;
    public int val;

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int x) {
        this.val = x;
    }
    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
