
package cn.bif.general_list.p601_p700;

import java.util.Arrays;

/**
 * <br/>[611]有效三角形的个数
 * <br/>给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <br/>
 * <br/> 示例 1:
 * <br/>
 * <br/>
 * <br/>输入: [2,2,3,4]
 * <br/>输出: 3
 * <br/>解释:
 * <br/>有效的组合是:
 * <br/>2,3,4 (使用第一个 2)
 * <br/>2,3,4 (使用第二个 2)
 * <br/>2,2,3
 * <br/>
 * <br/>
 * <br/> 注意:
 * <br/>
 * <br/>
 * <br/> 数组长度不超过1000。
 * <br/> 数组里整数的范围为 [0, 1000]。
 * <br/>
 * <br/> Related Topics 贪心 数组 双指针 二分查找 排序
 * <br/> 👍 183 👎 0
 **/
public class P611_ValidTriangleNumber {
    public static void main (String[] args) {
        Solution solution = new P611_ValidTriangleNumber().new Solution();
        int[] nums = {4, 2, 3, 4};
        System.out.println(solution.triangleNumber(nums));
    }
    
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int triangleNumber (int[] nums) {
            Arrays.sort(nums);
    
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int left = j + 1, right = nums.length - 1, k = j;
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (nums[mid] < nums[i] + nums[j]) {
                            k = mid;
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    count += k - j;
            
                }
            }
    
            return count;
        }
        
        
    }
//leetcode submit region end(Prohibit modification and deletion)

}
