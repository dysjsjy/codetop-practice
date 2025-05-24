package com.dysjsjy;


// 反向遍历可以不用交换，交互了反而不好处理且写不出，
public class T88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int p = m + n - 1;

            while (p2 >= 0) {
                if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                    nums1[p] = nums1[p1];
                    p--;
                    p1--;
                } else {
                    nums1[p] = nums2[p2];
                    p--;
                    p2--;
                }
            }
        }
    }
}
