package org.singleton.summary.sort;

import java.util.Arrays;

/**
 * @author singleton_zw
 * @title: SelectionSort
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/10/24 16:01
 * 工作原理是：第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
 * 然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] data = {6, 1, 7, 8, 9, 3, 5, 4, 2};
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(selectionSort(data)));
    }

    /**
     * 选择排序使用了线性查找来寻找最小值，因此在第 1 轮中需要比较 n -1 个数字，第
     * 2 轮需要比较 n -2 个数字……到第 n -1 轮的时候就只需比较 1 个数字了。因此，总的比
     * 较次数与冒泡排序的相同，都是 (n-1)+(n-2)+…+1 ≈ n2/2 次。
     * 每轮中交换数字的次数最多为 1 次。如果输入数据就是按从小到大的顺序排列的，
     * 便不需要进行任何交换。选择排序的时间复杂度也和冒泡排序的一样，都为 O(n2)。
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //最小数的索引
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                //找到最小数，并记录最小数的索引
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //交换符合条件的数
            if(minIndex!=i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
            System.out.println("排序中："+(i+1)+"轮： "+Arrays.toString(arr));
        }

        return arr;
    }
}
