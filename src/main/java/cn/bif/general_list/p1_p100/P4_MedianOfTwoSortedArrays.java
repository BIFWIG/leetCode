
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
        /**
         * <br> 描述 本质上是查找第n小的数， 比如 [1,3] ,[2] 查找的是第2小的数，也就是2
         * <br> [1,3] [2,4] 查找的是 第2 ，3小的数的平均值
         * <br> 所以 一开始先确定要确定查找第几小的数 也就是(nums.length+nums2.length)/2+1
         * <br>
         * <br> 已奇数为例， [2，5] [1，3，4，6，7，8，9] 此时需要算得是第5小的数字，所以需要删除前4个，那么最小的就是第5小的了 所以index=4（需要删除的数量）
         * <br> 偶数同理
         * <br> 此时根据二分的思想，一次删除一半，
         * <br> k = index/2 = 2
         * <br> 此时两个数组分别切割2个下来
         * <br>  nums1 -> [2,5]
         * <br>  nums2 -> [1,3]
         * <br>  因为最后要第4小，所以前两个肯定是在较小的那边 3<5 所以此处删除的是nums2 的两个数字
         * <br>  nums1-> [2,5]
         * <br>  nums2-> [4,6,7,8,9]
         * <br>  第一轮结束
         * <br>  剩余需要删除的数量是 index-k = 2
         * <br>
         * <br>  第二轮开始 k= index/2 = 1
         * <br>  nums1 -> [2]
         * <br>  nums2 -> [4]
         * <br>  此时删除nums1
         * <br>  nums1-> [5]
         * <br>  nums2-> [4,6,7,8,9]
         * <br>  第二轮结束
         * <br>  剩余需要删除的数量是index-k = 1
         * <br>
         * <br>  第三轮同理，删除nums的1位
         * <br>  最终 取两个队列的最小值，也就是5
         * <br>  nums1-> [5]
         * <br>  nums2-> [6,7,8,9]
         * <br>
         * <br>  几个注意点：
         * <br>  1.一个队列删除完了，剩下的都从另一个队列删除
         * <br>  2.如果一个队列比k小，则用于比较的队列是等于它剩下的所有
         * <br>  比如k = 3
         * <br>  num1-> [4,5]
         * <br>  num2-> [1,2,3,6,7]
         * <br>  此时用于比较的就是
         * <br>  num1 -> [4,5]
         * <br>  num2 -> [1,2,3]
         * <br>  3 < 5 所以从num2中删除
         * <br>
         * <br>
         *
         * @title
         * @author Ted Wang
         * @created 2021/5/16 12:51 上午
         *
         */
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
