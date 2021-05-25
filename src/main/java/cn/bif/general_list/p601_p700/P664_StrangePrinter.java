
package cn.bif.general_list.p601_p700;

/**
 * <br/>[664]奇怪的打印机
 * <br/>有台奇怪的打印机有以下两个特殊要求：
 * <br/>
 * <br/>
 * <br/> 打印机每次只能打印由 同一个字符 组成的序列。
 * <br/> 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * <br/>
 * <br/>
 * <br/> 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：s = "aaabbb"
 * <br/>输出：2
 * <br/>解释：首先打印 "aaa" 然后打印 "bbb"。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：s = "aba"
 * <br/>输出：2
 * <br/>解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= s.length <= 100
 * <br/> s 由小写英文字母组成
 * <br/>
 * <br/> Related Topics 深度优先搜索 动态规划
 * <br/> 👍 162 👎 0
 **/
public class P664_StrangePrinter {
    public static void main (String[] args) {
        Solution solution = new P664_StrangePrinter().new Solution();
        System.out.println(solution.strangePrinter("aaabbb"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述
         * a,aa,aaa 1次
         * ab,aab,abb 2次
         * aba,aaba,abba,2次
         * abab,aabab,abbab 3次
         */
        public int strangePrinter (String s) {
            if (s.length() == 1) {
                return 1;
            }
            // 从i-j区间最小数量
            int[][] dp = new int[s.length()][s.length()];
            //从后往前才能确保中间的值都是计算过的
            for (int i = s.length() - 1; i >= 0; i--) {
                // i-i要打印的肯定就1次
                dp[i][i] = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    
                    if (s.charAt(i) == s.charAt(j)) {
                        // 头尾相等，那么次数由前一位决定
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = Integer.MAX_VALUE;
                        // 头尾不等就开始拆分  比如abab ，拆分成 aba+b,ab+ab,a+bab 三个的最小值 取局部最优解
                        for (int k = i; k < j; k++) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                        }
                        
                    }
                    
                    
                }
                
                
            }
            
            return dp[0][s.length() - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
