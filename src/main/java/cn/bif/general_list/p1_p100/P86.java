/*
 * Copyright (c) 2005, 2019, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.bif.general_list.p1_p100;

import cn.bif.common.ListNode;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * <p>
 * <b>你应当保留两个分区中每个节点的初始相对位置。</b>
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 * <p>
 * Related Topics 链表 双指针
 * 👍 315 👎 0
 *
 * @author Ted Wang
 * @created 2021/1/3 11:49 上午
 */
public class P86 {
    
    public ListNode partition (ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode lessPoint = less;
        ListNode morePoint = more;
        ListNode current = head;
        
        while (current!=null){
            if (current.val<x){
                lessPoint.next = new ListNode(current.val);
                lessPoint = lessPoint.next;
            }else{
                morePoint.next = new ListNode(current.val);
                morePoint = morePoint.next;
            }
           current = current.next;
           
        }
        lessPoint.next = more.next;
        
        return less.next;
    }
    
    
    public static void main (String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.nextNode(4).nextNode(3).nextNode(2).nextNode(5).nextNode(2);
        ListNode partition = new P86().partition(listNode, 3);
        while (partition!=null){
            System.out.println(partition.val);
            partition=partition.next;
        }
    }
}
