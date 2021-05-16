
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/>[22]括号生成
 * <br/>数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：n = 3
 * <br/>输出：["((()))","(()())","(())()","()(())","()()()"]
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：n = 1
 * <br/>输出：["()"]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= n <= 8
 * <br/>
 * <br/> Related Topics 字符串 回溯算法
 * <br/> 👍 1785 👎 0
 **/
public class P22_GenerateParentheses {
    public static void main (String[] args) {
        Solution solution = new P22_GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(20));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();
        
        public List<String> generateParenthesis (int n) {
            dfs("", n, 0);
            return result;
        }
        
        
        public void dfs (String s, int l, int r) {
            if (l == 0 && r == 0) {
                result.add(s);
                return;
            }
            
            if (l > 0) {
                dfs(s + "(", l - 1, r + 1);
            }
            if (r > 0) {
                dfs(s + ")", l, r - 1);
            }
            
            
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
