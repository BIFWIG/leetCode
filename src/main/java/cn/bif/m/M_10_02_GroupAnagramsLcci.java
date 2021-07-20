
package cn.bif.m;

import java.util.*;

/**
 * <br/>[面试题 10.02]变位词组
 * <br/>编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <br/>
 * <br/> 注意：本题相对原题稍作修改
 * <br/>
 * <br/> 示例:
 * <br/>
 * <br/> 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * <br/>输出:
 * <br/>[
 * <br/>  ["ate","eat","tea"],
 * <br/>  ["nat","tan"],
 * <br/>  ["bat"]
 * <br/>]
 * <br/>
 * <br/> 说明：
 * <br/>
 * <br/>
 * <br/> 所有输入均为小写字母。
 * <br/> 不考虑答案输出的顺序。
 * <br/>
 * <br/> Related Topics 哈希表 字符串 排序
 * <br/> 👍 51 👎 0
 **/
public class M_10_02_GroupAnagramsLcci {
    public static void main (String[] args) {
        Solution solution = new M_10_02_GroupAnagramsLcci().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams (String[] strs) {
            Map<String,List<String>> m = new HashMap<>();
            for (String str : strs) {
                String sorted = sorted(str);
                List<String> orDefault = m.getOrDefault(sorted, new ArrayList<>());
                orDefault.add(str);
                m.put(sorted,orDefault);
            }
            return new ArrayList<>(m.values());
        }
        
        private String sorted(String s) {
            char[] chars = s.toCharArray();
            
            Arrays.sort(chars);
    
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
