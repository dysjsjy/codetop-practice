package com.dysjsjy;

import java.util.ArrayList;
import java.util.List;

import com.dysjsjy.Sample.ListNode;

public class F143 {
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return;
            }

            // 将所有节点存入 ArrayList
            List<ListNode> list = new ArrayList<>();
            ListNode current = head;
            while (current != null) {
                list.add(current);
                current = current.next;
            }

            // 使用双指针从两端向中间靠拢
            int left = 0;
            int right = list.size() - 1;
            ListNode dummy = new ListNode(0); // 辅助节点简化操作
            current = dummy;

            // 交替连接左右两端的节点
            while (left <= right) {
                // 先连接左端节点
                if (left == right) {
                    // 如果左右指针重合，只连接左端节点
                    current.next = list.get(left);
                    current = current.next;
                    break;
                } else {
                    // 连接左端节点
                    current.next = list.get(left);
                    current = current.next;
                    // 连接右端节点
                    current.next = list.get(right);
                    current = current.next;
                }
                left++;
                right--;
            }

            // 确保链表末尾为 null
            current.next = null;

            // 将 head 更新为新链表的头
            head = dummy.next;
        }
    }

    // 错误写法
    class Solution2 {
        public void reorderList(ListNode head) {
            if (head.next == null || head.next.next == null) {
                return;
            }

            List<ListNode> list = new ArrayList<>();

            ListNode l = head;
            while (l != null) {
                list.add(l);
                l = l.next;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode cur = head;
            ListNode begin = head;
            ListNode end = list.get(list.size() - 1);
            list.remove(list.size() - 1);

            boolean bo = true;

            while (begin != end) {
                if (bo) {
                    cur.next = end;
                    end = list.get(list.size() - 1);
                    list.remove(list.size() - 1);
                } else {
                    cur.next = begin;
                    begin = begin.next;
                }

                cur = cur.next;
                bo = !bo;
            }

        }
    }
}
