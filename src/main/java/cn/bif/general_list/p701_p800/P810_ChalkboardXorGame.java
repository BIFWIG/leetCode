
package cn.bif.general_list.p701_p800;

/**
 * <br/>[810]黑板异或游戏
 * <br/>黑板上写着一个非负整数数组 nums[i] 。Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。如果擦除一个数字后，剩余的所有数字按位异或
 * <br/>运算得出的结果等于 0 的话，当前玩家游戏失败。 (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。）
 * <br/>
 * <br/> 换种说法就是，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。
 * <br/>
 * <br/> 假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例：
 * <br/>
 * <br/>
 * <br/>输入: nums = [1, 1, 2]
 * <br/>输出: false
 * <br/>解释:
 * <br/>Alice 有两个选择: 擦掉数字 1 或 2。
 * <br/>如果擦掉 1, 数组变成 [1, 2]。剩余数字按位异或得到 1 XOR 2 = 3。那么 Bob 可以擦掉任意数字，因为 Alice 会成为擦掉最后一个数
 * <br/>字的人，她总是会输。
 * <br/>如果 Alice 擦掉 2，那么数组变成[1, 1]。剩余数字按位异或得到 1 XOR 1 = 0。Alice 仍然会输掉游戏。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= N <= 1000
 * <br/> 0 <= nums[i] <= 2^16
 * <br/>
 * <br/> Related Topics 数学
 * <br/> 👍 41 👎 0
 **/
public class P810_ChalkboardXorGame {
    public static void main (String[] args) {
        Solution solution = new P810_ChalkboardXorGame().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述
         * <br/> 分类讨论
         * 1.nums.length 是偶数 </br>
         * 1.0  如果是[1,2,3,4]这种完全不同的，那随便拿，最后一个肯定是对方的，直接获胜</br>
         * 1.1  如果是[1,1,2,2]或[0,0,0,0] 每个数字都是偶数个，那么直接获胜</br>
         * 1.2  如果是[1,1,2,3]或[1,1,2,3,3,4] 这种 可以考虑拿1，剩余的两个数组变成[1,2,3]直接获胜和[1,2,3,3,4]<br/>
         *      这儿进一步考虑，[1,2,3,3,4] 对手拿 3，那么就变成1.0的情况获胜，对手拿其他，变成1.2的另一种情况，也是获胜<br/>
         * 2 nums.length 是奇数<br/>
         * 2.0 nums全是0 直接获胜<br/>
         * 2.1 如果是[1,2,3,4,5]这种全是不一样的，直接输<br/>
         * 2.2 如果是[1,1,2,3,4]如果拿1，此时数组变成[1,2,3,4] 对手满足1.0情况，必胜<br/>
         *     如果拿其他 比如2，变成[1,1,3,4]对手满足1，2情况必胜<br/>
         * 2.2.1  多个也是同理 [1,1,2,2,3,4,5] 拿1 -> [1,2,2,3,4,5] 对手拿2->[1,2,3,4,5] 2.1情况必败<br/>
         *        [1,1,2,2,3,4,5] 拿3 ->[1,1,2,2,4,5] 此时对手只需拆散开->[1,1,2,4,5] 变成2.2情况必败<br/>
         *
         * 结论：<br/>
         * 偶数必胜<br/>
         * 奇术全是0获胜，否则必败<br/>
         * @title
         * @author Ted Wang
         * @created 2021/5/22 2:41 上午
         *
         */
        public boolean xorGame (int[] nums) {
            if (nums.length % 2 == 0) {
                return true;
            }
            int s = 0;
            for (int num : nums) {
                s ^= num;
            }
            return s == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
