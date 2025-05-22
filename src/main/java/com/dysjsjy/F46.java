package com.dysjsjy;

import java.util.ArrayList;
import java.util.List;

public class F46 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            int n = nums.length;
            boolean[] userd = new boolean[n];

            travel(nums, userd, new ArrayList<>());

            return ans;
        }

        void travel(int[] nums, boolean[] userd, List<Integer> path) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
            }

            for (int i = 0; i < nums.length; i++) {
                if (userd[i]) {
                    continue;
                }

                userd[i] = true;
                path.add(nums[i]);
                travel(nums, userd, path);
                path.remove(path.size() - 1);
                userd[i] = false;
            }
        }
    }
}
