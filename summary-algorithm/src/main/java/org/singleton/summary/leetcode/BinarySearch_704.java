package org.singleton.summary.leetcode;

import java.util.Arrays;

/**
 * @author singleton_zw
 * @title: BinarySearch
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/27 10:01
 *
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
    输入: nums = [-1,0,3,5,9,12], target = 9
    输出: 4
    解释: 9 出现在 nums 中并且下标为 4
    示例 2:

    输入: nums = [-1,0,3,5,9,12], target = 2
    输出: -1
    解释: 2 不存在 nums 中因此返回 -1
     
    提示：

    你可以假设 nums 中的所有元素是不重复的。
    n 将在 [1, 10000]之间。
    nums 的每个元素都将在 [-9999, 9999]之间。


 */
public class BinarySearch_704 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(Arrays.toString(nums));
        System.out.println(search2(nums, 2));
    }

    /**
     * 基本操作
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            int middle = (left+right) >>> 1;//计算中间值
            if(nums[middle] == target)
                return middle;
            else if(nums[middle] < target)
                left = middle+1;
            else
                right = middle -1;
        }
        return  -1;
    }

    /**
     * 区间问题
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int middle = (left+right) >>> 1;//计算中间值
            if(nums[middle] == target)
                return middle;
            else if(nums[middle] < target)
                left = middle+1;
            else
                right = middle-1;
        }
        return  -1;
    }
}
