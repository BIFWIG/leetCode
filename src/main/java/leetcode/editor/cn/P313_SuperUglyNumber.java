
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <br/>[313]超级丑数
 * <br/>超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * <br/>
 * <br/> 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * <br/>
 * <br/> 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：n = 12, primes = [2,7,13,19]
 * <br/>输出：32
 * <br/>解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,
 * <br/>28,32] 。
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：n = 1, primes = [2,3,5]
 * <br/>输出：1
 * <br/>解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= n <= 106
 * <br/> 1 <= primes.length <= 100
 * <br/> 2 <= primes[i] <= 1000
 * <br/> 题目数据 保证 primes[i] 是一个质数
 * <br/> primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> Related Topics 数组 哈希表 数学 动态规划 堆（优先队列）
 * <br/> 👍 188 👎 0
 **/
public class P313_SuperUglyNumber {
    public static void main (String[] args) {
        Solution solution = new P313_SuperUglyNumber().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthSuperUglyNumber (int n, int[] primes) {
            //记录已经添加过的点
            Set<Long> seen = new HashSet<>();
            //最小堆
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
            priorityQueue.offer(1L);
            seen.add(1L);
            // 每次 将堆顶（当前最小的值） * 质数数组，得到的就是由这个质数数组构建的丑数堆
            for (int i = 1; i < n; i++) {
                Long cur = priorityQueue.poll();
                for (int prime : primes) {
                    Long res = cur * prime;
                    if (seen.contains(res)) {
                        continue;
                    }
                    seen.add(res);
                    priorityQueue.offer(res);
                }
            }
            
            return Math.toIntExact(priorityQueue.peek());
        }
        
    }

//leetcode submit region end(Prohibit modification and deletion)

}
