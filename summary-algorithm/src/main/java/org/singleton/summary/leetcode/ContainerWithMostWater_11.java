package org.singleton.summary.leetcode;

import java.util.Arrays;

/**
 * @author singleton_zw
 * @title: ContainerWithMostWater
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/29 12:11
 */
public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
//        int[] nums = {1,8,6,2,5,4,8,3,7};
        int[] nums = {3,2,1,5,1,6,1,7};
        System.out.println(Arrays.toString(nums));
        System.out.println(maxArea4(nums));
    }

    /**
     * 11. 盛最多水的容器
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * 示例:
     *
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i <height.length ; i++) {
            for (int j = i+1; j < height.length; j++) {
                //计算下标差值
                int c = j-i;
                int area = 0;
                //先判断大小
                if(height[i]>height[j]){
                    area = height[j] * c;
                }else {
                    area = height[i] * c;
                }
                if(area>max){
                    max = area;
                }
            }
        }
        return max;
    }

    /**
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        /**
         *  几种情况
         *  1、两个数最小值 中间个数查
         *  2、其实可以得出 以下公式：
         *   最小数 * 个数  坐标差 * 最小值
         */
        int max = 0;
        int area = 0;
        for (int i = 0; i <height.length ; i++) {
            for (int j = i+1; j < height.length; j++) {
                //先判断大小
                if(height[i]>height[j]){
                    area = height[j] * (j-i);
                }else {
                    area = height[i] * (j-i);
                }
                if(area>max){
                    max = area;
                }
            }
        }
        return max;
    }

    public static int maxArea3(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0,area = 0;
        while (left < right) {
            if (height[left] > height[right]) {//这里一般是最大值
                area = height[right] * (right - left);
                right--;
            } else {
                area = height[left] * (right - left);
                left++;
            }
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    public static int maxArea4(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
