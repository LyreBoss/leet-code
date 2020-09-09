package com.share.solution.difficulty.one;

/**
 * 反转链表
 *
 * @author Lgq create on 2020-04-03
 */
public class ReverseList {

    class Solution {
        public ListNode reverseList(ListNode head) {
            //申请节点，pre和 cur，pre指向null
            ListNode pre = null;
            ListNode cur = head;
            ListNode tmp = null;
            while (cur != null) {
                //记录当前节点的下一个节点
                tmp = cur.next;
                //然后将当前节点指向pre
                cur.next = pre;
                //pre和cur节点都前进一位
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }
}
