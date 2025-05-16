package com.dysjsjy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class S215 {
    // 数组中第k大的元素
    // 快速选择排序
    // 写的有问题，过几天看
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(nums[i]);
            }
            return quickSelect(list, k);
        }

        private int quickSelect(List<Integer> list, int k) {
            int random = (int) Math.random() * list.size();
            int cur = list.get(random);
            List<Integer> small = new ArrayList<>();
            List<Integer> equal = new ArrayList<>();
            List<Integer> big = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                int num = list.get(i)
                if (num > cur) {
                    big.add(num);
                } else if (num < cur) {
                    small.add(num);
                } else {
                    equal.add(num);
                }
            }

            if (k < big.size()) {
                int[] newNums = new int[big.size()];
                for (int i = 0; i < newNums.length; i++) {
                    newNums[i] = big.get(i);
                }

                findKthLargest(newNums, k);
            } else if (list.size() - small.size() < k) {
                int[] newNums = new int[small.size()];
                for (int i = 0; i < newNums.length; i++) {
                    newNums[i] = big.get(i);
                }

                findKthLargest(newNums, k - small.size());
            }

            return cur;
        }
    }
}
