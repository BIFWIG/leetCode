package cn.bif.general_list.p101_p200;

/**
 * <br/>[421]数组中两个数的最大异或值
 * <br/>给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <br/>
 * <br/> 进阶：你可以在 O(n) 的时间解决这个问题吗？
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums = [3,10,5,25,2,8]
 * <br/>输出：28
 * <br/>解释：最大运算结果是 5 XOR 25 = 28.
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums = [0]
 * <br/>输出：0
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：nums = [2,4]
 * <br/>输出：6
 * <br/>
 * <br/>
 * <br/> 示例 4：
 * <br/>
 * <br/>
 * <br/>输入：nums = [8,10,2]
 * <br/>输出：10
 * <br/>
 * <br/>
 * <br/> 示例 5：
 * <br/>
 * <br/>
 * <br/>输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * <br/>输出：127
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= nums.length <= 2 * 104
 * <br/> 0 <= nums[i] <= 231 - 1
 * <br/>
 * <br/>
 * <br/>
 * <br/> Related Topics 位运算 字典树
 * <br/> 👍 256 👎 0
 **/
public class P421_MaximumXorOfTwoNumbersInAnArray {
    public static void main (String[] args) {
        Solution solution = new P421_MaximumXorOfTwoNumbersInAnArray().new Solution();
        int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(solution.findMaximumXOR(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Trie root = new Trie();
        int height = 30;
        
        public int findMaximumXOR (int[] nums) {
            int max = 0;
            for (int i = 1; i < nums.length; i++) {
                add(nums[i-1]);
                max = Math.max(max, get(nums[i]));
            }
            return max;
        }
        
        /**
         * 描述 构建前缀树
         * @title
         * @author Ted Wang
         * @created 2021/5/16 2:07 上午
         *
         */
        public void add (int num) {
            Trie trie = root;
            
            for (int i = height; i >= 0; i--) {
                int b = (num >> i) & 1;
                if (b == 0) {
                    if (trie.zero == null) {
                        trie.zero = new Trie();
                    }
                    trie = trie.zero;
                    
                } else {
                    if (trie.one == null) {
                        trie.one = new Trie();
                    }
                    trie = trie.one;
                }
            }
           
        }
        /**
         * 描述
         * @title 查找
         * @author Ted Wang
         * @created 2021/5/16 2:07 上午
         *
         */
        public int get (int num) {
            Trie trie = root;
            int x = 0;
            for (int i = height; i >= 0; i--) {
                int b = (num >> i) & 1;
                // 因为要最大异或 所以=0 的时候走1 ，等于1的时候走0 ，除非不存在
                if (b == 0) {
                    if (trie.one == null) {
                        trie = trie.zero;
                        x = x * 2 ;
                    } else {
                        trie = trie.one;
                        x = x * 2 +1;
                    }
                } else {
                    if (trie.zero == null) {
                        trie = trie.one;
                        x = x * 2 +1;
                    } else {
                        trie = trie.zero;
                        x = x * 2;
                    }
                }
                
            }
            
            return x^num;
        }
        class Trie {
            Trie zero = null;
            Trie one = null;
        }
    }
    
   
//leetcode submit region end(Prohibit modification and deletion)

}
