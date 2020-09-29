

package cn.bif.general_list.p1_p100;

import cn.bif.common.ListNode;

import java.util.List;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * Related Topics 堆 链表 分治算法
 * 👍 909 👎 0
 **/
public class P23 {
    public static void main (String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode7.next = listNode8;
        ListNode[] listNodes = {listNode1, listNode4, listNode7};
        ListNode listNode = new P23().mergeKLists(listNodes);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    
    public ListNode mergeKLists (ListNode[] lists) {
        ListNode start = new ListNode(-1);
        ListNode current = start;
        while (true) {
            ListNode min = null;
            int i = 0;
            for (int j = 0; j < lists.length; j++) {
                if (lists[j] == null) {
                    continue;
                }
                if (min == null) {
                    min = lists[j];
                    i = j;
                } else {
                    if (min.val > lists[j].val) {
                        min = lists[j];
                        i = j;
                    }
                }
            }
            if (min == null) {
                break;
            }
            
            current.next = lists[i];
            current = current.next;
            lists[i] = lists[i].next;
        }
        return start.next;
    }
}
