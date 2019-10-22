package org.singleton.summary.datastructure;

/**
 * @author singleton_zw
 * @title: Operation
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/10/22 10:31
 */
public class Operation {
    public static void main(String[] args) {
//       leftBitwiseOperators();
        basicBitwiseOperators();
    }

    /**
     * 皆属于位运算符.其运算比乘除快
     * 左移
     */
    public static void leftBitwiseOperators() {
        /**
         * 左移,左边补0
         * 左移一位相当于乘以2的一次方，左移n位相当于乘以2的n次方。
         * 下图相当于 1 * 2的1 次方 就是  2
         */
        System.out.println(1 << 1);
        /**
         *  2 * 2 的5 次方
         *  2 * 32
         */
        System.out.println("3 << 5:   " + (3 << 5));

        /**
         * 转二进制
         */
        Integer i = 18;
        System.out.println(Integer.toBinaryString(i));
    }

    /**
     * +=  和 += 的区别
     * 如果有一个不是整数，就有区别，再看下面一个例子：
     * a=‘3‘’,b=2;
     * a+=b;
     * System.out.println(a);  //不报错，因为“+=”会自动类型强制转换
     * a=a+b;
     * System.out.println(a); //报错，字符串类型不能与整数相加
     */
    public static void basicBitwiseOperators() {
        int n = 1;
        n += 16;
        String b = "2";
        System.out.println(n);
        b += n;
        System.out.println(b);
    }

}
