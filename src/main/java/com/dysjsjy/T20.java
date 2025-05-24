package com.dysjsjy;

import java.util.Deque;
import java.util.LinkedList;

public class T20 {

    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                char charAt = s.charAt(i);
                if (charAt == '{' || charAt == '[' || charAt == '(') {
                    stack.push(charAt);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    Character pop = stack.pop();
                    if (charAt == '}') {
                        if (!pop.equals('{')) {
                            return false;
                        }
                    } else if (charAt == ']') {
                        if (!pop.equals('[')) {
                            return false;
                        }
                    } else if (charAt == ')') {
                        if (!pop.equals('(')) {
                            return false;
                        }
                    }
                }
            }

            return stack.isEmpty();
        }
    }
}
