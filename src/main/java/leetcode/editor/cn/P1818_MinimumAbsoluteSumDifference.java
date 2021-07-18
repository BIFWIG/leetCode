
package leetcode.editor.cn;

import java.util.Arrays;

/**
 * <br/>[1818]绝对差值和
 * <br/>给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * <br/>
 * <br/> 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始
 * <br/>）。
 * <br/>
 * <br/> 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * <br/>
 * <br/> 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * <br/>
 * <br/> |x| 定义为：
 * <br/>
 * <br/>
 * <br/> 如果 x >= 0 ，值为 x ，或者
 * <br/> 如果 x <= 0 ，值为 -x
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * <br/>输出：3
 * <br/>解释：有两种可能的最优方案：
 * <br/>- 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * <br/>- 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * <br/>两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * <br/>输出：0
 * <br/>解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * <br/>输出：20
 * <br/>解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * <br/>绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> n == nums1.length
 * <br/> n == nums2.length
 * <br/> 1 <= n <= 105
 * <br/> 1 <= nums1[i], nums2[i] <= 105
 * <br/>
 * <br/> Related Topics 贪心 数组 二分查找 有序集合
 * <br/> 👍 69 👎 0
 **/
public class P1818_MinimumAbsoluteSumDifference {
    public static void main (String[] args) {
        Solution solution = new P1818_MinimumAbsoluteSumDifference().new Solution();
        int[] num3 = new int[]{57, 42, 21, 28, 30, 25, 22, 12, 55, 3, 47, 18, 43, 29, 20, 44, 59, 9, 43, 7, 8, 5, 42, 53, 99, 34, 37, 88, 87, 62, 38, 68, 31, 3, 11, 61, 93, 34, 63, 27, 20, 48, 38, 5, 71, 100, 88, 54, 52, 15, 98, 59, 74, 26, 81, 38, 11, 44, 25, 69, 79, 81, 51, 85, 59, 84, 83, 99, 31, 47, 31, 23, 83, 70, 82, 79, 86, 31, 50, 17, 11, 100, 55, 15, 98, 11, 90, 16, 46, 89, 34, 33, 57, 53, 82, 34, 25, 70, 5, 1};
        int[] num4 = new int[]{76, 3, 5, 29, 18, 53, 55, 79, 30, 33, 87, 3, 56, 93, 40, 80, 9, 91, 71, 38, 35, 78, 32, 58, 77, 41, 63, 5, 21, 67, 21, 84, 52, 80, 65, 38, 62, 99, 80, 13, 59, 94, 21, 61, 43, 82, 29, 97, 31, 24, 95, 52, 90, 92, 37, 26, 65, 89, 90, 32, 27, 3, 42, 47, 93, 25, 14, 5, 39, 85, 89, 7, 74, 38, 12, 46, 40, 25, 51, 2, 19, 8, 21, 62, 58, 29, 32, 77, 62, 9, 74, 98, 10, 55, 25, 62, 48, 48, 24, 21};
        int[] num1 = new int[]{7, 11, 28};
        int[] num2 = new int[]{1, 4, 20};
        System.out.println(solution.minAbsoluteSumDiff(num3, num4));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAbsoluteSumDiff (int[] nums1, int[] nums2) {
            int sum = 0;
            
            int[] sorted = nums1.clone();
            //后续用于二分查找
            Arrays.sort(sorted);
            int l;
            int r;
            int abs;
            int mid = 0;
            int max = 0;
            for (int i = 0; i < nums1.length; i++) {
                int a = nums1[i];
                int b = nums2[i];
                if (a == b) {
                    continue;
                }
                abs = Math.abs(a - b);
                sum += abs;
                l = 0;
                r = nums1.length;
                
                while (l < r) {
                    mid = l + (r - l) / 2;
                    
                    if (sorted[mid] < b) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                int leftPoint = sorted[l];
                int tem = Math.min(abs, Math.abs(leftPoint - b));
                
                if (l + 1 < sorted.length) {
                    int rightPoint = sorted[l + 1];
                    tem = Math.min(tem, Math.abs(rightPoint - b));
                }
                
                max = Math.max(max, Math.abs(abs - tem));
            }
            
            return (sum - max) % 1000000007;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
