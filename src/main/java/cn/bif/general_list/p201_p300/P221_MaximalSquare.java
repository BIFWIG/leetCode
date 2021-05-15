
package cn.bif.general_list.p201_p300;

/**
 * <br/>[221]最大正方形
 * <br/>在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
 * <br/>,["1","0","0","1","0"]]
 * <br/>输出：4
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：matrix = [["0","1"],["1","0"]]
 * <br/>输出：1
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：matrix = [["0"]]
 * <br/>输出：0
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> m == matrix.length
 * <br/> n == matrix[i].length
 * <br/> 1 <= m, n <= 300
 * <br/> matrix[i][j] 为 '0' 或 '1'
 * <br/>
 * <br/> Related Topics 动态规划
 * <br/> 👍 764 👎 0
 **/
public class P221_MaximalSquare {
    public static void main (String[] args) {
        Solution solution = new P221_MaximalSquare().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare (char[][] matrix) {
            int[][] dp = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    //初始化
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                }
            }
            int max = 0;
            //dp[i][j]代表改方块作为正方形右下角时最大正方形的边长
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    // 如果本身就是0 ，那么不可能作为正方形中的一块
                    if (dp[i][j] == 0) {
                        continue;
                    }
                    // 不考虑上边缘和左边缘，这两个情况，该方块作为右下角时最大只能构成长度为1的正方形，也就是方块本身
                    if (i != 0 && j != 0) {
                        
                        // 这儿指的是 改方块作为右下角时，最大长度等于 上，左上 和左 三块方块 的最小dp值（类似木桶原理）再加本身长度1
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                    
                    max = Math.max(dp[i][j], max);
                }
                
            }
            return max * max;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
