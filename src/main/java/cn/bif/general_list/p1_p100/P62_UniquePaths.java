
package cn.bif.general_list.p1_p100;

import java.util.Arrays;

/**
 * <br/>[62]不同路径
 * <br/>一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <br/>
 * <br/> 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <br/>
 * <br/> 问总共有多少条不同的路径？
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：m = 3, n = 7
 * <br/>输出：28
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：m = 3, n = 2
 * <br/>输出：3
 * <br/>解释：
 * <br/>从左上角开始，总共有 3 条路径可以到达右下角。
 * <br/>1. 向右 -> 向下 -> 向下
 * <br/>2. 向下 -> 向下 -> 向右
 * <br/>3. 向下 -> 向右 -> 向下
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：m = 7, n = 3
 * <br/>输出：28
 * <br/>
 * <br/>
 * <br/> 示例 4：
 * <br/>
 * <br/>
 * <br/>输入：m = 3, n = 3
 * <br/>输出：6
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= m, n <= 100
 * <br/> 题目数据保证答案小于等于 2 * 109
 * <br/>
 * <br/> Related Topics 数组 动态规划
 * <br/> 👍 1014 👎 0
 **/
public class P62_UniquePaths {
    public static void main (String[] args) {
        Solution solution = new P62_UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3, 7));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths (int m, int n) {
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    // dp[j-1] 是前一个计算的
                    // dp[j] 是上一次计算的
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
            return dp[n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
