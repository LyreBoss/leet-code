package com.share.solution.difficulty.one;

import com.share.solution.base.ListNode;

/**
 * 反转链表
 * 1、记录当前节点的下一个节点
 * 2、将当前节点指向pre前置节点
 * 3、将pre前置节点和cur当前节点前进一位
 *
 * @author Lgq create on 2020-04-03
 */
public class
ReverseList {

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
