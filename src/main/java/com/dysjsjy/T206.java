package com.dysjsjy;

import com.dysjsjy.Sample.ListNode;

public class T206 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = null;
            ListNode cur = head;

            // null, 1, 2
            // 不能写成cur != null && cur.next != null，
            // 这样会导致最后一个节点不会被处理，
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            return pre;
        }
    }
}
