
package cn.bif.general_list.p1_p100;

/**
 * <br/>[65]有效数字
 * <br/>有效数字（按顺序）可以分成以下几个部分：
 * <br/>
 * <br/>
 * <br/> 一个 小数 或者 整数
 * <br/> （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * <br/>
 * <br/>
 * <br/> 小数（按顺序）可以分成以下几个部分：
 * <br/>
 * <br/>
 * <br/> （可选）一个符号字符（'+' 或 '-'）
 * <br/> 下述格式之一：
 * <br/>
 * <br/> 至少一位数字，后面跟着一个点 '.'
 * <br/> 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * <br/> 一个点 '.' ，后面跟着至少一位数字
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 整数（按顺序）可以分成以下几个部分：
 * <br/>
 * <br/>
 * <br/> （可选）一个符号字符（'+' 或 '-'）
 * <br/> 至少一位数字
 * <br/>
 * <br/>
 * <br/> 部分有效数字列举如下：
 * <br/>
 * <br/>
 * <br/> ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1",
 * <br/> "53.5e93", "-123.456e789"]
 * <br/>
 * <br/>
 * <br/> 部分无效数字列举如下：
 * <br/>
 * <br/>
 * <br/> ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * <br/>
 * <br/>
 * <br/> 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：s = "0"
 * <br/>输出：true
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：s = "e"
 * <br/>输出：false
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：s = "."
 * <br/>输出：false
 * <br/>
 * <br/>
 * <br/> 示例 4：
 * <br/>
 * <br/>
 * <br/>输入：s = ".1"
 * <br/>输出：true
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= s.length <= 20
 * <br/> s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
 * <br/>
 * <br/> Related Topics 数学 字符串
 * <br/> 👍 189 👎 0
 **/
public class P65_ValidNumber {
    public static void main (String[] args) {
        Solution solution = new P65_ValidNumber().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber (String s) {
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
