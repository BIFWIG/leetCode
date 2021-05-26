package cn.bif.general_list.p1201_p1300;

/**
 * <br>有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * <br>
 * <br> 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * <br>
 * <br> 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * <br>
 * <br> 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <br>
 * <br>
 * <br>
 * <br> 示例 1：
 * <br>
 * <br> 输入：steps = 3, arrLen = 2
 * <br>输出：4
 * <br>解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * <br>向右，向左，不动
 * <br>不动，向右，向左
 * <br>向右，不动，向左
 * <br>不动，不动，不动
 * <br>
 * <br>
 * <br> 示例 2：
 * <br>
 * <br> 输入：steps = 2, arrLen = 4
 * <br>输出：2
 * <br>解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * <br>向右，向左
 * <br>不动，不动
 * <br>
 * <br>
 * <br> 示例 3：
 * <br>
 * <br> 输入：steps = 4, arrLen = 2
 * <br>输出：8
 * <br>
 * <br>
 * <br>
 * <br>
 * <br> 提示：
 * <br>
 * <br>
 * <br> 1 <= steps <= 500
 * <br> 1 <= arrLen <= 10^6
 * <br>
 * <br> Related Topics 动态规划
 * <br> 👍 90 👎 0
 *
 * @author Ted Wang
 * @created 2021/5/13 10:09 上午
 */
public class P1269 {
    
    public int numWays (int steps, int arrLen) {
        int mod = 1000000007;
        int maxCol = Math.min(steps, arrLen - 1);
        // dp[i][j] = dp[j-1][j-1] + dp[i-1][j]+dp[i-1][j+1]
        int[][] dp = new int[steps + 1][maxCol + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxCol; j++) {
                if (j == 0) {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) % mod;
                } else if (j == maxCol) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
                } else {
                    dp[i][j] = ((dp[i - 1][j] + dp[i - 1][j + 1]) % mod + dp[i - 1][j - 1]) % mod;
                }
            }
            
        }
        
        return dp[steps][0];
    }
    
    
    public static void main (String[] args) {
        P1269 p1269 = new P1269();
    
        System.out.println(p1269.numWays(4 ,2));
    
    
    }
}
