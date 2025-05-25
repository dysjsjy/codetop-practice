package com.dysjsjy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.dysjsjy.Sample.TreeNode;

public class F103 {
    class Solution {

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();

            if (root == null) {
                return ans;
            }

            List<Integer> path = new ArrayList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            boolean reverse = false;

            queue.push(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();

                    path.add(poll.val);

                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }

                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }

                // reverse是Collections里面提供的方法
                if (reverse) {
                    Collections.reverse(path);
                }

                ans.add(new ArrayList<>(path));
                path.clear();

                reverse = !reverse;
            }

            return ans;
        }
    }
}
