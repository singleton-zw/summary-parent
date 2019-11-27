package org.singleton.summary.leetcode.dp;

import java.util.Arrays;

/**
 * @author singleton_zw
 * @title: MinPathSum
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/18 15:59
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
//        System.out.println(minPathSum(grid));
        System.out.println(minPathSumDG(grid));
    }

    /**
     * 递归法
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public static int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }

    public static int minPathSumDG(int[][] grid) {
        return calculate(grid, 0, 0);
    }

    /**
     * 套路法
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        printSZ(grid);
        int i = grid.length;
        int j = grid[0].length;
        int[][] dp = new int[i][j];
        if(grid==null || i==0 || j==0) return 0;
        //初始化
        dp[0][0] = grid[0][0];
        for (int k = 1; k < i; k++) {
            dp[k][0] = dp[k-1][0]+grid[k][0];
        }
        for (int k = 1; k <j ; k++) {
            dp[0][k] = dp[0][k-1] + grid[0][k];
        }
        for (int k = 1; k < i ; k++) {
            for (int m = 1; m < j; m++) {
                dp[k][m] = Math.min(dp[k-1][m], dp[k][m-1]) + grid[k][m];
            }
        }
        return dp[i-1][j-1];
    }

    private static void printSZ(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j]+",");
            }
            System.out.println();
        }
    }
}
