
package cn.bif.general_list.p1401_p1500;

import java.util.Arrays;

/**
 * <br/>[1449]数位成本和为目标值的最大数字
 * <br/>给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 * <br/>
 * <br/>
 * <br/> 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * <br/> 总成本必须恰好等于 target 。
 * <br/> 添加的数位中没有数字 0 。
 * <br/>
 * <br/>
 * <br/> 由于答案可能会很大，请你以字符串形式返回。
 * <br/>
 * <br/> 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：cost = [4,3,2,5,6,7,2,5,5], target = 9
 * <br/>输出："7772"
 * <br/>解释：添加数位 '7' 的成本为 2 ，添加数位 '2' 的成本为 3 。所以 "7772" 的代价为 2*3+ 3*1 = 9 。 "977" 也是满足要
 * <br/>求的数字，但 "7772" 是较大的数字。
 * <br/> 数字     成本
 * <br/>  1  ->   4
 * <br/>  2  ->   3
 * <br/>  3  ->   2
 * <br/>  4  ->   5
 * <br/>  5  ->   6
 * <br/>  6  ->   7
 * <br/>  7  ->   2
 * <br/>  8  ->   5
 * <br/>  9  ->   5
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：cost = [7,6,5,5,5,6,8,7,8], target = 12
 * <br/>输出："85"
 * <br/>解释：添加数位 '8' 的成本是 7 ，添加数位 '5' 的成本是 5 。"85" 的成本为 7 + 5 = 12 。
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：cost = [2,4,6,2,4,6,4,4,4], target = 5
 * <br/>输出："0"
 * <br/>解释：总成本是 target 的条件下，无法生成任何整数。
 * <br/>
 * <br/>
 * <br/> 示例 4：
 * <br/>
 * <br/>
 * <br/>输入：cost = [6,10,15,40,40,40,40,40,40], target = 47
 * <br/>输出："32211"
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> cost.length == 9
 * <br/> 1 <= cost[i] <= 5000
 * <br/> 1 <= target <= 5000
 * <br/>
 * <br/> Related Topics 字符串 动态规划
 * <br/> 👍 78 👎 0
 **/
public class P1449_FormLargestIntegerWithDigitsThatAddUpToTarget {
    public static void main (String[] args) {
        Solution solution = new P1449_FormLargestIntegerWithDigitsThatAddUpToTarget().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber (int[] cost, int target) {
            int[] f = new int[target + 1];
            Arrays.fill(f, Integer.MIN_VALUE);
            f[0] = 0;
            for (int i = 1; i <= 9; i++) {
                int u = cost[i - 1];
                for (int j = u; j <= target; j++) {
                    f[j] = Math.max(f[j], f[j - u] + 1);
                }
                
            }
            if (f[target] < 0) {
                return "0";
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 9, j = target; i >= 1; i--) {
                int u = cost[i - 1];
                while (j >= u && f[j] == f[j - u] + 1) {
                    sb.append(i);
                    j -= u;
                }
                
                
            }
            
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
