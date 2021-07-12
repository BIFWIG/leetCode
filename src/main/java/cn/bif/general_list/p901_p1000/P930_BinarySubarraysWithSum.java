
package cn.bif.general_list.p901_p1000;

import java.util.HashMap;
import java.util.Map;

/**
 * <br/>[930]和相同的二元子数组
 * <br/>给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <br/>
 * <br/> 子数组 是数组的一段连续部分。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1,0,1,0,1], goal = 2
 * <br/>输出：4
 * <br/>解释：
 * <br/>如下面黑体所示，有 4 个满足题目要求的子数组：
 * <br/>[1,0,1,0,1]
 * <br/>[1,0,1,0,1]
 * <br/>[1,0,1,0,1]
 * <br/>[1,0,1,0,1]
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums = [0,0,0,0,0], goal = 0
 * <br/>输出：15
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= nums.length <= 3 * 104
 * <br/> nums[i] 不是 0 就是 1
 * <br/> 0 <= goal <= nums.length
 * <br/>
 * <br/> Related Topics 数组 哈希表 前缀和 滑动窗口
 * <br/> 👍 106 👎 0
 **/
public class P930_BinarySubarraysWithSum {
    public static void main (String[] args) {
        Solution solution = new P930_BinarySubarraysWithSum().new Solution();
        int[] nums = new int[]{1, 0, 1, 0, 1};
        System.out.println(solution.numSubarraysWithSum2(nums, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarraysWithSum (int[] nums, int goal) {
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for (int num : nums) {
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                sum += num;
                count += map.getOrDefault(sum - goal, 0);
                
            }
            return count;
        }
        
        public int numSubarraysWithSum2 (int[] nums, int goal) {
            int w = nums[0];
            int left = 0;
            int right = 0;
            int count = 0;
            
            while (right < nums.length) {
                while (w < goal) {
                    w += nums[right++];
                }
                
                while (w>=goal){
                    if (left<right){
                        count++;
                        w -= nums[left];
                        left++;
                    }
                    
                    
                }
                
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
