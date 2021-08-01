
package cn.bif.general_list.p1301_p1400;

import java.util.PriorityQueue;

/**
 * <br/>[1337]矩阵中战斗力最弱的 K 行
 * <br/>给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * <br/>
 * <br/> 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * <br/>
 * <br/> 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * <br/>
 * <br/> 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：mat =
 * <br/>[[1,1,0,0,0],
 * <br/> [1,1,1,1,0],
 * <br/> [1,0,0,0,0],
 * <br/> [1,1,0,0,0],
 * <br/> [1,1,1,1,1]],
 * <br/>k = 3
 * <br/>输出：[2,0,3]
 * <br/>解释：
 * <br/>每行中的军人数目：
 * <br/>行 0 -> 2
 * <br/>行 1 -> 4
 * <br/>行 2 -> 1
 * <br/>行 3 -> 2
 * <br/>行 4 -> 5
 * <br/>从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：mat =
 * <br/>[[1,0,0,0],
 * <br/> [1,1,1,1],
 * <br/> [1,0,0,0],
 * <br/> [1,0,0,0]],
 * <br/>k = 2
 * <br/>输出：[0,2]
 * <br/>解释：
 * <br/>每行中的军人数目：
 * <br/>行 0 -> 1
 * <br/>行 1 -> 4
 * <br/>行 2 -> 1
 * <br/>行 3 -> 1
 * <br/>从最弱到最强对这些行排序后得到 [0,2,3,1]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> m == mat.length
 * <br/> n == mat[i].length
 * <br/> 2 <= n, m <= 100
 * <br/> 1 <= k <= m
 * <br/> matrix[i][j] 不是 0 就是 1
 * <br/>
 * <br/> Related Topics 数组 二分查找 矩阵 排序 堆（优先队列）
 * <br/> 👍 90 👎 0
 **/
public class P1337_TheKWeakestRowsInAMatrix {
    public static void main (String[] args) {
        Solution solution = new P1337_TheKWeakestRowsInAMatrix().new Solution();
        int[][] mat = new int[][]{{1, 0}, {0, 0}, {1, 0}};
        solution.kWeakestRows(mat, 2);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] kWeakestRows (int[][] mat, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            });
            
            for (int i = 0; i < mat.length; i++) {
                int k1 = getK(mat[i]);
                int[] ints = new int[2];
                ints[0] = k1;
                ints[1] = i;
                queue.add(ints);
            }
            int[] kw = new int[k];
            for (int i = 0; i < k; i++) {
                kw[i] = queue.poll()[1];
            }
            
            return kw;
        }
        
        
        private int getK (int[] matrix) {
            int l = 0, r = matrix.length - 1;
            
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (matrix[mid] == 0) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
                
            }
            
            return matrix[r] == 1 ? r : r - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
