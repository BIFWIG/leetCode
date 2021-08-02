
package cn.bif.general_list.p701_p800;

import java.util.Arrays;

/**
 * <br/>[743]网络延迟时间
 * <br/>有 n 个网络节点，标记为 1 到 n。
 * <br/>
 * <br/> 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
 * <br/>i 是一个信号从源节点传递到目标节点的时间。
 * <br/>
 * <br/> 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * <br/>输出：2
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：times = [[1,2,1]], n = 2, k = 1
 * <br/>输出：1
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：times = [[1,2,1]], n = 2, k = 2
 * <br/>输出：-1
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= k <= n <= 100
 * <br/> 1 <= times.length <= 6000
 * <br/> times[i].length == 3
 * <br/> 1 <= ui, vi <= n
 * <br/> ui != vi
 * <br/> 0 <= wi <= 100
 * <br/> 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * <br/>
 * <br/> Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列）
 * <br/> 👍 371 👎 0
 **/
public class P743_NetworkDelayTime {
    public static void main (String[] args) {
        Solution solution = new P743_NetworkDelayTime().new Solution();
//        int[][] times = new int[][]{{0,2,2},{0,1,5},{0,3,6},{1,4,1},{2,4,5},{2,3,3},{3,4,2},{2,1,1}};
        int[][] times = new int[][] {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(solution.networkDelayTime(times, 4, 2));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        
        public int networkDelayTime (int[][] times, int n, int k) {
            int N = 6;
            int[][] w = new int[N][N];
            int[] dist = new int[N];
            boolean[] vist = new boolean[N];
            int INF = Integer.MAX_VALUE/2;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    w[i][j] = w[j][i] = i == j ? 0 : INF;
                }
            }
            for (int[] time : times) {
                int ui = time[0];
                int vi = time[1];
                int t = time[2];
                w[ui][vi] = t;
            }
            Arrays.fill(vist, false);
            Arrays.fill(dist, INF);
            dist[k] = 0;
            for (int p = 1; p <= n; p++) {
                int t = -1;
                for (int i = 1; i <= n; i++) {
                    if (!vist[i] && (t == -1 || dist[i] < dist[t])) {
                        t = i;
                    }
                }
                vist[t] = true;
                for (int i = 1; i <= n; i++) {
                    dist[i] = Math.min(dist[i], dist[t] + w[t][i]);
                }
                
            }
            
            int res = 0;
            for (int i = 1; i <= n; i++) {
                res = Math.max(res,dist[i]);
            }
            
            return res >= INF ? -1 : res;
        }
        
        
    }
//leetcode submit region end(Prohibit modification and deletion)

}
