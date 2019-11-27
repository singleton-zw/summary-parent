package org.singleton.summary.sort;

import java.util.Arrays;

/**
 * @author singleton_zw
 * @title: FindMin
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/6 14:25
 */
public class FindMin {
    public static void main(String[] args) {
        int[] data= {6,1,7,8,9,3,5,4,2};
        System.out.println(Arrays.toString(data));
        int min = data[0];
        for (int i = 1; i <data.length ; i++) {
            if (data[i]<min) min = data[i];
        }
        System.out.println(min);
    }
}
