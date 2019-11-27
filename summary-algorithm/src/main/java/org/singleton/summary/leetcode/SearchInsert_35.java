package org.singleton.summary.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author singleton_zw
 * @title: SearchInsert_35
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/26 12:36
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsert_35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(Arrays.toString(nums));
        System.out.println(searchDichotomy(nums, -1));
    }

    /** 直接用二分法
     * @param n
     * @param key
     * @return
     */
    private static int searchDichotomy(int[] n, int key) {
        int left = 0;
        int right = n.length-1;
        while (left <= right) {//结束的标志
            //重新计算中点值
            int middle = (left + right) / 2;
            if (key < n[middle]) {//说明在左边
                right = middle - 1;//下标往左移
            } else if (key > n[middle]) {
                left = middle + 1;
            } else {//查到
                return middle;
            }
        }
        return left;
    }

    /**
     * 两次遍历 时间长 可以优化一个
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int res = -1;//标志
        for (int i = 0; i < nums.length; i++) {
            //判断有没有
            if (target == nums[i]) {
                res = i;
                break;
            }
        }
        if (res == -1) {
            for (int i = 0; i < nums.length; i++) {
                //判断有没有
                if (target > nums[i]) {
                    res = (i + 1);//后移一位
                } else {
                    if (res == -1) {
                        res = i;//当前
                    }
                }
            }
        }
        return res;
    }


    /**
     * 使用标记
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int res = -1;//标志
        if (res == -1) {
            for (int i = 0; i < nums.length; i++) {
                //判断有没有
                if (target > nums[i]) {
                    res = (i + 1);//后移一位
                } else if (target <= nums[i]) {
                    if (res == -1) {
                        res = i;//当前
                    }
                }
            }
        }
        return res;
    }
}
