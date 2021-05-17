
package cn.bif.general_list.p1_p100;

/**
 * <br/>[32]最长有效括号
 * <br/>给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：s = "(()"
 * <br/>输出：2
 * <br/>解释：最长有效括号子串是 "()"
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：s = ")()())"
 * <br/>输出：4
 * <br/>解释：最长有效括号子串是 "()()"
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：s = ""
 * <br/>输出：0
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 0 <= s.length <= 3 * 104
 * <br/> s[i] 为 '(' 或 ')'
 * <br/>
 * <br/>
 * <br/>
 * <br/> Related Topics 字符串 动态规划
 * <br/> 👍 1306 👎 0
 **/
public class P32_LongestValidParentheses {
    public static void main (String[] args) {
        Solution solution = new P32_LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("()(())"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses (String s) {
            if (s.length() < 2) {
                return 0;
            }
            int[] dp = new int[s.length()];
            // 考虑的是前两个
            dp[1] = (s.charAt(0) == '(' && s.charAt(1) == ')') ? 2 : 0;
            int max = dp[1];
            
            for (int i = 2; i < s.length(); i++) {
                // 左的不用管，直接下一个
                if (s.charAt(i) == '(') {
                    continue;
                }
                if (s.charAt(i - 1) == '(') {
                    // 前一个是左，说明他俩刚好闭环，那么dp[i] = dp[i-2]+2
                    dp[i] = dp[i - 2] + 2;
                } else {
                    // 这儿主要是判断 i-dp[i-1] 也就是跳过第i-1个的最大值，中间的就都是组合好的了，只要判断前一个是不是 左的
                    // 是的话就直接闭合，do[i] = dp[i-1]+2(这块是中间的) + dp[i-dp[i-1]-1](这块是左括号左边的看看能不能连起来)+2(本身)
                    if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        
                        dp[i] = dp[i - 1] + (((i - dp[i - 1] >= 2)) ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    
                }
                
                max = Math.max(max, dp[i]);
            }
            
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
