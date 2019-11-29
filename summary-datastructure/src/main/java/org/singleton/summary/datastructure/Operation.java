
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
       leftBitwiseOperators();
//        rightBitwiseOperators();
//        basicBitwiseOperators();
//        addBitwiseOperators();
    }

    /**
     * 皆属于位运算符.其运算比乘除快
     * https://blog.csdn.net/koreyoshi326/article/details/85008708
     * 左移
     */
    public static void leftBitwiseOperators() {
        /**
         * 左移,左边补0
         * 左移一位相当于乘以2的一次方，左移n位相当于乘以2的n次方。
         * 下图相当于 1 * 2的1 次方 就是  2
         */
        System.out.println((29 << 113)%113);
        /**
         *  2 * 2 的5 次方
         *  2 * 32
         */
        System.out.println("3 << 5:   " + (1 << 3));

        /**
         * 转二进制
         */
        Integer i = (-3 << 2);
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
    }



    public static void rightBitwiseOperators() {
        /**
         * 右移,右边补0
         * 右移一位相当于除以2的一次方，右移n位相当于除以2的n次方。
         * 下图相当于 1 / 2的1 次方 就是  2  取模
         */
        int  s = -9 >> 2;
        System.out.println(s);
//        /**
//         *  2 * 2 的5 次方
//         *  2 * 32
//         */
//        System.out.println("3 << 5:   " + (3 << 5));
//
//        /**
//         * 转二进制
//         */
//        Integer i = 18;
        System.out.println(Integer.toBinaryString(s));
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

    /**
     * j=j++和j=++j
     * 在这里JVM里面有两个存储区，一个是暂存区（以下称为堆栈），另一个是变量区。
     * j=j++是先将j的值（0，原始值）存入堆栈中（对应图中分配一块新的内存空间），然后对变量区中j自加1，这时j的值确实是1，但随后将堆栈中的值赋给变量区的j，所以最后j=0;
     * 而j=++j，是先对变量区中的j加1，再将变量区中的j值（1）存入堆栈，最后将堆栈中的值赋给自变量区的j，所以j=1;
     * <p>
     * 总结： java使用了中间缓存变量的机制
     * 对于j=j++可以换种写法：
     * temp=j;
     * j=j+1;
     * j=temp;
     * 对于j=++j可以换种写法：
     * j=j+1;
     * temp=j;
     * j=temp;
     */
    public static void addBitwiseOperators() {
        int j = 0;
        int g = 0;
        for (int i = 0; i < 10; i++) {
            j = j++;

            g = ++g;
//            System.out.println(j++);
        }
        System.out.println(j);
        System.out.println(g);
    }

}



