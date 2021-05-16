
package cn.bif.general_list.p901_1000;

import cn.bif.common.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <br/>[993]二叉树的堂兄弟节点
 * <br/>在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <br/>
 * <br/> 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <br/>
 * <br/> 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <br/>
 * <br/> 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>
 * <br/>输入：root = [1,2,3,4], x = 4, y = 3
 * <br/>输出：false
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>
 * <br/>输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * <br/>输出：true
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>输入：root = [1,2,3,null,4], x = 2, y = 3
 * <br/>输出：false
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 二叉树的节点数介于 2 到 100 之间。
 * <br/> 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * <br/>
 * <br/>
 * <br/>
 * <br/> Related Topics 树 广度优先搜索
 * <br/> 👍 132 👎 0
 **/
public class P993_CousinsInBinaryTree {
    public static void main (String[] args) {
        Solution solution = new P993_CousinsInBinaryTree().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        solution.isCousins(root,3,4);
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isCousins (TreeNode root, int x, int y) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Set<Integer> set = new HashSet<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode.left != null && treeNode.right != null) {
                        if (treeNode.left.val == x && treeNode.right.val == y) {
                            return false;
                        }
                        
                        if (treeNode.right.val == x && treeNode.left.val == y) {
                            return false;
                        }
                    }
                    if (treeNode.left != null) {
                        set.add(treeNode.left.val);
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        set.add(treeNode.right.val);
                        queue.offer(treeNode.right);
                    }
                }
                
                if (set.contains(x) && set.contains(y)) {
                    return true;
                }
            }
            
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
