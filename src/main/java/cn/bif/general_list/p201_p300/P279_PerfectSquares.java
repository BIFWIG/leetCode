
package cn.bif.general_list.p201_p300;

/**
 * <br/>[279]完全平方数
 * <br/>给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <br/>
 * <br/> 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * <br/>
 * <br/> 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：n = 12
 * <br/>输出：3
 * <br/>解释：12 = 4 + 4 + 4
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：n = 13
 * <br/>输出：2
 * <br/>解释：13 = 4 + 9
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= n <= 104
 * <br/>
 * <br/> Related Topics 广度优先搜索 数学 动态规划
 * <br/> 👍 905 👎 0
 **/
public class P279_PerfectSquares {
    public static void main (String[] args) {
        Solution solution = new P279_PerfectSquares().new Solution();
        System.out.println(solution.numSquares(12));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares (int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = i;
                for (int j = 0; i >= j * j; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
                
            }
            
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
