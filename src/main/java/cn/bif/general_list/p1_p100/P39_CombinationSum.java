
package cn.bif.general_list.p1_p100;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/>[39]组合总和
 * <br/>给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <br/>
 * <br/> candidates 中的数字可以无限制重复被选取。
 * <br/>
 * <br/> 说明：
 * <br/>
 * <br/>
 * <br/> 所有数字（包括 target）都是正整数。
 * <br/> 解集不能包含重复的组合。
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/> 输入：candidates = [2,3,6,7], target = 7,
 * <br/>所求解集为：
 * <br/>[
 * <br/>  [7],
 * <br/>  [2,2,3]
 * <br/>]
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/> 输入：candidates = [2,3,5], target = 8,
 * <br/>所求解集为：
 * <br/>[
 * <br/>  [2,2,2,2],
 * <br/>  [2,3,3],
 * <br/>  [3,5]
 * <br/>]
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= candidates.length <= 30
 * <br/> 1 <= candidates[i] <= 200
 * <br/> candidate 中的每个元素都是独一无二的。
 * <br/> 1 <= target <= 500
 * <br/>
 * <br/> Related Topics 数组 回溯算法
 * <br/> 👍 1349 👎 0
 **/
public class P39_CombinationSum {
    public static void main (String[] args) {
        Solution solution = new P39_CombinationSum().new Solution();
        int[] ints = {2,3,6,7};
        System.out.println(solution.combinationSum(ints, 7));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> results = new ArrayList<>();
        
        public List<List<Integer>> combinationSum (int[] candidates, int target) {
            dfs(new ArrayList<>(),candidates,target,0);
            return results;
        }
        
        public void dfs(List<Integer>list,int[] candidates ,int target,int idx){
            if (target==0){
                results.add(new ArrayList<>(list));
                return;
            }
            if (idx==candidates.length){
                return;
            }
            dfs(list,candidates,target,idx+1);
            if (target>=candidates[idx]){
                list.add(candidates[idx]);
                dfs(list,candidates,target-candidates[idx],idx);
                list.remove(list.size()-1);
            }
            
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
