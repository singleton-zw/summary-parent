package org.singleton.summary.leetcode.dp;

import java.util.Arrays;

/**
 * @author singleton_zw
 * @title: MaxSubArray
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/13 17:33
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {
                -2,-2,-1
//                ,1,-3,4,-1,2,1,-5,4
//                -2, 11, -4, 13, -5, -2
        };
        System.out.println(maxSubArray(nums));
//        maxSubArray(nums);
//        System.out.println(  MaxSubSequence(nums,nums.length));
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * <p>
     * 思路
     * 这道题用动态规划的思路并不难解决，比较难的是后文提出的用分治法求解，但由于其不是最优解法，所以先不列出来
     * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
     * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
     * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
     * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
     * 时间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        return 0;
    }

    /**
     *
     * @param nums
     * @return
     */
    static int maxSubSequence(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int sum =nums[0];
        for (int i = 0; i < nums.length; i++) {
//            System.out.println("循环首数据: " +nums[i]);
            for (int j = i; j < nums.length; j++) {
                int csum = 0;
                for (int k = i; k <= j; k++) {
//                    System.out.print(nums[k] + ",");
                    csum += nums[k];
//                    System.out.print("["+csum + " ] ");
                }
                //把最大值调换出来
                if(csum>sum){
                    sum = csum;
                }
//                System.out.println();
            }
        }
        return sum;
    }
}
