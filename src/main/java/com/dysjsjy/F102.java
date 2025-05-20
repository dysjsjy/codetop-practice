package com.dysjsjy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.dysjsjy.Sample.TreeNode;

public class F102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            Deque<TreeNode> qDeque = new ArrayDeque<>();
            qDeque.offer(root);

            while (!qDeque.isEmpty()) {
                int curSize = qDeque.size();
                for (int i = 0; i < curSize; i++) {
                    TreeNode poll = qDeque.poll();

                    path.add(poll.val);

                    if (poll.left != null) {
                        qDeque.offer(poll.left);
                    }
                    if (poll.right != null) {
                        qDeque.offer(poll.right);
                    }
                }
                ans.add(new ArrayList<>(path));
                path.clear();
            }

            return ans;
        }
    }
}
