
package cn.bif.general_list.p201_p300;

/**
 * <br/>[231]2的幂
 * <br/>给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <br/>
 * <br/> 示例 1:
 * <br/>
 * <br/> 输入: 1
 * <br/>输出: true
 * <br/>解释: 20 = 1
 * <br/>
 * <br/> 示例 2:
 * <br/>
 * <br/> 输入: 16
 * <br/>输出: true
 * <br/>解释: 24 = 16
 * <br/>
 * <br/> 示例 3:
 * <br/>
 * <br/> 输入: 218
 * <br/>输出: false
 * <br/> Related Topics 位运算 数学
 * <br/> 👍 318 👎 0
 **/
public class P231_PowerOfTwo {
    public static void main (String[] args) {
        Solution solution = new P231_PowerOfTwo().new Solution();
        
        System.out.println(solution.isPowerOfTwo(3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo (int n) {
            if (n <= 0) {
                return false;
            }
            int count = 0;
            while (n != 0) {
                count += (n & 1) == 0 ? 0 : 1;
                n = n >> 1;
            }
            return count <= 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
