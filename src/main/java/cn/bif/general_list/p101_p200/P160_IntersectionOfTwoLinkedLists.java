
package cn.bif.general_list.p101_p200;

import cn.bif.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <br/>[160]相交链表
 * <br/>给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <br/>
 * <br/> 图示两个链表在节点 c1 开始相交：
 * <br/>
 * <br/>
 * <br/>
 * <br/> 题目数据 保证 整个链式结构中不存在环。
 * <br/>
 * <br/> 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, sk
 * <br/>ipB = 3
 * <br/>输出：Intersected at '8'
 * <br/>解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * <br/>从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * <br/>在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
 * <br/>1
 * <br/>输出：Intersected at '2'
 * <br/>解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * <br/>从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * <br/>在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * <br/>输出：null
 * <br/>解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * <br/>由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * <br/>这两个链表不相交，因此返回 null 。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> listA 中节点数目为 m
 * <br/> listB 中节点数目为 n
 * <br/> 0 <= m, n <= 3 * 104
 * <br/> 1 <= Node.val <= 105
 * <br/> 0 <= skipA <= m
 * <br/> 0 <= skipB <= n
 * <br/> 如果 listA 和 listB 没有交点，intersectVal 为 0
 * <br/> 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 * <br/> Related Topics 链表
 * <br/> 👍 1174 👎 0
 **/
public class P160_IntersectionOfTwoLinkedLists {
    public static void main (String[] args) {
        Solution solution = new P160_IntersectionOfTwoLinkedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        /**
         * 描述
         * @title hash
         * @author Ted Wang
         * @created 2021/6/4 2:48 下午
         *
         */
        public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
            Set<ListNode> set = new HashSet<>();
            ListNode head = headA;
            
            while (head != null) {
                ListNode current = head;
                set.add(current);
                head = head.next;
            }
            head = headB;
            while (head != null) {
                if (set.contains(head)) {
                    return head;
                }
                head = head.next;
            }
            return null;
        }
        /**
         * 描述
         * @title 双指针
         * @author Ted Wang
         * @created 2021/6/4 2:48 下午
         *
         */
        public ListNode getIntersectionNode2 (ListNode headA, ListNode headB) {
            ListNode A = headA;
            ListNode B = headB;
            while(A != B){
                A = A != null ? A.next : headB;
                B = B != null ? B.next : headA;
            }
            return A;
        }
        
    }
//leetcode submit region end(Prohibit modification and deletion)

}
