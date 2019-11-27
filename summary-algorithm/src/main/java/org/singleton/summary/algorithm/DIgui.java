package org.singleton.summary.algorithm;

/**
 * @author singleton_zw
 * @title: DIgui
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/22 13:14
 */
public class DIgui {
    public static void main(String[] args) {
        new DIgui().test(5);
    }

    public void test(int n){
        if(n>2){
            test(n-1);
            System.out.println("--");
        }
//        else {
            System.out.printf("n=%d\n", n);
//        }
    }

}
