package cn.bif.general_list.p501_p600;

/**
 * <br/>[518]零钱兑换 II
 * <br/>给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1:
 * <br/>
 * <br/> 输入: amount = 5, coins = [1, 2, 5]
 * <br/>输出: 4
 * <br/>解释: 有四种方式可以凑成总金额:
 * <br/>5=5
 * <br/>5=2+2+1
 * <br/>5=2+1+1+1
 * <br/>5=1+1+1+1+1
 * <br/>
 * <br/>
 * <br/> 示例 2:
 * <br/>
 * <br/> 输入: amount = 3, coins = [2]
 * <br/>输出: 0
 * <br/>解释: 只用面额2的硬币不能凑成总金额3。
 * <br/>
 * <br/>
 * <br/> 示例 3:
 * <br/>
 * <br/> 输入: amount = 10, coins = [10]
 * <br/>输出: 1
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 注意:
 * <br/>
 * <br/> 你可以假设：
 * <br/>
 * <br/>
 * <br/> 0 <= amount (总金额) <= 5000
 * <br/> 1 <= coin (硬币面额) <= 5000
 * <br/> 硬币种类不超过 500 种
 * <br/> 结果符合 32 位符号整数
 * <br/>
 * <br/> 👍 416 👎 0
 **/
public class P518_CoinChange2 {
    public static void main (String[] args) {
        Solution solution = new P518_CoinChange2().new Solution();
        int[] coins = {1, 2, 5};
        System.out.println(solution.change(5, coins));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change (int amount, int[] coins) {
            int len = coins.length;
            int[][] dp = new int[len + 1][amount + 1];
            for (int i = 0; i <= len; i++) {
                dp[i][0] = 1;
            }
            
            for (int i = 1; i <= len; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j >= coins[i - 1]) {
                        dp[i][j] += dp[i][j - coins[i - 1]];
                    }
                    dp[i][j] += dp[i - 1][j];
                    
                }
            }
            return dp[len][amount];
        }
        
        public int change2 (int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            
            for (int coin : coins) {
                for (int i = 1; i <= amount; i++) {
                    if (coin <= i) {
                        dp[i] += dp[i - coin];
                    }
                    
                }
                
                
            }
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
