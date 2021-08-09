
package cn.bif.general_list.p1101_p1200;

import java.util.Arrays;

/**
 * <br/>[1137]第 N 个泰波那契数
 * <br/>泰波那契序列 Tn 定义如下：
 * <br/>
 * <br/> T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <br/>
 * <br/> 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/> 输入：n = 4
 * <br/>输出：4
 * <br/>解释：
 * <br/>T_3 = 0 + 1 + 1 = 2
 * <br/>T_4 = 1 + 1 + 2 = 4
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/> 输入：n = 25
 * <br/>输出：1389537
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 0 <= n <= 37
 * <br/> 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 * <br/>
 * <br/> Related Topics 记忆化搜索 数学 动态规划
 * <br/> 👍 93 👎 0
 **/
public class P1137_NThTribonacciNumber {
    public static void main (String[] args) {
        Solution solution = new P1137_NThTribonacciNumber().new Solution();
        System.out.println(solution.tribonacci(4));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci (int n) {
            int[] size = new int[38];
            Arrays.fill(size, 0);
            size[0] = 0;
            size[1] = 1;
            size[2] = 1;
            for (int i = 3; i <= n; i++) {
                size[i] = size[i-3]+size[i-2]+size[i-1];
            }
            
            return size[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
