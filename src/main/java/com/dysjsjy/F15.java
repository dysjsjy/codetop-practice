package com.dysjsjy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和
public class F15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 使用指针有顺序地取必须要先排序，
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                int x = nums[i];

                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = x + nums[l] + nums[r];
                    if (sum < 0) {
                        l++;
                    } else if (sum > 0) {
                        r--;
                    } else {
                        ans.add(Arrays.asList(x, nums[l], nums[r]));
                        for (l++ ; l > 0 && l < r && nums[l] == nums[l - 1]; l++)
                            ;
                        for (r-- ; r < nums.length - 1 && l < r && nums[r + 1] == nums[r]; r--)
                            ;
                    }
                }
            }

            return ans;
        }
    }
}
