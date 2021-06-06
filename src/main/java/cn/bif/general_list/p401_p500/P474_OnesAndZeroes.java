
package cn.bif.general_list.p401_p500;

/**
 * <br/>[474]一和零
 * <br/>给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <br/>
 * <br/>
 * <br/> 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <br/>
 * <br/> 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * <br/>输出：4
 * <br/>解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * <br/>其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于
 * <br/>n 的值 3 。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：strs = ["10", "0", "1"], m = 1, n = 1
 * <br/>输出：2
 * <br/>解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= strs.length <= 600
 * <br/> 1 <= strs[i].length <= 100
 * <br/> strs[i] 仅由 '0' 和 '1' 组成
 * <br/> 1 <= m, n <= 100
 * <br/>
 * <br/> Related Topics 动态规划
 * <br/> 👍 459 👎 0
 **/
public class P474_OnesAndZeroes {
    public static void main (String[] args) {
        Solution solution = new P474_OnesAndZeroes().new Solution();
        
        String[] strings = {"00101011"};
        System.out.println(solution.findMaxForm(strings, 36, 39));
        System.out.println(solution.findMaxForm2(strings, 36, 39));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm (String[] strs, int m, int n) {
            //朴素的三维dp
            int[][] zo = new int[strs.length][2];
            // 初始化0，1 个数数组
            for (int i = 0; i < strs.length; i++) {
                int zero = strs[i].length() - strs[i].replace("0", "")
                                                     .length();
                int one = strs[i].length() - zero;
                zo[i][0] = zero;
                zo[i][1] = one;
            }
            int[][][] dp = new int[strs.length][m + 1][n + 1];
            // 只判断第一个是否放入
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[0][i][j] = zo[0][0] <= i && zo[0][1] <= j ? 1 : 0;
                    
                }
            }
            // 处理剩余的
            for (int k = 1; k < strs.length; k++) {
                for (int i = 0; i <= m; i++) {
                    for (int j = 0; j <= n; j++) {
                        // 不放入就等于前一个
                        int notSet = dp[k - 1][i][j];
                        int curZero = zo[k][0];
                        int curOne = zo[k][1];
                        int set = 0;
                        if (curZero <= i && curOne <= j) {
                            // 放入就在前一个基础上+1
                            set = dp[k - 1][i - curZero][j - curOne] + 1;
                        }
                        // 取两个最大
                        dp[k][i][j] = Math.max(set, notSet);
                    }
                    
                    
                }
                
                
            }
            
            return dp[strs.length - 1][m][n];
        }
        
        public int findMaxForm2 (String[] strs, int m, int n) {
            int[][] zo = new int[strs.length][2];
            // 初始化0，1 个数数组
            for (int i = 0; i < strs.length; i++) {
                int zero = strs[i].length() - strs[i].replace("0", "")
                                                     .length();
                int one = strs[i].length() - zero;
                zo[i][0] = zero;
                zo[i][1] = one;
            }
            int[][] dp = new int[m + 1][n + 1];
            for (int k = 0; k < strs.length; k++) {
                int zero = zo[k][0];
                int one = zo[k][1];
                // 只需要遍历到 zero和one之前即可
                for (int i = m; i >= zero; i--) {
                    for (int j = n; j >= one; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                    }
                }
            }
            return dp[m][n];
        }
        
    }
//leetcode submit region end(Prohibit modification and deletion)

}
