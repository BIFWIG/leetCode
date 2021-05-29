
package cn.bif.general_list.p501_p600;

import java.util.HashMap;
import java.util.Map;

/**
 * <br/>[560]和为K的子数组
 * <br/>给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <br/>
 * <br/> 示例 1 :
 * <br/>
 * <br/>
 * <br/>输入:nums = [1,1,1], k = 2
 * <br/>输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * <br/>
 * <br/>
 * <br/> 说明 :
 * <br/>
 * <br/>
 * <br/> 数组的长度为 [1, 20,000]。
 * <br/> 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * <br/>
 * <br/> Related Topics 数组 哈希表
 * <br/> 👍 914 👎 0
 **/
public class P560_SubarraySumEqualsK {
    public static void main (String[] args) {
        Solution solution = new P560_SubarraySumEqualsK().new Solution();
        int[] nums = {1, 1, 1};
        System.out.println(solution.subarraySum(nums, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    
    class Solution {
        public int subarraySum (int[] nums, int k) {
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int pre = 0;
            map.put(0, 1);
            for (int num : nums) {
                pre += num;
                count += map.getOrDefault(pre-k, 0);
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            
            
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
