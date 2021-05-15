
package cn.bif.general_list.p101_p200;

import cn.bif.common.ListNode;

/**
 * <br/>[141]环形链表
 * <br/>给定一个链表，判断链表中是否有环。
 * <br/>
 * <br/> 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
 * <br/>位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <br/>
 * <br/> 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 进阶：
 * <br/>
 * <br/> 你能用 O(1)（即，常量）内存解决此问题吗？
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>
 * <br/> 输入：head = [3,2,0,-4], pos = 1
 * <br/>输出：true
 * <br/>解释：链表中有一个环，其尾部连接到第二个节点。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>
 * <br/> 输入：head = [1,2], pos = 0
 * <br/>输出：true
 * <br/>解释：链表中有一个环，其尾部连接到第一个节点。
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>
 * <br/> 输入：head = [1], pos = -1
 * <br/>输出：false
 * <br/>解释：链表中没有环。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 链表中节点的数目范围是 [0, 104]
 * <br/> -105 <= Node.val <= 105
 * <br/> pos 为 -1 或者链表中的一个 有效索引 。
 * <br/>
 * <br/> Related Topics 链表 双指针
 * <br/> 👍 1064 👎 0
 **/
public class P141_LinkedListCycle {
    public static void main (String[] args) {
        Solution solution = new P141_LinkedListCycle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle (ListNode head) {
            if (head == null) {
                return false;
            }
            if (head.next == head) {
                return true;
            }
            
            
            ListNode l1 = head;
            ListNode l2 = head;
            while (true) {
                if (l1.next == null || l2.next == null || l2.next.next == null) {
                    return false;
                }
                // 快慢指针， 如果有环，这两个一定能遇到
                l1 = l1.next;
                l2 = l2.next.next;
                
                
                if (l1.next == l2.next) {
                    return true;
                }
                
            }
            
            
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
