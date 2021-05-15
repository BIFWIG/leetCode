
package leetcode.editor.cn;

/**
 * <br/>[461]汉明距离
 * <br/>两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <br/>
 * <br/> 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <br/>
 * <br/> 注意：
 * <br/>0 ≤ x, y < 231.
 * <br/>
 * <br/> 示例:
 * <br/>
 * <br/>
 * <br/>输入: x = 1, y = 4
 * <br/>
 * <br/>输出: 2
 * <br/>
 * <br/>解释:
 * <br/>1   (0 0 0 1)
 * <br/>4   (0 1 0 0)
 * <br/>       ↑   ↑
 * <br/>
 * <br/>上面的箭头指出了对应二进制位不同的位置。
 * <br/>
 * <br/> Related Topics 位运算
 * <br/> 👍 404 👎 0
 **/
public class P461_HammingDistance {
    public static void main (String[] args) {
        Solution solution = new P461_HammingDistance().new Solution();
        System.out.println(solution.hammingDistance(1,1));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance (int x, int y) {
            int c = 0;
            //异或
            int i = x ^ y;
            while (i != 0) {
                //获取不同的个数
                c += i % 2;
                i = i >> 1;
            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
