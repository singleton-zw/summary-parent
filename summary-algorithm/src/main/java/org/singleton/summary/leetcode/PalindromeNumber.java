package org.singleton.summary.leetcode;

/**
 * @author singleton_zw
 * @title: PalindromeNumber
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/4 16:35
 */
public class PalindromeNumber {

    /**
     * 9. 回文数
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(12332101));
        System.out.println(isPalindromeStr(1));
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 8 ms	36.3 MB
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        /**
         * 整数 解法
         */
        if (x < 0) {
            return false;
        } else {
            Integer j = 0, temp;
            temp = x;
            while (temp != 0) {
                j = j * 10 + temp % 10;
                temp /= 10;//得到下次的数
            }
            return x == j ? true : false;

        }
    }

    /**
     * 10 ms	37.5 MB
     *
     * @param x
     * @return
     */
    public static boolean isPalindromeStr(int x) {
        /**
         * 字符串 解法
         */
        if (x < 0) {
            return false;
        } else {
            String s = String.valueOf(x);
            StringBuffer j = new StringBuffer(s.length());
            for (int i = s.length() - 1; i >= 0; i--) {
                j.append(s.charAt(i));
            }
            if (j.toString().equals(s)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isPalindromeGX(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

}