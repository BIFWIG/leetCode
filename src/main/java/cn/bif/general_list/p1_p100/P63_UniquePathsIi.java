
package cn.bif.general_list.p1_p100;

/**
 * <br/>[63]不同路径 II
 * <br/>一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <br/>
 * <br/> 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <br/>
 * <br/> 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <br/>
 * <br/>
 * <br/>
 * <br/> 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * <br/>输出：2
 * <br/>解释：
 * <br/>3x3 网格的正中间有一个障碍物。
 * <br/>从左上角到右下角一共有 2 条不同的路径：
 * <br/>1. 向右 -> 向右 -> 向下 -> 向下
 * <br/>2. 向下 -> 向下 -> 向右 -> 向右
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：obstacleGrid = [[0,1],[0,0]]
 * <br/>输出：1
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> m == obstacleGrid.length
 * <br/> n == obstacleGrid[i].length
 * <br/> 1 <= m, n <= 100
 * <br/> obstacleGrid[i][j] 为 0 或 1
 * <br/>
 * <br/> Related Topics 数组 动态规划
 * <br/> 👍 563 👎 0
 **/
public class P63_UniquePathsIi {
    public static void main (String[] args) {
        Solution solution = new P63_UniquePathsIi().new Solution();
        int[][] nums = {{0,0},{1,0}};
        System.out.println(solution.uniquePathsWithObstacles2(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles (int[][] obstacleGrid) {
            // 朴素的二维dp
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                }
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                if (obstacleGrid[0][i] == 1) {
                    break;
                }
                dp[0][i] = 1;
            }
            
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        continue;
                    }
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
        
        public int uniquePathsWithObstacles2 (int[][] obstacleGrid) {
            // 使用滚动数组降阶
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[m-1][n-1]==1){
                return 0;
            }
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                if (obstacleGrid[0][i] == 1) {
                    break;
                }
                dp[i] = 1;
            }
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][0]==1){
                    dp[0]=0;
                }
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j]==1){
                        dp[j] = 0;
                    }else{
                        dp[j] = dp[j-1]+dp[j] ;
                    }
                }
            }
            
            return dp[n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
