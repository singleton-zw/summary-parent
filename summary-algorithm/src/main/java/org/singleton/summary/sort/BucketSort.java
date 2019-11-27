package org.singleton.summary.sort;

import java.util.Arrays;

/**
 * @author singleton_zw
 * @title: BucketSort
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/10/29 13:30
 *
 * 复杂度的问题。代码中第 6 行的循环一共循环了 m 次（m 为桶的个数），第 9 行的代码循环了 n 次（n 为待排序数的个数），第 14 行和第 15 行一共循环了 m+n 次。
 * 所以整个排序算法一共执行了 m+n+m+n 次。我们用大写字母 O 来表示时间复杂度，因此该算法的时间复杂度是 O(m+n+m+n)即 O(2*(m+n))。我们在说时间复杂度的时候可以忽略较小
 * 的常数，最终桶排序的时间复杂度为 O(m+n)。还有一点，在表示时间复杂度的时候，n 和 m
 * 通常用大写字母即 O(M+N)。
 * 这是一个非常快的排序算法。桶排序从 1956 年就开始被使用，该算法的基本思想是由E.J.Issac 和 R.C.Singleton 提出来的。之前我说过，其实这并不是真正的桶排序算法，真正的
 * 桶排序算法要比这个更加复杂。但是考虑到此处是算法讲解的第一篇，我想还是越简单易懂 越好，真正的桶排序留在以后再聊吧。需要说明一点的是：我们目前学习的简化版桶排序算
 * 法，其本质上还不能算是一个真正意义上的排序算法
 */
public class BucketSort {
    /**
     *  简单版  桶排序：学习意义
     *  如果需要对数据范围在 0~1000 之间的整数进行排序，我们需要 1001 个桶来表示 0~1000
     * 之间每一个数出现的次数，这一点一定要注意。另外，此处的每一个桶的作用其实就是“标
     * 记”每个数出现的次数，
     *
     *  就是标记 把值和下标弄反  值是出现的次数在，下标才是真的值
     *
     *  需要是整数 还是根据排序值来设置桶数
     *  2019年10月29日14:39:51
     */
    public static void main(String[] args) {
        int[] arr = {5, 3, 5, 2, 8};
        System.out.println("排序前：" + Arrays.toString(arr) + "   大小：" + arr.length);
        //桶的数量  n+1
        int a[] = new int[11];
        //初始化桶为0
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        //标记
        for (int i = 0; i < arr.length; i++) {
            a[arr[i]]++;
        }
        System.out.println("标记后的数据：" + Arrays.toString(a) + "   大小：" + a.length);

        /**
         * 根据值打印下标
         */
        for (int i = 0; i <= 10; i++) { //依次判断a[0]~a[10]
            for (int j = 1; j <= a[i]; j++) { //出现了几次就打印几次
                System.out.print(i + ",");
            }
        }
    }
}
