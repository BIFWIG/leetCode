
package cn.bif.general_list.p1_p100;

import java.util.Arrays;

/**
 * <br/>[31]下一个排列
 * <br/>实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <br/>
 * <br/> 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <br/>
 * <br/> 必须 原地 修改，只允许使用额外常数空间。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1,2,3]
 * <br/>输出：[1,3,2]
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums = [3,2,1]
 * <br/>输出：[1,2,3]
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1,1,5]
 * <br/>输出：[1,5,1]
 * <br/>
 * <br/>
 * <br/> 示例 4：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1]
 * <br/>输出：[1]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= nums.length <= 100
 * <br/> 0 <= nums[i] <= 100
 * <br/>
 * <br/> Related Topics 数组
 * <br/> 👍 1113 👎 0
 **/
public class P31_NextPermutation {
    public static void main (String[] args) {
        Solution solution = new P31_NextPermutation().new Solution();
        int[] nums = {100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         *<br/> 从后往前找，找到不是降序排列的第一个数字为止 ， 6, 3，5，4，2，1 ，此处得到的就是[6,3] [5,4,2,1]
         *<br/> 交换  第一个队列最后一个 和第二个队列最小的大于这个数 此处为3，4
         *<br/> 得到交换后的序列为[6,4,5,3,2,1]
         *<br/> 为了得到最小，且后面的队列是升序排序的，所以只需要反转就可得到最小
         *<br/> [6,4,1,2,3,5]
         **/
        public void nextPermutation (int[] nums) {
            if (nums.length < 3) {
                reverse(nums, 0, nums.length - 1);
                return;
            }
            
            boolean hasSwap = true;
            for (int i = nums.length - 1; i > 0; i--) {
                
                if (nums[i] > nums[i - 1]) {
                    
                    int min = findMin(i, nums);
                    swap(nums, i - 1, min);
                    reverse(nums, i, nums.length - 1);
                    hasSwap = false;
                    break;
                }
                
            }
            if (hasSwap) {
                reverse(nums, 0, nums.length - 1);
            }
            
        }
        
        public int findMin (int maxIndex, int[] nums) {
            int min = 101;
            int minIndex = maxIndex;
            for (int i = nums.length - 1; i >= maxIndex; i--) {
                if (nums[maxIndex - 1] >= nums[i]) {
                    continue;
                }
                if (nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
                
            }
            
            return minIndex;
        }
        
        public void swap (int[] nums, int x, int y) {
            int t;
            t = nums[x];
            nums[x] = nums[y];
            nums[y] = t;
        }
        
        public void reverse (int[] nums, int x, int y) {
            for (int i = x, j = y; i < j; i++, j--) {
                swap(nums, i, j);
            }
            
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
