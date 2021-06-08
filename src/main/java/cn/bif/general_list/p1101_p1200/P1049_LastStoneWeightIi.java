
package cn.bif.general_list.p1101_p1200;

/**
 * <br/>[1049]最后一块石头的重量 II
 * <br/>有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <br/>
 * <br/> 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <br/>
 * <br/>
 * <br/> 如果 x == y，那么两块石头都会被完全粉碎；
 * <br/> 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * <br/>
 * <br/>
 * <br/> 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：stones = [2,7,4,1,8,1]
 * <br/>输出：1
 * <br/>解释：
 * <br/>组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * <br/>组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * <br/>组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * <br/>组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：stones = [31,26,33,21,40]
 * <br/>输出：5
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：stones = [1,2]
 * <br/>输出：1
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= stones.length <= 30
 * <br/> 1 <= stones[i] <= 100
 * <br/>
 * <br/> Related Topics 动态规划
 * <br/> 👍 186 👎 0
 **/
public class P1049_LastStoneWeightIi {
    public static void main (String[] args) {
        Solution solution = new P1049_LastStoneWeightIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastStoneWeightII (int[] stones) {
            int sum = 0;
            for (int stone : stones) {
                sum += stone;
            }
            int reg = sum / 2;
            int[][] dp = new int[stones.length + 1][reg + 1];
            for (int i = 1; i <= stones.length; i++) {
                for (int j = 0; j <= reg; j++) {
                    if (j >= stones[i - 1]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            
            return sum - dp[stones.length][reg] * 2;
        }
        
        
        public int lastStoneWeightII2 (int[] stones) {
            int sum = 0;
            for (int stone : stones) {
                sum += stone;
            }
            int reg = sum / 2;
            int[] dp = new int[reg + 1];
            
            for (int stone : stones) {
                for (int i = reg; i >= stone; i--) {
                   dp[i]= Math.max(dp[i],dp[i-stone]+stone);
                }
                
            }
            return sum - dp[reg] * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
