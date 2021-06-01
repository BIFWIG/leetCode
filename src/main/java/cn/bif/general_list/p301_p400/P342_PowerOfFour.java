
package cn.bif.general_list.p301_p400;

/**
 * <br/>[342]4的幂
 * <br/>给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <br/>
 * <br/> 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：n = 16
 * <br/>输出：true
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：n = 5
 * <br/>输出：false
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：n = 1
 * <br/>输出：true
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> -231 <= n <= 231 - 1
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 进阶：
 * <br/>
 * <br/>
 * <br/> 你能不使用循环或者递归来完成本题吗？
 * <br/>
 * <br/> Related Topics 位运算
 * <br/> 👍 216 👎 0
 **/
public class P342_PowerOfFour {
    public static void main (String[] args) {
        Solution solution = new P342_PowerOfFour().new Solution();
        System.out.println(solution.isPowerOfFour(2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfFour (int n) {
            int mask = 0B10_1010_1010_1010_1010_1010_1010_1010;
            return n > 0 && (n & (n - 1)) == 0 && ((n & mask) == 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
