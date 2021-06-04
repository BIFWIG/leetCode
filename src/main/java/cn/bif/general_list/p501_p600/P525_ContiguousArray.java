
package cn.bif.general_list.p501_p600;

import java.util.HashMap;
import java.util.Map;

/**
 * <br/>[525]连续数组
 * <br/>给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1:
 * <br/>
 * <br/>
 * <br/>输入: nums = [0,1]
 * <br/>输出: 2
 * <br/>说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * <br/>
 * <br/> 示例 2:
 * <br/>
 * <br/>
 * <br/>输入: nums = [0,1,0]
 * <br/>输出: 2
 * <br/>说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= nums.length <= 105
 * <br/> nums[i] 不是 0 就是 1
 * <br/>
 * <br/> Related Topics 哈希表
 * <br/> 👍 349 👎 0
 **/
public class P525_ContiguousArray {
    public static void main (String[] args) {
        Solution solution = new P525_ContiguousArray().new Solution();
        int[] nums = {0,1};
        System.out.println(solution.findMaxLength(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength (int[] nums) {
            int[] sums = new int[nums.length];
            sums[0] = nums[0] == 0 ? -1 : 1;
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + (nums[i] == 0 ? -1 : 1);
            }
            Map<Integer, Integer> hash = new HashMap<>();
            int count = 0;
            hash.put(0, -1);
            
            for (int i = 1; i < sums.length; i++) {
                if (!hash.containsKey(sums[i - 1])) {
                    hash.put(sums[i - 1], i - 1);
                }
                if (hash.containsKey(sums[i])) {
                    count = Math.max(count, i - hash.get(sums[i]));
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
