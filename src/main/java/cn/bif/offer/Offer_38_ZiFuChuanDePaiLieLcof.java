
package cn.bif.offer;


import java.util.*;

/**
 * <br/>[剑指 Offer 38]字符串的排列
 * <br/>输入一个字符串，打印出该字符串中字符的所有排列。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例:
 * <br/>
 * <br/> 输入：s = "abc"
 * <br/>输出：["abc","acb","bac","bca","cab","cba"]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 限制：
 * <br/>
 * <br/> 1 <= s 的长度 <= 8
 * <br/> Related Topics 回溯算法
 * <br/> 👍 333 👎 0
 **/
public class Offer_38_ZiFuChuanDePaiLieLcof {
    public static void main (String[] args) {
        Solution solution = new Offer_38_ZiFuChuanDePaiLieLcof().new Solution();
        System.out.println(solution.permutation("abc"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> set = new HashSet<>();
        boolean[] vis = new boolean[10];
        public String[] permutation (String s) {
            char[] cs = s.toCharArray();
            dfs(cs,0,"");
            return set.toArray(new String[0]);
        }
        
        public void dfs(char[] cs ,int u ,String cur){
            int n = cs.length;
            if (u==n){
                set.add(cur);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!vis[i]){
                    vis[i]=true;
                    dfs(cs,u+1,cur+cs[i]);
                    vis[i]=false;
                }
                
            }
            
            
            
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
