package org.singleton.summary.leetcode;

/**
 * @author singleton_zw
 * @title: SearchDichotomy
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/26 16:23
 */
public class SearchDichotomy {
    public static void main(String[] args) {
        int n[] = {12, 23, 34, 45, 56, 67, 77, 89, 90};
        int key = 12;
        //电仪下标
        System.out.println(searchDichotomy(n, key));
    }

    private static int searchDichotomy(int[] n, int key) {
        int left = 0;
        int right = n.length;
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
        return -1;
    }
}
