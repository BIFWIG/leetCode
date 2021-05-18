package cn.bif.general_list.p1_p100;

/**
 * <br/>˚
 * <br/>整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <br/>
 * <br/> 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
 * <br/>k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
 * <br/>,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <br/>
 * <br/> 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums = [4,5,6,7,0,1,2], target = 0
 * <br/>输出：4
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums = [4,5,6,7,0,1,2], target = 3
 * <br/>输出：-1
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1], target = 0
 * <br/>输出：-1
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= nums.length <= 5000
 * <br/> -10^4 <= nums[i] <= 10^4
 * <br/> nums 中的每个值都 独一无二
 * <br/> 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * <br/> -10^4 <= target <= 10^4
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 * <br/> Related Topics 数组 二分查找
 * <br/> 👍 1359 👎 0
 **/
public class P33_SearchInRotatedSortedArray {
    public static void main (String[] args) {
        Solution solution = new P33_SearchInRotatedSortedArray().new Solution();
        int[] i = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.search(i, 7));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search (int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            int k = 0;
            while (j - i > 0) {
                k = (j + 1 - i) / 2 + i;
                //旋转的点在这块
                if (nums[k - 1] - nums[i] < 0) {
                    if (nums[k] <= target && nums[j] >= target) {
                        i = k;
                    } else {
                        j = k - 1;
                    }
                    
                } else {
                    if (nums[i] <= target && nums[k - 1] >= target) {
                        j = k - 1;
                    } else {
                        i = k;
                    }
                    
                }
                
                
            }
            if (nums[i] == target) {
                return i;
            }
            
            
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
