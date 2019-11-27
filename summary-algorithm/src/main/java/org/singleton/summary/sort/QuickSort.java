package org.singleton.summary.sort;

import java.util.Arrays;

/**
 * @author singleton_zw
 * @title: QuickSort
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/10/24 16:14
 * 快速排序
 * 　算法思想：
 * 基于分治的思想，是冒泡排序的改进型。首先在数组中选择一个基准点（该基准点的选取可能影响快速排序的效率，后面讲解选取的方法），
 * 然后分别从数组的两端扫描数组，设两个指示标志（low指向起始位置，high指向末尾)，首先从后半部分开始，如果发现有元素比该基准点的值小，
 * 就交换low和high位置的值，然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换low和high位置的值，如此往复循环，直到low>=high,然后把基准点的值放到high这个位置。
 * 一次排序就完成了。以后采用递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了。
 * <p>
 * 分区  递归
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 1, 3, 8, 5, 7, 4, 3};
        System.out.println("排序前：" + Arrays.toString(arr) + "   大小：" + arr.length);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /** 递归
     * @param arr
     * @param left 开始的位置
     * @param right 结束的位置
     */
    private static void quickSort(int[] arr, int left, int right) {
        //结束标志
        if (left < right) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, left, right);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, 0, index - 1);
            quickSort(arr, index + 1, right);
        }
    }


    /**
     * 先右往左 在左往右
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;//向左移动
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];//
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;//归位
        return low; // 返回tmp的正确位置
    }
}
