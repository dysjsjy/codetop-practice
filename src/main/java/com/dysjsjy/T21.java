
package com.dysjsjy;

import com.dysjsjy.Sample.ListNode;


// 合并两个有序列表
public class T21 {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }

                cur = cur.next;
            }

            cur.next = list1 == null ? list2 : list1;

            return dummy.next;
        }
    }
}