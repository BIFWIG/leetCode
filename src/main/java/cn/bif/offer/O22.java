/*
 * Copyright (c) 2005, 2019, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.bif.offer;

import cn.bif.common.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
 * 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * Related Topics 链表 双指针
 * 👍 79 👎 0
 *
 * @author Ted Wang
 * @created 2020/9/1 10:39 上午
 */
public class O22 {
    
    public ListNode getKthFromEnd (ListNode head, int k) {
        int total = 1;
        ListNode listNode = head;
        // 计算长度
        while (listNode.next != null) {
            listNode = listNode.next;
            total++;
        }
        int between = total - k;
        listNode = head;
        // 从前往后数 长度-k个
        for (int i = 0; i < between; i++) {
            listNode = listNode.next;
        }
        
        return listNode;
    }
    
    
    public ListNode getKthFromEnd2 (ListNode head, int k) {
        ListNode after = head;
        // 第二个指针位于 head 的k个后面
        for (int i = 0; i < k; i++) {
            after=  after.next;
        }
        // 当 第二个指针到最后，第一个指针就是需要的点
        while (after!=null){
            head = head.next;
            after = after.next;
        }
        
        return head;
    }
    
    public static void main (String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode kthFromEnd = new O22().getKthFromEnd2(listNode, 2);
        while (kthFromEnd != null) {
            System.out.println(kthFromEnd.val);
            kthFromEnd = kthFromEnd.next;
        }
        
        
    }
    
}
