package com.dysjsjy;

public class F33 {

    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int minIndex = findMinIndex(nums);

            if (target > nums[n - 1]) {
                return searchLow(nums, -1, minIndex, target);
            }

            return searchLow(nums, minIndex - 1, n, target);

        }

        int findMinIndex(int[] nums) {
            int n = nums.length;
            int l = -1, r = nums.length;

            // [4,5,6,7,0,1,2]
            while (l + 1 < r) {
                int mid = (l + r) >>> 1;
                if (nums[mid] > nums[n - 1]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }

            return r;
        }
        
        int searchLow(int[] nums, int l, int r, int target) {
            // 1, 2, 3, 4, 5
            while (l + 1 < r) {
                int mid = (l + r) >>> 1;
                if (nums[mid] >= target) {
                    r = mid;
                } else {
                    l = mid;
                }
            }

            return nums[r] == target ? r : -1;
        }
    }

}
