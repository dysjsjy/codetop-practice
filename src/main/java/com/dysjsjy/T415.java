package com.dysjsjy;

public class T415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();

            int n = num1.length();
            int m = num2.length();

            int pre = 0;

            while (n > 0 || m > 0) {
                int x = n > 0 ? num1.charAt(n - 1) - '0' : 0;
                int y = m > 0 ? num2.charAt(m - 1) - '0' : 0;

                int cur = x + y + pre;
                pre = 0;
                
                if (cur > 9) {
                    pre = cur / 10;
                    cur = cur % 10;
                }
                sb.append(cur);

                n--;
                m--;
            }

            if (pre != 0) {
                sb.append(pre);
            }

            return sb.reverse().toString();
        }
    }
}
