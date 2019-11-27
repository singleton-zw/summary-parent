package org.singleton.summary.leetcode;

import java.util.Arrays;

/**
 * @author singleton_zw
 * @title: LongestCommonPrefix
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/6 17:10
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs  = {"flower","flow","flight"};
        longestCommonPrefix(strs);
    }

    /**
     *  14. 最长公共前缀
     *  编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * @param strs
     * @return
     */
    public static  String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String h = strs[i];
            for (int j = 0; j <  h.length(); j++) {
                System.out.print(h.charAt(j)+"-");
            }
            System.out.println(strs[i]);
        }
        System.out.println(Arrays.toString(strs));
        System.gc();
        return "";
    }
}
