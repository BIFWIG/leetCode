
package cn.bif.hot;

/**
 * <br/>[55]跳跃游戏
 * <br/>给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <br/>
 * <br/> 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <br/>
 * <br/> 判断你是否能够到达最后一个下标。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums = [2,3,1,1,4]
 * <br/>输出：true
 * <br/>解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums = [3,2,1,0,4]
 * <br/>输出：false
 * <br/>解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= nums.length <= 3 * 104
 * <br/> 0 <= nums[i] <= 105
 * <br/>
 * <br/> Related Topics 贪心算法 数组
 * <br/> 👍 1186 👎 0
 **/
public class H55_JumpGame {
    public static void main (String[] args) {
        Solution solution = new H55_JumpGame().new Solution();
        int[] a = {0, 2, 3};
        System.out.println(solution.canJump(a));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump (int[] nums) {
            int l = 1;
            for (int i = 1; i <=nums.length; i++) {
                //说明到不了i点
                if (i > l) {
                    return false;
                }
                if (l >= nums.length) {
                    return true;
                }
                l = Math.max(l, i + nums[i-1]);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
