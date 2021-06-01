package cn.bif.general_list.p501_p600;

import java.util.HashMap;
import java.util.Map;

/**
 * <br/>[523]连续的子数组和
 * <br/>给定一个包含 非负数 的数组和一个目标 整数 k ，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n *
 * <br/>k ，其中 n 也是一个整数。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：[23,2,4,6,7], k = 6
 * <br/>输出：True
 * <br/>解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：[23,2,6,4,7], k = 6
 * <br/>输出：True
 * <br/>解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 说明：
 * <br/>
 * <br/>
 * <br/> 数组的长度不会超过 10,000 。
 * <br/> 你可以认为所有数字总和在 32 位有符号整数范围内。
 * <br/>
 * <br/> Related Topics 数学 动态规划
 * <br/> 👍 236 👎 0
 **/
public class P523_ContinuousSubarraySum {
    public static void main (String[] args) {
        Solution solution = new P523_ContinuousSubarraySum().new Solution();
        int[] ints = {1, 0};
        System.out.println(solution.checkSubarraySum(ints, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkSubarraySum (int[] nums, int k) {
            if (nums.length < 2) {
                return false;
            }
            int[] sum = new int[nums.length];
            Map<Integer, Integer> hash = new HashMap<>();
            hash.put(0, -1);
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
            for (int i = 0; i < sum.length; i++) {
                int c = sum[i] % k;
                
                if (hash.containsKey(c)) {
                    if (i - hash.get(c) >= 2) {
                        
                        return true;
                    }
                } else {
                    
                    hash.put(c, i);
                }
            }
            
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
