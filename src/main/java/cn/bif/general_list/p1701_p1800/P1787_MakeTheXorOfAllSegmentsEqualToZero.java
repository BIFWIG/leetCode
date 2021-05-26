
package cn.bif.general_list.p1701_p1800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <br/>[1787]使所有区间的异或结果为零
 * <br/>给你一个整数数组 nums 和一个整数 k 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 rig
 * <br/>ht（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR n
 * <br/>ums[right] 。
 * <br/>
 * <br/> 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1,2,0,3,0], k = 1
 * <br/>输出：3
 * <br/>解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
 * <br/>输出：3
 * <br/>解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
 * <br/>输出：3
 * <br/>解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= k <= nums.length <= 2000
 * <br/> 0 <= nums[i] < 210
 * <br/>
 * <br/> Related Topics 动态规划
 * <br/> 👍 103 👎 0
 **/
public class P1787_MakeTheXorOfAllSegmentsEqualToZero {
    public static void main (String[] args) {
        Solution solution = new P1787_MakeTheXorOfAllSegmentsEqualToZero().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minChanges (int[] nums, int k) {
            int n = nums.length;
            int max = 1024;
            int[][] f = new int[k][max];
            int[] g = new int[k];
            for (int i = 0; i < k; i++) {
                Arrays.fill(f[i], Integer.MAX_VALUE);
                g[i] = Integer.MAX_VALUE;
            }
            for (int i = 0, cnt = 0; i < k; i++, cnt = 0) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = i; j < n; j += k) {
                    map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                    cnt++;
                }
                if (i == 0) {
                    for (int xor = 0; xor < max; xor++) {
                        f[i][xor] = Math.min(f[i][xor], cnt - map.getOrDefault(xor, 0));
                        g[i] = Math.min(g[i], f[i][xor]);
                    }
                } else {
                    for (int xor = 0; xor < max; xor++) {
                        f[i][xor] = g[i - 1] + cnt;
                        for (Integer current : map.keySet()) {
                            f[i][xor] = Math.min(f[i][xor], f[i - 1][xor ^ current] + cnt - map.get(current));
                        }
                        g[i] = Math.min(g[i], f[i][xor]);
                        
                    }
                }
            }
            return f[k-1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
