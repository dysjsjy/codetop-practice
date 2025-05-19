package com.dysjsjy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;


// 快速排序
// 之后试试堆排序
public class F912 {
    class Solution {
        public int[] sortArray(int[] nums) {
            List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<Integer> sort = sort(collect);
            int[] array = sort.stream().mapToInt(Integer::intValue).toArray();
            return array;
        }

        List<Integer> sort(List<Integer> list) {
            if (list.size() <= 1) {
                return list;
            }

            int n = list.size();
            Random random = new Random();
            int nextInt = random.nextInt(n);
            int cur = list.get(nextInt);

            List<Integer> bigList = new ArrayList<>();
            List<Integer> equaList = new ArrayList<>();
            List<Integer> smallList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = list.get(i);
                if (x > cur) {
                    bigList.add(x);
                } else if (x < cur) {
                    smallList.add(x);
                } else {
                    equaList.add(x);
                }
            }

            bigList = sort(bigList);
            smallList = sort(smallList);
            smallList.addAll(equaList);
            smallList.addAll(bigList);

            return smallList;
        }
    }
}
