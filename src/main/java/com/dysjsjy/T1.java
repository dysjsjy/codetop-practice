package com.dysjsjy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(nums[i], i);
            }

            for (int i = 0; i < n; i++) {
                int x = target - nums[i];
                Integer integer = map.get(x);
                if (integer != null && integer != i) {
                    ans[0] = i;
                    ans[1] = integer;
                    return ans;
                }
            }

            return ans;
        }
    }
}