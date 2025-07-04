package com.dysjsjy;

import java.util.Random;

public class S215 {
    // 数组中第k大的元素
    // 快速选择算法
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        private int quickSelect(int[] nums, int left, int right, int kSmallest) {
            if (left == right) {
                return nums[left];
            }
            Random rand = new Random();
            int pivotIndex = left + rand.nextInt(right - left + 1);
            pivotIndex = partition(nums, left, right, pivotIndex);
            if (kSmallest == pivotIndex) {
                return nums[kSmallest];
            } else if (kSmallest < pivotIndex) {
                return quickSelect(nums, left, pivotIndex - 1, kSmallest);
            } else {
                return quickSelect(nums, pivotIndex + 1, right, kSmallest);
            }
        }

        private int partition(int[] nums, int left, int right, int pivotIndex) {
            int pivot = nums[pivotIndex];
            swap(nums, pivotIndex, right);
            int storeIndex = left;
            for (int i = left; i < right; i++) {
                if (nums[i] < pivot) {
                    swap(nums, storeIndex, i);
                    storeIndex++;
                }
            }
            swap(nums, storeIndex, right);
            return storeIndex;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
