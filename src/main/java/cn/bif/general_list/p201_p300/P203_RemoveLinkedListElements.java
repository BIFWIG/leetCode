package cn.bif.general_list.p201_p300;

import cn.bif.common.ListNode;

/**
 * <br/>[203]移除链表元素
 * <br/>给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：head = [1,2,6,3,4,5,6], val = 6
 * <br/>输出：[1,2,3,4,5]
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：head = [], val = 1
 * <br/>输出：[]
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：head = [7,7,7,7], val = 7
 * <br/>输出：[]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 列表中的节点在范围 [0, 104] 内
 * <br/> 1 <= Node.val <= 50
 * <br/> 0 <= k <= 50
 * <br/>
 * <br/> Related Topics 链表
 * <br/> 👍 631 👎 0
 **/
public class P203_RemoveLinkedListElements {
    public static void main (String[] args) {
        Solution solution = new P203_RemoveLinkedListElements().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeElements (ListNode head, int val) {
            ListNode cur = head;
            while (cur != null && cur.val == val) {
                cur = cur.next;
            }
            ListNode temp = cur;
            while (temp != null) {
                ListNode tempNext = temp.next;
                while (tempNext != null && tempNext.val == val) {
                    tempNext = tempNext.next;
                }
                temp.next = tempNext;
                temp = temp.next;
            }
            
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
