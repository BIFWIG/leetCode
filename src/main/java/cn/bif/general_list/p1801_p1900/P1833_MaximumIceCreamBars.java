
package cn.bif.general_list.p1801_p1900;

import java.util.Arrays;

/**
 * <br/>[1833]雪糕的最大数量
 * <br/>夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * <br/>
 * <br/> 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coin
 * <br/>s 现金可以用于消费，他想要买尽可能多的雪糕。
 * <br/>
 * <br/> 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * <br/>
 * <br/> 注意：Tony 可以按任意顺序购买雪糕。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/> 输入：costs = [1,3,2,4,1], coins = 7
 * <br/>输出：4
 * <br/>解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/> 输入：costs = [10,6,8,7,7,8], coins = 5
 * <br/>输出：0
 * <br/>解释：Tony 没有足够的钱买任何一支雪糕。
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/> 输入：costs = [1,6,3,1,2,5], coins = 20
 * <br/>输出：6
 * <br/>解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> costs.length == n
 * <br/> 1 <= n <= 105
 * <br/> 1 <= costs[i] <= 105
 * <br/> 1 <= coins <= 108
 * <br/>
 * <br/> Related Topics 贪心 数组 排序
 * <br/> 👍 30 👎 0
 **/
public class P1833_MaximumIceCreamBars {
    public static void main (String[] args) {
        Solution solution = new P1833_MaximumIceCreamBars().new Solution();
        int[] costs = {1,3,2,4,1};
        
        System.out.println(solution.maxIceCream(costs,7));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        public int maxIceCream (int[] costs, int coins) {
            int[] ints = Arrays.stream(costs)
                               .sorted()
                               .toArray();
            int count = 0;
            for (int i = 0; i < ints.length; i++) {
                if (ints[i]<=coins){
                    coins-=ints[i];
                    count++;
                }else{
                    return i;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
