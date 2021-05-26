
package cn.bif.general_list.p1101_p1200;

import java.util.Stack;

/**
 * <br/>[1190]反转每对括号间的子串
 * <br/>给出一个字符串 s（仅含有小写英文字母和括号）。
 * <br/>
 * <br/> 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <br/>
 * <br/> 注意，您的结果中 不应 包含任何括号。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/> 输入：s = "(abcd)"
 * <br/>输出："dcba"
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/> 输入：s = "(u(love)i)"
 * <br/>输出："iloveu"
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/> 输入：s = "(ed(et(oc))el)"
 * <br/>输出："leetcode"
 * <br/>
 * <br/>
 * <br/> 示例 4：
 * <br/>
 * <br/> 输入：s = "a(bcdefghijkl(mno)p)q"
 * <br/>输出："apmnolkjihgfedcbq"
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 0 <= s.length <= 2000
 * <br/> s 中只有小写英文字母和括号
 * <br/> 我们确保所有括号都是成对出现的
 * <br/>
 * <br/> Related Topics 栈
 * <br/> 👍 135 👎 0
 **/
public class P1190_ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main (String[] args) {
        Solution solution = new P1190_ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
        System.out.println(solution.reverseParentheses("(u(love)i)"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseParentheses (String s) {
            //没任何括号直接返回
            if (!s.contains("(")) {
                return s;
            }
            
            Stack<Character> stack = new Stack<>();
            StringBuilder temp = new StringBuilder();
            
            for (char c : s.toCharArray()) {
                if (c != ')') {
                    stack.push(c);
                } else {
                    while (stack.peek() != '(' && !stack.isEmpty()) {
                        temp.append(stack.pop());
                    }
                    // 弹出左括号
                    stack.pop();
                    put(temp, stack);
                }
            }
            while (!stack.isEmpty()) {
                temp.append(stack.pop());
                
            }
            
            return temp.reverse()
                       .toString();
        }
        
        public void put (StringBuilder s, Stack<Character> stack) {
            for (int i = 0; i < s.length(); i++) {
                stack.push(s.charAt(i));
            }
            s.setLength(0);
        }
        
        
    }
//leetcode submit region end(Prohibit modification and deletion)

}
