
package cn.bif.general_list.p501_p600;

import java.util.Arrays;

/**
 * <br/>[581]最短无序连续子数组
 * <br/>给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <br/>
 * <br/> 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums = [2,6,4,8,10,9,15]
 * <br/>输出：5
 * <br/>解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1,2,3,4]
 * <br/>输出：0
 * <br/>
 * <br/>
 * <br/> 示例 3：
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
 * <br/> 1 <= nums.length <= 104
 * <br/> -105 <= nums[i] <= 105
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 * <br/>
 * <br/>
 * <br/> Related Topics 栈 贪心 数组 双指针 排序 单调栈
 * <br/> 👍 585 👎 0
 **/
public class P581_ShortestUnsortedContinuousSubarray {
    public static void main (String[] args) {
        Solution solution = new P581_ShortestUnsortedContinuousSubarray().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray (int[] nums) {
            int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted);
            
            int l = 0;
            int r = nums.length - 1;
            for (; l < nums.length; l++) {
                if (nums[l] != sorted[l]) {
                    break;
                }
            }
            if (l < r) {
                for (; r > l; r--) {
                    if (nums[r] != sorted[r]) {
                        break;
                    }
                }
            }
    
            return  r-l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
