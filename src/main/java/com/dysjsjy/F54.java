package com.dysjsjy;

import java.util.ArrayList;
import java.util.List;

public class F54 {
    class Solution {
        // 方向数组：右、下、左、上
        int[][] dicts = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new ArrayList<>();
            }

            int n = matrix.length;
            int m = matrix[0].length;
            List<Integer> ans = new ArrayList<>();

            int l = 0, r = m - 1, u = 0, d = n - 1; // 左右上下边界
            int x = 0, y = 0; // 当前坐标
            int idx = 0; // 方向索引

            while (l <= r && u <= d) {
                // 向右
                if (idx == 0) {
                    while (y <= r) {
                        ans.add(matrix[x][y]);
                        y++;
                    }
                    y--; // 回退一步
                    x++; // 准备向下
                    u++; // 更新上边界
                }
                // 向下
                else if (idx == 1) {
                    while (x <= d) {
                        ans.add(matrix[x][y]);
                        x++;
                    }
                    x--; // 回退一步
                    y--; // 准备向左
                    r--; // 更新右边界
                }
                // 向左
                else if (idx == 2) {
                    while (y >= l) {
                        ans.add(matrix[x][y]);
                        y--;
                    }
                    y++; // 回退一步
                    x--; // 准备向上
                    d--; // 更新下边界
                }
                // 向上
                else if (idx == 3) {
                    while (x >= u) {
                        ans.add(matrix[x][y]);
                        x--;
                    }
                    x++; // 回退一步
                    y++; // 准备向右
                    l++; // 更新左边界
                }
                idx = (idx + 1) % 4; // 切换方向
            }

            return ans;
        }
    }
}
