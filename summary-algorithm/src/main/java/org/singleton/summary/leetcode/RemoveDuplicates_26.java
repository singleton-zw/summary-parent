package org.singleton.summary.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author singleton_zw
 * @title: RemoveDuplicates
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/18 16:54
 */
public class RemoveDuplicates_26 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
//        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates(nums));
//        HashMap
    }
    public static int removeDuplicates(int[] nums) {
        int b = 0;
        for (int i = 1; i < nums.length ; i++) {
            if(nums[b] != nums[i]){
                b++;
                nums[b] = nums[i];
            }
        }
        return  b+1;
    }
}
