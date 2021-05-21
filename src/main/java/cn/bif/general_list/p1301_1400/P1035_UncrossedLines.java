
package cn.bif.general_list.p1301_1400;

/**
 * <br/>[1035]不相交的线
 * <br/>在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * <br/>
 * <br/> 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 * <br/>
 * <br/>
 * <br/> nums1[i] == nums2[j]
 * <br/> 且绘制的直线不与任何其他连线（非水平线）相交。
 * <br/>
 * <br/>
 * <br/> 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * <br/>
 * <br/> 以这种方法绘制线条，并返回可以绘制的最大连线数。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>
 * <br/>输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * <br/>输出：2
 * <br/>解释：可以画出两条不交叉的线，如上图所示。
 * <br/>但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相
 * <br/>交。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * <br/>输出：3
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * <br/>输出：2
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= nums1.length <= 500
 * <br/> 1 <= nums2.length <= 500
 * <br/> 1 <= nums1[i], nums2[i] <= 2000
 * <br/>
 * <br/>
 * <br/>
 * <br/> Related Topics 数组
 * <br/> 👍 186 👎 0
 **/
public class P1035_UncrossedLines {
    public static void main (String[] args) {
        Solution solution = new P1035_UncrossedLines().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxUncrossedLines (int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length+1][nums2.length+1];
            for (int i = 1; i < nums1.length+1; i++) {
                for (int j = 1; j < nums2.length + 1; j++) {
                    if (nums1[i-1]==nums2[j-1]){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                
                    }
                }
            }
            return dp[nums1.length][nums2.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
