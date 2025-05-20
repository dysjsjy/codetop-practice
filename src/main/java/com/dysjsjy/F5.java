package com.dysjsjy;

public class F5 {
    class Solution {

        // 1, 2, 1
        // 1, 2, 2, 1
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0)
                return "";
            if (s.length() == 1)
                return s;
            String ans = "";
            char[] charArray = s.toCharArray();
            int start = 0;
            int maxLen = 0;

            for (int i = 0; i < charArray.length; i++) {
                int l = i, r = i;

                while (l >= 0 && r < charArray.length && charArray[l] == charArray[r]) {
                    if ((r - l + 1) > maxLen) {
                        start = l;
                        maxLen = r - l + 1;
                    }
                    l--;
                    r++;
                }

                int l2 = i, r2 = i + 1;
                while (l2 >= 0 && r2 < charArray.length && charArray[l2] == charArray[r2]) {
                    if ((r2 - l2 + 1) > maxLen) {
                        start = l2;
                        maxLen = r2 - l2 + 1;
                    }
                    l2--;
                    r2++;
                }
            }

            ans = s.substring(start, start + maxLen);

            return ans;
        }
    }
}
