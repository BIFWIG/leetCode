
package cn.bif.general_list.p1701_p1800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <br/>[1711]大餐计数
 * <br/>大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * <br/>
 * <br/> 你可以搭配 任意 两道餐品做一顿大餐。
 * <br/>
 * <br/> 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大
 * <br/>餐 的数量。结果需要对 109 + 7 取余。
 * <br/>
 * <br/> 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：deliciousness = [1,3,5,7,9]
 * <br/>输出：4
 * <br/>解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * <br/>它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：deliciousness = [1,1,1,3,3,3,7]
 * <br/>输出：15
 * <br/>解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= deliciousness.length <= 105
 * <br/> 0 <= deliciousness[i] <= 220
 * <br/>
 * <br/> Related Topics 数组 哈希表
 * <br/> 👍 76 👎 0
 **/
public class P1711_CountGoodMeals {
    public static void main (String[] args) {
        Solution solution = new P1711_CountGoodMeals().new Solution();
        int[] i = new int[]{1,1,1,3,3,3,7};
        System.out.println(solution.countPairs(i));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPairs (int[] deliciousness) {
            int max = 1000000007;
            Map<Integer,Integer> map = new HashMap<>();


            int count =0;
            Set<Integer> good = new HashSet<>();
            int k =1;
            for (int i = 0; i < 22; i++) {
                good.add(k);
                k=k<<1;
            }

            for (int i : deliciousness) {
                for (Integer integer : good) {
                    Integer t = map.getOrDefault(integer - i,0);
                   count = (t+count)%max;

                }
                map.put(i,map.getOrDefault(i,0)+1);
            }


            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
