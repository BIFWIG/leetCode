package cn.bif.general_list.p1_p100;

import java.util.Stack;

/**
 * <br>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <br>
 * <br> 有效字符串需满足：
 * <br>
 * <br>
 * <br> 左括号必须用相同类型的右括号闭合。
 * <br> 左括号必须以正确的顺序闭合。
 * <br>
 * <br>
 * <br>
 * <br>
 * <br> 示例 1：
 * <br>
 * <br>
 * <br>输入：s = "()"
 * <br>输出：true
 * <br>
 * <br>
 * <br> 示例 2：
 * <br>
 * <br>
 * <br>输入：s = "()[]{}"
 * <br>输出：true
 * <br>
 * <br>
 * <br> 示例 3：
 * <br>
 * <br>
 * <br>输入：s = "(]"
 * <br>输出：false
 * <br>
 * <br>
 * <br> 示例 4：
 * <br>
 * <br>
 * <br>输入：s = "([)]"
 * <br>输出：false
 * <br>
 * <br>
 * <br> 示例 5：
 * <br>
 * <br>
 * <br>输入：s = "{[]}"
 * <br>输出：true
 * <br>
 * <br>
 * <br>
 * <br> 提示：
 * <br>
 * <br>
 * <br> 1 <= s.length <= 104
 * <br> s 仅由括号 '()[]{}' 组成
 * <br>
 * <br> Related Topics 栈 字符串
 * <br> 👍 2396 👎 0
 * [20]有效的括号
 *
 * @author Ted Wang
 * @created 2021/5/13 5:14 下午
 */
public class P20 {
    public boolean isValid (String s) {
      
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
                continue;
            }
            if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            }
            if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
            if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }
        }
        return stack.isEmpty();
    }
    
    public static void main (String[] args) {
        P20 h20 = new P20();
        System.out.println(h20.isValid("]"));
    }
}
