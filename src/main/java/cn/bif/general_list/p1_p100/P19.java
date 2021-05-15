package cn.bif.general_list.p1_p100;

import cn.bif.common.ListNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <br>给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <br>
 * <br> 进阶：你能尝试使用一趟扫描实现吗？
 * <br>
 * <br>
 * <br>
 * <br> 示例 1：
 * <br>
 * <br>
 * <br>输入：head = [1,2,3,4,5], n = 2
 * <br>输出：[1,2,3,5]
 * <br>
 * <br>
 * <br> 示例 2：
 * <br>
 * <br>
 * <br>输入：head = [1], n = 1
 * <br>输出：[]
 * <br>
 * <br>
 * <br> 示例 3：
 * <br>
 * <br>
 * <br>输入：head = [1,2], n = 1
 * <br>输出：[1]
 * <br>
 * <br>
 * <br>
 * <br>
 * <br> 提示：
 * <br>
 * <br>
 * <br> 链表中结点的数目为 sz
 * <br> 1 <= sz <= 30
 * <br> 0 <= Node.val <= 100
 * <br> 1 <= n <= sz
 * <br>
 * <br> Related Topics 链表 双指针
 * <br> 👍 1354 👎 0
 *
 * @author Ted Wang
 * @created 2021/5/13 10:59 上午
 */
public class P19 {
    
    public ListNode removeNthFromEnd2 (ListNode head, int n) {
        ListNode l = new ListNode();
        l.next = head;
        ListNode start = l;
        ListNode end = l;
        while (n != 0) {
            end = end.next;
            n--;
        }
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        
        return l.next;
        
    }
    
    
    public ListNode removeNthFromEnd (ListNode head, int n) {
        Queue<ListNode> queue = new LinkedBlockingQueue<>(n + 1);
        ListNode cur = head;
        while (cur != null) {
            if (queue.size() < n + 1) {
                queue.offer(cur);
            } else {
                queue.poll();
                queue.offer(cur);
            }
            cur = cur.next;
            
        }
        if (queue.size() < n + 1) {
            // 没填满，说明移除的是第一个
            return head.next;
        }
        ListNode lastNode = queue.poll();
        ListNode removeNode = queue.poll();
        ListNode nextNode = queue.poll();
        lastNode.next = nextNode;
        
        
        return head;
    }
    
    
    public static void main (String[] args) {
        int[] numbers = {1};
        
        ListNode init = ListNode.init(numbers);
        System.out.println(init);
        ListNode listNode = new P19().removeNthFromEnd(init, 1);
        ListNode listNode2 = new P19().removeNthFromEnd2(init, 1);
        System.out.println(listNode);
        System.out.println(listNode2);
        
    }
    
}
