package com.dysjsjy;

import com.dysjsjy.Sample.ListNode;

public record F25() {
    class Solution {
        // 分组
        // 1, 2, 3, 4, 5,
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0, head);
            ListNode pre = dummy;

            while (head != null) {
                ListNode tail = pre;
                for (int i = 0; i < k; i++) {
                    tail = tail.next;
                    if (tail == null) {
                        // 说明这里不需要翻转了
                        return dummy.next;
                    }
                }

                ListNode nextGroup = tail.next;
                // 反转当前 k 个节点，并获取反转后的头节点
                ListNode[] reversed = reverse(head, tail);
                head = reversed[0]; // 反转后的头
                tail = reversed[1]; // 反转后的尾

                pre.next = head;
                tail.next = nextGroup;
                pre = tail;
                head = nextGroup;
            }

            return dummy.next;
        }

        // 反转
        // 1, 2
        ListNode[] reverse(ListNode head, ListNode tail) {

            ListNode pre = null;
            ListNode cur = head;

            while (pre != tail) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            return new ListNode[] {pre, head};
        }
    }
}
