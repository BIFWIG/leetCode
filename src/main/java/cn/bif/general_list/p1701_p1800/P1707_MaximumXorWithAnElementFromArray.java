
package cn.bif.general_list.p1701_p1800;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <br/>[1707]与数组中元素的最大异或值
 * <br/>给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * <br/>
 * <br/> 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR
 * <br/> xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * <br/>
 * <br/> 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个
 * <br/>查询的答案。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/> 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * <br/>输出：[3,3,7]
 * <br/>解释：
 * <br/>1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 * <br/>2) 1 XOR 2 = 3.
 * <br/>3) 5 XOR 2 = 7.
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/> 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * <br/>输出：[15,-1,5]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= nums.length, queries.length <= 105
 * <br/> queries[i].length == 2
 * <br/> 0 <= nums[j], xi, mi <= 109
 * <br/>
 * <br/> Related Topics 位运算 字典树
 * <br/> 👍 70 👎 0
 **/
public class P1707_MaximumXorWithAnElementFromArray {
    public static void main (String[] args) {
        Solution solution = new P1707_MaximumXorWithAnElementFromArray().new Solution();
        int[] nums = {0, 1, 2, 3, 4};
        int[][] queries = {{3, 1}, {1, 3}, {5, 6}};
        int[] nums2 = {536870912, 0, 534710168, 330218644, 142254206};
        int[][] queries2 = {{558240772, 1000000000}, {307628050, 1000000000}, {3319300, 1000000000}, {2751604, 683297522}, {214004, 404207941}};
        int[] nums3 = {5, 2, 4, 6, 6, 3};
        int[][] queries3 = {{12, 4}, {8, 1}, {6, 3}};
        int[] nums4 = {5,8,0,3,2,10,9,2,4,5};
        int[][] queries4 = {{3,8}};
        System.out.println(Arrays.toString(solution.maximizeXor(nums4, queries4)));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int height = 30;
        
        public int[] maximizeXor (int[] nums, int[][] queries) {
            Arrays.sort(nums);
            int length = queries.length;
            int[] result = new int[length];
            int[][] indexedQueries = new int[length][3];
            
            for (int i = 0; i < queries.length; i++) {
                indexedQueries[i][0] = queries[i][0];
                indexedQueries[i][1] = queries[i][1];
                indexedQueries[i][2] = i;
                
            }
            
            Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a[1]));
            
            int index = 0;
            Trie trie = new Trie();
            for (int i = 0; i < length; i++) {
                
                
                if (indexedQueries[i][1] < nums[0]) {
                    result[indexedQueries[i][2]] = -1;
                } else {
                    while (index < nums.length && nums[index] <= indexedQueries[i][1]) {
                        add(nums[index++], trie);
                        
                    }
    
                    System.out.println(indexedQueries[i][0]);
                    System.out.println(get(indexedQueries[i][0],trie));
    
                    result[indexedQueries[i][2]] = indexedQueries[i][0] ^ get(indexedQueries[i][0], trie);
                }
            }
            return result;
        }
        
        
        public void add (int num, Trie root) {
            
            Trie c = root;
            for (int i = height; i >= 0; i--) {
                int b = (num >> i) & 1;
                if (b == 0) {
                    if (c.left == null) {
                        c.left = new Trie();
                    }
                    c = c.left;
                } else {
                    if (c.right == null) {
                        c.right = new Trie();
                    }
                    c = c.right;
                }
            }
        }
        
        
        public int get (int target, Trie root) {
            Trie trie = root;
            int x = 0;
            for (int i = height; i >= 0; i--) {
                int b = (target >> i) & 1;
                if (b == 0) {
                    if (trie.right != null) {
                        x = x * 2 + 1;
                        trie = trie.right;
                    } else {
                        x = x * 2;
                        trie = trie.left;
                    }
                } else {
                    if (trie.left != null) {
                        x = x * 2;
                        trie = trie.left;
                    } else {
                        x = x * 2 + 1;
                        trie = trie.right;
                    }
                }
            }
            return x;
        }
        
        class Trie {
            Trie left = null;
            Trie right = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
