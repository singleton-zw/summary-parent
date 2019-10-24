


package org.singleton.summary.datastructure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author singleton_zw
 * @title: Stack
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/10/22 16:50
 *
 */
public class Stack {
    public static void main(String[] args) {
        int n = 13;
        int t = n;

        Deque queue = new LinkedList();
        do{
            int m  = t % 2;
            //入栈
            queue.push(m);
//            System.out.println(m);
            t = t/2;
        }while (t> 0);

        while (!queue.isEmpty()){
            //出栈
            System.out.print(queue.pop());
        }
    }

}
