
package cn.bif.general_list.p801_p900;

/**
 * <br/>[879]盈利计划
 * <br/>集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <br/>
 * <br/> 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <br/>
 * <br/> 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * <br/>
 * <br/> 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * <br/>输出：2
 * <br/>解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * <br/>总的来说，有两种计划。
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * <br/>输出：7
 * <br/>解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
 * <br/>有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= n <= 100
 * <br/> 0 <= minProfit <= 100
 * <br/> 1 <= group.length <= 100
 * <br/> 1 <= group[i] <= 100
 * <br/> profit.length == group.length
 * <br/> 0 <= profit[i] <= 100
 * <br/>
 * <br/> Related Topics 动态规划
 * <br/> 👍 169 👎 0
 **/
public class P879_ProfitableSchemes {
    public static void main (String[] args) {
        Solution solution = new P879_ProfitableSchemes().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int profitableSchemes (int n, int minProfit, int[] group, int[] profit) {
            int len = group.length, MOD = (int) 1e9 + 7;
            
            // 任务，人数，价值
            int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
            
            dp[0][0][0] = 1;
            for (int i = 1; i <= len; i++) {
                //该任务要几个人
                int member = group[i - 1];
                // 该任务赚多少钱
                int earn = profit[i - 1];
                for (int j = 0; j <= n; j++) {
                    for (int k = 0; k <= minProfit; k++) {
                        if (j < member) {
                            dp[i][j][k] = dp[i - 1][j][k];
                        } else {
                            dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - member][Math.max(0, k - earn)]) % MOD;
                        }
                    }
                }
                
                
            }
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum = (sum + dp[len][i][minProfit]) % MOD;
            }
            
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
