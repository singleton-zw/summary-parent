package org.singleton.summary.sort;

import java.util.Arrays;

/**
 * @author singleton_zw
 * @title: BubbleSort
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/10/24 14:15
 *
 * 冒泡排序
 * 基本思想: 冒泡排序，类似于水中冒泡，较大的数沉下去，较小的数慢慢冒起来，假设从小到大，即为较大的数慢慢往后排，较小的数慢慢往前排。
 * 直观表达，每一趟遍历，将一个最大的数移到序列末尾。
 *
 *
 * 冒泡排序的基本思想是：每次比较两个相邻的元素，如果它们的顺序错误就把它们交换过来。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,5,1,3,8,5,7,4,3};
        System.out.println("排序前："+Arrays.toString(arr)+"   大小："+arr.length);
        bubbleSort(arr);
    }

    /**
     * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     *   2. 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     *   3. 针对所有的元素重复以上的步骤，除了最后一个。
     *   4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * 时间复杂度：
     * 两层循环，第1次遍历n次(n个元素)，第二次遍历n-1次，... 依次类推。因此，表达式如下：
     * n + (n - 1) + (n - 2) + ... + 1 = n * (n + 1) / 2 = O(n^2)
     * 空间复杂度：
     * 没有利用新的数组来帮助完成排序算法，我们认为其空间复杂度为O(1)
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        for(int i = 0;i<arr.length ;i++){
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){//这里可以实现升序  降序
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j]= temp;
                }
            }
            System.out.println("第" + (i + 1) + "轮后: " + Arrays.toString(arr));
        }
        System.out.println("排序后："+Arrays.toString(arr));
    }
}