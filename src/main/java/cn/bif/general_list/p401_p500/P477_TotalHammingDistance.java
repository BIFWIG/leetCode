
package cn.bif.general_list.p401_p500;

/**
 * <br/>[477]汉明距离总和
 * <br/>两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * <br/>
 * <br/> 计算一个数组中，任意两个数之间汉明距离的总和。
 * <br/>
 * <br/> 示例:
 * <br/>
 * <br/>
 * <br/>输入: 4, 14, 2
 * <br/>
 * <br/>输出: 6
 * <br/>
 * <br/>解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * <br/>所以答案为：
 * <br/>HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 +
 * <br/>2 + 2 = 6.
 * <br/>
 * <br/>
 * <br/> 注意:
 * <br/>
 * <br/>
 * <br/> 数组中元素的范围为从 0到 10^9。
 * <br/> 数组的长度不超过 10^4。
 * <br/>
 * <br/> Related Topics 位运算
 * <br/> 👍 177 👎 0
 **/
public class P477_TotalHammingDistance {
    public static void main (String[] args) {
        Solution solution = new P477_TotalHammingDistance().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalHammingDistance (int[] nums) {
            int count = 0;
            int size = nums.length;
            int isOne = 0;
            for (int i = 0; i < 30; i++) {
                isOne = 0;
                for (int num : nums) {
                    isOne += num >> i & 1;
                }
                count += (nums.length - isOne) * isOne;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
