package com.dysjsjy;

public class T121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int pre = prices[0];
            int ans = 0;

            for (int i = 0; i < prices.length; i++) {

                int cur = prices[i] - pre;

                if (ans < cur) {
                    ans = cur;
                }

                pre = Math.min(pre, prices[i]);
            }

            return ans;
        }
    }
}
