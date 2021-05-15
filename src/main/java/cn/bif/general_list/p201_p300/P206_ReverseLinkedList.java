
package cn.bif.general_list.p201_p300;

import cn.bif.common.ListNode;

/**
 * <br/>[206]反转链表
 * <br/>给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：head = [1,2,3,4,5]
 * <br/>输出：[5,4,3,2,1]
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：head = [1,2]
 * <br/>输出：[2,1]
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：head = []
 * <br/>输出：[]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 链表中节点的数目范围是 [0, 5000]
 * <br/> -5000 <= Node.val <= 5000
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <br/>
 * <br/>
 * <br/> Related Topics 链表
 * <br/> 👍 1737 👎 0
 **/
public class P206_ReverseLinkedList {
    public static void main (String[] args) {
        Solution solution = new P206_ReverseLinkedList().new Solution();
        int[] i = {0,1,4,-2};
        System.out.println(solution.reverseList(ListNode.init(i)));
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
        ListNode head;
        
        public ListNode reverseList (ListNode head) {
            
            if (head==null || head.next==null ){
                return head;
            }
            
            
            this.head = head;
            reverse(head);
            return this.head;
        }
        
        public ListNode reverse (ListNode cur) {
            if (cur.next == null) {
                this.head = cur;
                return cur;
            } else {
                ListNode reverse = reverse(cur.next);
                reverse.next = cur;
                cur.next = null;
            }
            
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
