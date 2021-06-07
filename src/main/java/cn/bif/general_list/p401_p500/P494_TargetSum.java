package cn.bif.general_list.p401_p500;

import java.util.Arrays;

/**
 * <br/>[494]目标和
 * <br/>给你一个整数数组 nums 和一个整数 target 。
 * <br/>
 * <br/> 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <br/>
 * <br/>
 * <br/> 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * <br/>
 * <br/>
 * <br/> 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1,1,1,1,1], target = 3
 * <br/>输出：5
 * <br/>解释：一共有 5 种方法让最终目标和为 3 。
 * <br/>-1 + 1 + 1 + 1 + 1 = 3
 * <br/>+1 - 1 + 1 + 1 + 1 = 3
 * <br/>+1 + 1 - 1 + 1 + 1 = 3
 * <br/>+1 + 1 + 1 - 1 + 1 = 3
 * <br/>+1 + 1 + 1 + 1 - 1 = 3
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1], target = 1
 * <br/>输出：1
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= nums.length <= 20
 * <br/> 0 <= nums[i] <= 1000
 * <br/> 0 <= sum(nums[i]) <= 1000
 * <br/> -1000 <= target <= 100
 * <br/>
 * <br/> Related Topics 深度优先搜索 动态规划
 * <br/> 👍 685 👎 0
 **/
public class P494_TargetSum {
    public static void main (String[] args) {
        Solution solution = new P494_TargetSum().new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(solution.findTargetSumWays2(nums, 3));
        
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays (int[] nums, int target) {
            int sum = Arrays.stream(nums)
                            .sum();
            int reg = (sum - target);
            if (reg < 0 || reg % 2 != 0) {
                return 0;
            }
            reg = reg / 2;
            int[][] dp = new int[nums.length + 1][reg + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 0; j <= reg; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= nums[i - 1]) {
                        dp[i][j] += dp[i - 1][j - nums[i - 1]];
                    }
                    
                }
            }
            
            return dp[nums.length][reg];
        }
        
        
        public int findTargetSumWays2 (int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum+=num;
            }
            int reg = (sum - target);
            if (reg < 0 || reg % 2 != 0) {
                return 0;
            }
            reg = reg / 2;
            int[] dp = new int[reg + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = reg; i >= num; i--) {
                    dp[i] += dp[i - num];
                }
                
                
            }
            
            return dp[reg];
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
