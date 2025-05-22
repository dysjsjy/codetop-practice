package com.dysjsjy;

public class F200 {
    class Solution {
        int[][] dic = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        public int numIslands(char[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        bfs(grid, i, j);
                        ans++;
                    }
                }
            }

            return ans;
        }

        void bfs(char[][] grid, int x, int y) {
            // 先做判断
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
                return;
            }

            grid[x][y] = '2';

            for (int[] d : dic) {
                int newX = x + d[0];
                int newY = y + d[1];

                bfs(grid, newX, newY);
            }
        }
    }
}
