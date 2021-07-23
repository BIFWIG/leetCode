
package cn.bif.general_list.p1801_p1900;

import java.util.Arrays;

/**
 * <br/>[1877]数组中最大数对和的最小值
 * <br/>一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
 * <br/>
 * <br/>
 * <br/> 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) =
 * <br/>8 。
 * <br/>
 * <br/>
 * <br/> 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
 * <br/>
 * <br/>
 * <br/> nums 中每个元素 恰好 在 一个 数对中，且
 * <br/> 最大数对和 的值 最小 。
 * <br/>
 * <br/>
 * <br/> 请你在最优数对划分的方案下，返回最小的 最大数对和 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/> 输入：nums = [3,5,2,3]
 * <br/>输出：7
 * <br/>解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
 * <br/>最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/> 输入：nums = [3,5,4,2,4,6]
 * <br/>输出：8
 * <br/>解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
 * <br/>最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> n == nums.length
 * <br/> 2 <= n <= 105
 * <br/> n 是 偶数 。
 * <br/> 1 <= nums[i] <= 105
 * <br/>
 * <br/> Related Topics 贪心 数组 双指针 排序
 * <br/> 👍 28 👎 0
 **/
public class P1877_MinimizeMaximumPairSumInArray {
    public static void main (String[] args) {
        Solution solution = new P1877_MinimizeMaximumPairSumInArray().new Solution();
        int[] nums = {3,5,4,2,4,6};
        System.out.println(solution.minPairSum(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPairSum (int[] nums) {
            Arrays.sort(nums);
            int max = 0;
            
            for (int i = 0; i <= nums.length / 2; i++) {
                max = Math.max(max,nums[i]+nums[nums.length-1-i]);
            }
            
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
