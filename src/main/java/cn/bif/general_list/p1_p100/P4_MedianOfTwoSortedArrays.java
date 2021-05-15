
package cn.bif.general_list.p1_p100;

/**
 * <br/>[4]寻找两个正序数组的中位数
 * <br/>给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums1 = [1,3], nums2 = [2]
 * <br/>输出：2.00000
 * <br/>解释：合并数组 = [1,2,3] ，中位数 2
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums1 = [1,2], nums2 = [3,4]
 * <br/>输出：2.50000
 * <br/>解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：nums1 = [0,0], nums2 = [0,0]
 * <br/>输出：0.00000
 * <br/>
 * <br/>
 * <br/> 示例 4：
 * <br/>
 * <br/>
 * <br/>输入：nums1 = [], nums2 = [1]
 * <br/>输出：1.00000
 * <br/>
 * <br/>
 * <br/> 示例 5：
 * <br/>
 * <br/>
 * <br/>输入：nums1 = [2], nums2 = []
 * <br/>输出：2.00000
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> nums1.length == m
 * <br/> nums2.length == n
 * <br/> 0 <= m <= 1000
 * <br/> 0 <= n <= 1000
 * <br/> 1 <= m + n <= 2000
 * <br/> -106 <= nums1[i], nums2[i] <= 106
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <br/> Related Topics 数组 二分查找 分治算法
 * <br/> 👍 4090 👎 0
 **/
public class P4_MedianOfTwoSortedArrays {
    public static void main (String[] args) {
        Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = {1, 5};
        int[] nums2 = {2, 3, 4, 6, 7, 8};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays (int[] nums1, int[] nums2) {
            int a = getMinNum(nums1, nums2, (nums1.length + nums2.length) / 2);
            if ((nums1.length + nums2.length) % 2 == 0) {
                int b = getMinNum(nums1, nums2, (nums1.length + nums2.length) / 2 - 1);
                return (a + b) / 2.0;
                
            }
            return a;
        }
        
        public int getMinNum (int[] nums1, int[] nums2, int index) {
            
            int l = 0, r = 0;
            
            if (nums1 == null || nums1.length == 0) {
                l = -1;
            }
            if (nums2 == null || nums2.length == 0) {
                r = -1;
            }
            
            while (index != 0) {
                int k = index / 2 == 0 ? 1 : index / 2;
                if (l == -1) {
                    r += k;
                    index = index - k;
                    continue;
                }
                if (r == -1) {
                    l += k;
                    index = index - k;
                    continue;
                }
                int curl = l + k >= nums1.length ? nums1[nums1.length - 1] : nums1[l + k - 1];
                int curr = r + k >= nums2.length ? nums2[nums2.length - 1] : nums2[r + k - 1];
                
                if (curl < curr) {
                    if (l + k >= nums1.length) {
                        r += k - (nums1.length - l);
                        l = -1;
                    } else {
                        l += k;
                    }
                } else {
                    if (r + k >= nums2.length) {
                        l += k - (nums2.length - r);
                        r = -1;
                    } else {
                        r += k;
                    }
                }
                
                index = index - k;
            }
            if (l == -1) {
                return nums2[r];
            } else if (r == -1) {
                return nums1[l];
            } else {
                return Math.min(nums1[l], nums2[r]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
