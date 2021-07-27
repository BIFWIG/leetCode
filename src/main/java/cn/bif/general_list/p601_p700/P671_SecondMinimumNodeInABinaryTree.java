
package cn.bif.general_list.p601_p700;

import cn.bif.common.TreeNode;

/**
 * <br/>[671]二叉树中第二小的节点
 * <br/>给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
 * <br/>个。
 * <br/>
 * <br/> 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * <br/>
 * <br/> 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：root = [2,2,5,null,null,5,7]
 * <br/>输出：5
 * <br/>解释：最小的值是 2 ，第二小的值是 5 。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：root = [2,2,2]
 * <br/>输出：-1
 * <br/>解释：最小的值是 2, 但是不存在第二小的值。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 树中节点数目在范围 [1, 25] 内
 * <br/> 1 <= Node.val <= 231 - 1
 * <br/> 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <br/>
 * <br/> Related Topics 树 深度优先搜索 二叉树
 * <br/> 👍 165 👎 0
 **/
public class P671_SecondMinimumNodeInABinaryTree {
    public static void main (String[] args) {
        Solution solution = new P671_SecondMinimumNodeInABinaryTree().new Solution();
        
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
        int ans = -1;
        
        public int findSecondMinimumValue (TreeNode root) {
            dfs(root, root.val);
            return ans;
        }
        
        void dfs (TreeNode root, int cur) {
           if (root==null){
               return;
           }
           if (root.val!=cur){
               if (ans==-1){
                   ans = root.val;
               }else{
                   ans = Math.min(ans,root.val);
                   return;
               }
               
           }
           dfs(root.left, cur);
           dfs(root.right,cur);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
