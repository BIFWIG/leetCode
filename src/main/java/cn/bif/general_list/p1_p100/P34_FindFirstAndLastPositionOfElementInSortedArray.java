
package cn.bif.general_list.p1_p100;

import java.util.Arrays;

/**
 * <br/>[34]在排序数组中查找元素的第一个和最后一个位置
 * <br/>给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <br/>
 * <br/> 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <br/>
 * <br/> 进阶：
 * <br/>
 * <br/>
 * <br/> 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums = [5,7,7,8,8,10], target = 8
 * <br/>输出：[3,4]
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums = [5,7,7,8,8,10], target = 6
 * <br/>输出：[-1,-1]
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：nums = [], target = 0
 * <br/>输出：[-1,-1]
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 0 <= nums.length <= 105
 * <br/> -109 <= nums[i] <= 109
 * <br/> nums 是一个非递减数组
 * <br/> -109 <= target <= 109
 * <br/>
 * <br/> Related Topics 数组 二分查找
 * <br/> 👍 1012 👎 0
 **/
public class P34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main (String[] args) {
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {2,2};
        System.out.println(Arrays.toString(solution.searchRange(nums, 2)));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange (int[] nums, int target) {
            int[] count = {-1, -1};
            
            
            if (nums.length==0){
                return count;
            }
            if (nums.length==1 ){
                if (nums[0] == target) {
                    count = new int[]{0, 0};
                    
                }
                return count;
                
            }
            
            int i = 0;
            int j = nums.length - 1;
            // 二分找到任意一个值=k的位置
            while (i < j) {
                int k = (j - i) / 2 + i;
                if (nums[k] == target) {
                    i = k;
                    break;
                }
                if (nums[k] > target) {
                    j = k-1;
                } else {
                    i = k+1;
                }
            }
           
            //往前往后找
            if (nums[i] == target) {
                count[0] = i;
                count[1] = i;
                int l = i, r = i;
                while (r!=nums.length-1 && nums[++r] == target) {
                    count[1] = r;
                }
                while (l>0 && nums[--l] == target) {
                    count[0] = l;
                }
            }
           
            
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
