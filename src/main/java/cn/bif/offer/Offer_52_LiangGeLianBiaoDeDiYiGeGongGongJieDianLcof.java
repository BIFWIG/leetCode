
package cn.bif.offer;

import cn.bif.common.ListNode;

/**
 * <br/>[剑指 Offer 52]两个链表的第一个公共节点
 * <br/>输入两个链表，找出它们的第一个公共节点。
 * <br/>
 * <br/> 如下面的两个链表：
 * <br/>
 * <br/>
 * <br/>
 * <br/> 在节点 c1 开始相交。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>
 * <br/> 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
 * <br/>kipB = 3
 * <br/>输出：Reference of the node with value = 8
 * <br/>输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
 * <br/>,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>
 * <br/> 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
 * <br/> 1
 * <br/>输出：Reference of the node with value = 2
 * <br/>输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
 * <br/>]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>
 * <br/> 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * <br/>输出：null
 * <br/>输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
 * <br/> skipA 和 skipB 可以是任意值。
 * <br/>解释：这两个链表不相交，因此返回 null。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 注意：
 * <br/>
 * <br/>
 * <br/> 如果两个链表没有交点，返回 null.
 * <br/> 在返回结果后，两个链表仍须保持原有的结构。
 * <br/> 可假定整个链表结构中没有循环。
 * <br/> 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <br/> 本题与主站 160 题相同：https:* <br/>leetcode-cn.com/problems/intersection-of-two-linked-lis
 * <br/>ts/
 * <br/>
 * <br/> Related Topics 哈希表 链表 双指针
 * <br/> 👍 291 👎 0
 **/
public class Offer_52_LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {
    public static void main (String[] args) {
        Solution solution = new Offer_52_LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();
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
        public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
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
