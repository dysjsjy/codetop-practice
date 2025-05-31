package com.dysjsjy;

import com.dysjsjy.Sample.ListNode;

public class F92 {
    class Solution {
        // 1, 2, 3, 4
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || left == right) {
                return head;
            }
            
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode leftHead = dummy;
            ListNode cur = head;
            
            for (int i = 1; i < left; i++) {
                leftHead = leftHead.next;
                cur = cur.next;
            }

            ListNode pre = null;

            // 2, 3, 4 , 5
            for (int i = left; i <= right; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            leftHead.next.next = cur;
            leftHead.next = pre;

            return dummy.next;
        }
    }
}
