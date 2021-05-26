
package cn.bif.general_list.p1_p100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <br/>[46]全排列
 * <br/>给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1,2,3]
 * <br/>输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums = [0,1]
 * <br/>输出：[[0,1],[1,0]]
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1]
 * <br/>输出：[[1]]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= nums.length <= 6
 * <br/> -10 <= nums[i] <= 10
 * <br/> nums 中的所有整数 互不相同
 * <br/>
 * <br/> Related Topics 回溯算法
 * <br/> 👍 1378 👎 0
 **/
public class P46_Permutations {
    public static void main (String[] args) {
        Solution solution = new P46_Permutations().new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(solution.permute(nums));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute (int[] nums) {
            List<List<Integer>> numsList = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }
            
            
//            backtrack(nums.length, 0, current, numsList);
            backtrack2(nums,new ArrayList<>(),numsList);
            return numsList;
        }
        
        public void backtrack (int n, int index, List<Integer> cur, List<List<Integer>> numList) {
            if (index == n) {
                numList.add(new ArrayList<>(cur));
            }
            
            for (int i = index; i < n; i++) {
                Collections.swap(cur, index, i);
                backtrack(n, index + 1, cur, numList);
                Collections.swap(cur, index, i);
            }
        }
        
        public void backtrack2 (int[] nums, List<Integer> cur, List<List<Integer>> numList) {
            if (cur.size() == nums.length) {
                numList.add(new ArrayList<>(cur));
            }
            
            for (int i = 0; i < nums.length; i++) {
                if (cur.contains(nums[i])) {
                    continue;
                }
                cur.add(nums[i]);
                backtrack2(nums, cur, numList);
                cur.remove(cur.size() - 1);
            }
        }
        
    }
//leetcode submit region end(Prohibit modification and deletion)

}
