
package cn.bif.general_list.p1701_p1800;

import java.util.PriorityQueue;

/**
 * <br/>[1738]找出第 K 大的异或坐标值
 * <br/>给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * <br/>
 * <br/> 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下
 * <br/>标从 0 开始计数）执行异或运算得到。
 * <br/>
 * <br/> 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/> 输入：matrix = [[5,2],[1,6]], k = 1
 * <br/>输出：7
 * <br/>解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/> 输入：matrix = [[5,2],[1,6]], k = 2
 * <br/>输出：5
 * <br/>解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/> 输入：matrix = [[5,2],[1,6]], k = 3
 * <br/>输出：4
 * <br/>解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 * <br/>
 * <br/> 示例 4：
 * <br/>
 * <br/> 输入：matrix = [[5,2],[1,6]], k = 4
 * <br/>输出：0
 * <br/>解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> m == matrix.length
 * <br/> n == matrix[i].length
 * <br/> 1 <= m, n <= 1000
 * <br/> 0 <= matrix[i][j] <= 106
 * <br/> 1 <= k <= m * n
 * <br/>
 * <br/> Related Topics 数组
 * <br/> 👍 39 👎 0
 **/
public class P1738_FindKthLargestXorCoordinateValue {
    public static void main (String[] args) {
        
        Solution solution = new P1738_FindKthLargestXorCoordinateValue().new Solution();
        int[][] matrix = {{5, 2}, {1, 6}};
        System.out.println(solution.kthLargestValue(matrix, 3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthLargestValue (int[][] matrix, int k) {
            int[][] dp = new int[matrix.length][matrix[0].length];
            PriorityQueue<Integer> q = new PriorityQueue<>(k, (a, b)->a - b);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = matrix[i][j];
                        
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] ^ matrix[i][j];
                        
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] ^ matrix[i][j];
                        
                    } else {
                        dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i][j];
                    }
                    
                    if (q.size()<k){
                        q.add(dp[i][j]);
                    }else if (q.peek()<dp[i][j]){
                        q.poll();
                        q.add(dp[i][j]);
                    }
                    
                }
            }
            
            return q.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
