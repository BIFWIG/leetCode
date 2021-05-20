
package cn.bif.general_list.p1_p100;

/**
 * <br/>[14]最长公共前缀
 * <br/>编写一个函数来查找字符串数组中的最长公共前缀。
 * <br/>
 * <br/> 如果不存在公共前缀，返回空字符串 ""。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：strs = ["flower","flow","flight"]
 * <br/>输出："fl"
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：strs = ["dog","racecar","car"]
 * <br/>输出：""
 * <br/>解释：输入不存在公共前缀。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 0 <= strs.length <= 200
 * <br/> 0 <= strs[i].length <= 200
 * <br/> strs[i] 仅由小写英文字母组成
 * <br/>
 * <br/> Related Topics 字符串
 * <br/> 👍 1610 👎 0
 **/
public class P14_LongestCommonPrefix {
    public static void main (String[] args) {
        Solution solution = new P14_LongestCommonPrefix().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix (String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }
            StringBuilder result = new StringBuilder();
            String start = strs[0];
            for (int i = 0; i < start.length(); i++) {
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length()) {
                        return result.toString();
                    }
                    if (strs[j].charAt(i)!=start.charAt(i)){
                        return result.toString();
                    }
                    
                    
                }
                result.append(start.charAt(i));
            }
            
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
