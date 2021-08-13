
package cn.bif.general_list.p401_p500;

/**
 * <br/>[413]等差数列划分
 * <br/>如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <br/>
 * <br/>
 * <br/> 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <br/>
 * <br/> 子数组 是数组中的一个连续序列。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1,2,3,4]
 * <br/>输出：3
 * <br/>解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1]
 * <br/>输出：0
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= nums.length <= 5000
 * <br/> -1000 <= nums[i] <= 1000
 * <br/>
 * <br/>
 * <br/>
 * <br/> Related Topics 数组 动态规划
 * <br/> 👍 307 👎 0
 **/
public class P413_ArithmeticSlices {
    public static void main (String[] args) {
        Solution solution = new P413_ArithmeticSlices().new Solution();
        int[] nums = {1,2,3,4};
        System.out.println(solution.numberOfArithmeticSlices(nums));
  
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfArithmeticSlices (int[] nums) {
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i] - nums[i - 1];
            }
            int ans = 0;
            
            for (int i = 1; i < nums.length; i++) {
                int j = i;
                while (j < nums.length && nums[i] == nums[j]) j++;
               
                int k = j - i;
                ans += k * (k - 1) / 2;
                i = j - 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
