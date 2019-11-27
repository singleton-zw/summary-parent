package org.singleton.summary.leetcode;

/**
 * @author singleton_zw
 * @title: Sqrtx_69
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/27 11:09
 * 69. x 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Sqrtx_69 {
    public static void main(String[] args) {
        System.out.println(mySqrt2(4));
    }

    /**
     * 例如，我想求根号 22 等于多少。假如我猜测的结果为 44，虽然错的离谱，但你可以看到使用牛顿迭代法后这个值很快就趋近于根号 22 了：
     *
     * ( 4 + 2/ 4 ) / 2 = 2.25
     * ( 2.25 + 2/ 2.25 ) / 2 = 1.56944..
     * ( 1.56944..+ 2/1.56944..) / 2 = 1.42189..
     * ( 1.42189..+ 2/1.42189..) / 2 = 1.41423..
     * 递归的方式
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int s = x;
        if(x == 0){
            return 0;
        }
        return (int) sqrts(x,s);
    }
    public static double sqrts(double x,int s){
        double res = (x + s / x) / 2;
        if (res == x) { //这次结果等于上次的结果
            return x;
        } else {
            return sqrts(res,s);
        }
    }

    /**
     * 二分法
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        // 为了照顾到 0 把左边界设置为 0
        long left = 0;
        // # 为了照顾到 1 把右边界设置为 x // 2 + 1
        long right = x / 2 + 1;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;

    }
}
