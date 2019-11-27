package org.singleton.summary.leetcode;

import jdk.nashorn.internal.ir.IdentNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Time;

/**
 * @author singleton_zw
 * @title: ReverseInteger
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/4 12:59
 */
public class ReverseInteger {
    /**
     * 7. 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     */

    public static void main(String[] args) {
        Integer res = -1534236469;
        System.out.println(reverse(res));
    }

    public static Integer reverse(Integer x) {
        Integer w = 0,j = 0;
        while (x!=0){
            w =x%10;//得到一个数
            x =x/10;//得到下次的数
            /**
             * 需要处理溢出问题:
             * 溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE
             * 从ans * 10 + pop > MAX_VALUE这个溢出条件来看
             * 当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
             * 当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
             * 从ans * 10 + pop < MIN_VALUE这个溢出条件来看
             * 当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
             * 当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数
             *             7 = Integer.MAX_VALUE% 10
             *             -8 = Integer.MIN_VALUE% 10
             */
            if (j > Integer.MAX_VALUE/10 || (j == Integer.MAX_VALUE / 10 && w > 7)) return 0;
            if (j < Integer.MIN_VALUE/10 || (j == Integer.MIN_VALUE / 10 && w < -8)) return 0;
            j = j*10+w;
        }
        return j;
    }
}
