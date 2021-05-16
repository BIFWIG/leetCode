
package cn.bif.general_list.p1_p100;

import cn.bif.common.ListNode;

/**
 * <br/>[21]合并两个有序链表
 * <br/>将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：l1 = [1,2,4], l2 = [1,3,4]
 * <br/>输出：[1,1,2,3,4,4]
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：l1 = [], l2 = []
 * <br/>输出：[]
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：l1 = [], l2 = [0]
 * <br/>输出：[0]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 两个链表的节点数目范围是 [0, 50]
 * <br/> -100 <= Node.val <= 100
 * <br/> l1 和 l2 均按 非递减顺序 排列
 * <br/>
 * <br/> Related Topics 递归 链表
 * <br/> 👍 1707 👎 0
 **/
public class P21_MergeTwoSortedLists {
    public static void main (String[] args) {
        Solution solution = new P21_MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
            ListNode listNode = new ListNode();
            ListNode c = listNode;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    c.next = new ListNode(l2.val);
                    c = c.next;
                    l2 = l2.next;
                } else if (l2 == null) {
                    c.next = new ListNode(l1.val);
                    c = c.next;
                    l1 = l1.next;
                } else {
                    if (l1.val < l2.val) {
                        c.next = new ListNode(l1.val);
                        c = c.next;
                        l1 = l1.next;
                    } else {
                        c.next = new ListNode(l2.val);
                        c = c.next;
                        l2 = l2.next;
                    }
                    
                }
            }
            return listNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
