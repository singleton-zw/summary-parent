package org.singleton.summary.leetcode;

/**
 * @author singleton_zw
 * @title: AddTwoNumbers
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/11/1 13:57
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode = new  ListNode(3);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        forDatapt(listNode);
        System.out.println();
        ListNode listNodec = new  ListNode(1);
        listNode1 = new ListNode(6);
        listNode2 = new ListNode(1);
        listNodec.next = listNode1;
        listNode1.next = listNode2;
        forDatapt(listNodec);
        System.out.println();
//        ListNode listNode3 = addTwoNumbers(listNode, listNodec);
//        forDatapt(listNode3);
        System.out.println();
        ListNode listNode4 = addTwoNumbers1(listNode, listNodec);
        forDatapt(listNode4);

    }

    /**
     * 数组长度不一致
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * [1,8]
     * [0]
     * Output
     * [8,1]
     * Expected
     * [1,8]
     *
     * 将当前结点初始化为返回列表的哑结点。
     * 将进位 carrycarry 初始化为 00。
     * 将 pp 和 qq 分别初始化为列表 l1l1 和 l2l2 的头部。
     * 遍历列表 l1l1 和 l2l2 直至到达它们的尾端。
     * 将 xx 设为结点 pp 的值。如果 pp 已经到达 l1l1 的末尾，则将其值设置为 00。
     * 将 yy 设为结点 qq 的值。如果 qq 已经到达 l2l2 的末尾，则将其值设置为 00。
     * 设定 sum = x + y + carrysum=x+y+carry。
     * 更新进位的值，carry = sum / 10carry=sum/10。
     * 创建一个数值为 (sum \bmod 10)(summod10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
     * 同时，将 pp 和 qq 前进到下一个结点。
     * 检查 carry = 1carry=1 是否成立，如果成立，则向返回列表追加一个含有数字 11 的新结点。
     * 返回哑结点的下一个结点。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //存放结果
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            /**
             * 这里如果个数不同 会根据上面默认给0 来补0
             */
            int sum = carry + x + y;
            /**
             * 更新进位的值
             */
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    /**
     * 递归显示
     * @param listNode
     */
    private static void forDatapt(ListNode listNode) {
        System.out.print(listNode.val+",");
        if(listNode.next != null){
            forDatapt(listNode.next);
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
