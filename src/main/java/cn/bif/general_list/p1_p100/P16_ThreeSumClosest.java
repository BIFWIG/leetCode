package cn.bif.general_list.p1_p100;

import java.util.Arrays;

/**
 * <br/>[16]最接近的三数之和
 * <br/>给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
 * <br/>。假定每组输入只存在唯一答案。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例：
 * <br/>
 * <br/> 输入：nums = [-1,2,1,-4], target = 1
 * <br/>输出：2
 * <br/>解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 3 <= nums.length <= 10^3
 * <br/> -10^3 <= nums[i] <= 10^3
 * <br/> -10^4 <= target <= 10^4
 * <br/>
 * <br/> Related Topics 数组 双指针
 * <br/> 👍 778 👎 0
 **/
public class P16_ThreeSumClosest {
    public static void main (String[] args) {
        Solution solution = new P16_ThreeSumClosest().new Solution();
        int[] nums = {1,1,1,0};
        System.out.println(solution.threeSumClosest(nums,-100));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest (int[] nums, int target) {
            Arrays.sort(nums);
            int min = Integer.MAX_VALUE;
            int value = 0;
            int j, k;
            for (int i = 0; i < nums.length - 2; i++) {
                j = i + 1;
                k = nums.length - 1;
                while (j < k) {
                    int c = nums[i] + nums[j] + nums[k];
                    if (c == target) {
                        return c;
                    }
                    int distance = Math.abs(c-target);
                    if (min>distance){
                        min=distance;
                        value = c;
                    }
            
                    if (c > target) {
                        k--;
                    } else {
                        j++;
                    }
            
            
                }
        
        
            }
    
            return value;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
