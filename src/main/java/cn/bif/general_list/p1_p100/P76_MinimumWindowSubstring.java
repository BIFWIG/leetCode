
package cn.bif.general_list.p1_p100;

import java.util.HashMap;
import java.util.Map;

/**
 * <br/>[76]最小覆盖子串
 * <br/>给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <br/>
 * <br/> 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：s = "ADOBECODEBANC", t = "ABC"
 * <br/>输出："BANC"
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：s = "a", t = "a"
 * <br/>输出："a"
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= s.length, t.length <= 105
 * <br/> s 和 t 由英文字母组成
 * <br/>
 * <br/>
 * <br/>
 * <br/>进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window
 * <br/> 👍 1201 👎 0
 **/
public class P76_MinimumWindowSubstring {
    public static void main (String[] args) {
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow (String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int start = 0;
            int end = 0;
            boolean contains = false;
            while (start <= end && end < s.length()) {
                char c = s.charAt(end);
                char st = s.charAt(start);
                if (!contains) {
                    Integer integer = map.get(c);
                    if (integer == null) {
                        end++;
                        continue;
                    }
                    map.put(c, integer - 1);
                    contains = mapIsEmpty(map);
                    end++;
                } else {
                    if (map.get(st) == null) {
                        start++;
                    }
                    if (map.get(st) + 1 > 0) {
                        break;
                    }
                    
                }
                
                
            }
            
            return "";
        }
        
        private boolean mapIsEmpty (Map<Character, Integer> map) {
            for (Integer value : map.values()) {
                if (value > 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
