
package cn.bif.general_list.p801_p900;

import java.util.*;

/**
 * <br/>[815]公交路线
 * <br/>给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <br/>
 * <br/>
 * <br/> 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1
 * <br/>-> ... 这样的车站路线行驶。
 * <br/>
 * <br/>
 * <br/> 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <br/>
 * <br/> 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * <br/>输出：2
 * <br/>解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * <br/>输出：-1
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= routes.length <= 500.
 * <br/> 1 <= routes[i].length <= 105
 * <br/> routes[i] 中的所有值 互不相同
 * <br/> sum(routes[i].length) <= 105
 * <br/> 0 <= routes[i][j] < 106
 * <br/> 0 <= source, target < 106
 * <br/>
 * <br/> Related Topics 广度优先搜索 数组 哈希表
 * <br/> 👍 133 👎 0
 **/
public class P815_BusRoutes {
    public static void main (String[] args) {
        Solution solution = new P815_BusRoutes().new Solution();
//        int[][] ints = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
//                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30}};
        int[][] ints = new int[][]{{2},{2,8}};
        System.out.println(solution.numBusesToDestination(ints, 8, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numBusesToDestination (int[][] routes, int source, int target) {
            if (source == target) {
                return 0;
            }
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Set<Integer>> routeMap = new HashMap<>();
            for (int j = 0; j < routes.length; j++) {
                Set<Integer> stationSet = routeMap.getOrDefault(j, new HashSet<>());
    
                for (int i = 0; i < routes[j].length; i++) {
                    int i1 = routes[j][i];
                    stationSet.add(i1);
                    if (i1==source && !queue.contains(i1)){
                        queue.add(j);
                    }
                }
                routeMap.put(j,stationSet);
            }
            
            
            Set<Integer> checked = new HashSet<>();
           
            int ans = 0;
            
           
            while (!queue.isEmpty()) {
                int size = queue.size();
                Set<Integer> curSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    if (checked.contains(cur)) {
                        continue;
                    }
                    if (cur == target) {
                        return ans;
                    }
                    checked.add(cur);
                    
                    Set<Integer> set = routeMap.get(cur);
                    if (set!=null){
                        curSet.addAll(set);
                    }
                }
                queue.addAll(curSet);
                ans++;
            }
            
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
