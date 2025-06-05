package com.dysjsjy;

import java.util.Arrays;

public class F300 {
    class Solution {

        public int lengthOfLIS(int[] nums) {
            int n = nums.length;

            int[] dp = new int[n];
            int ans = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                ans = Math.max(ans, ++dp[i]);
            }

            return ans;
        }

        // 请说明为什么这是错误的
        public int lengthOfLIS2(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];

            Arrays.fill(dp, 1);

            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                }
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }

            return dp[n - 1];
        }
    }
}
