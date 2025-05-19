package com.dysjsjy;

public class T53 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int ans = nums[0];
            int[] cnt = new int[nums.length];
            int[] minSum = new int[nums.length];
            cnt[0] = nums[0];
            minSum[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                cnt[i] = nums[i] + cnt[i - 1];

                ans = Math.max(ans, Math.max(cnt[i] - minSum[i - 1], cnt[i]));
                minSum[i] = Math.min(minSum[i - 1], cnt[i]);
            }

            return ans;
        }

        public int maxSubArray2(int[] nums) { 
            int ans = nums[0];  
            int curSum = 0;
            int preMin = 0;

            for (int i = 0; i < nums.length; i++) {
                curSum += nums[i];
                ans = Math.max(ans, Math.max(curSum, curSum - preMin));
                preMin = Math.min(preMin, curSum);
            }

            return ans;
        }
    }
}
