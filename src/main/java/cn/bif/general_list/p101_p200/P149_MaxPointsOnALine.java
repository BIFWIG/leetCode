
package cn.bif.general_list.p101_p200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <br/>[149]直线上最多的点数
 * <br/>给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：points = [[1,1],[2,2],[3,3]]
 * <br/>输出：3
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * <br/>输出：4
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= points.length <= 300
 * <br/> points[i].length == 2
 * <br/> -104 <= xi, yi <= 104
 * <br/> points 中的所有点 互不相同
 * <br/>
 * <br/> Related Topics 几何 哈希表 数学
 * <br/> 👍 264 👎 0
 **/
public class P149_MaxPointsOnALine {
    public static void main (String[] args) {
        Solution solution = new P149_MaxPointsOnALine().new Solution();
        int[][] points = new int[][]{{0, 0}, {1, -1}, {1, 1}};
        System.out.println(solution.maxPoints(points));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints (int[][] points) {
            if (points.length == 1) {
                return 1;
            }
            int max = 0;
            for (int i = 0; i < points.length - 1; i++) {
                Map<Double, List<int[][]>> m = new HashMap<>();
                for (int j = i + 1; j < points.length; j++) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    double count = count(x1, y1, x2, y2);
                    List<int[][]> orDefault = m.getOrDefault(count, new ArrayList<>());
                    orDefault.add(new int[][]{{x2, y2}});
                    m.put(count, orDefault);
                }
                for (Map.Entry<Double, List<int[][]>> doubleListEntry : m.entrySet()) {
                    List<int[][]> value = doubleListEntry.getValue();
                    if (value.size() == 1) {
                        max = Math.max(max, 2);
                        continue;
                    }
                    for (int i1 = 0; i1 < value.size() - 1; i1++) {
                        int ans = 2;
                        int x1 = value.get(i1)[0][0];
                        int y1 = value.get(i1)[0][1];
                        for (int j = i1 + 1; j < value.size(); j++) {
                            int x2 = value.get(j)[0][0];
                            int y2 = value.get(j)[0][1];
                            double count = count(x1, y1, x2, y2);
                            if (doubleListEntry.getKey() != count) {
                                continue;
                            }
                            ans++;
                        }
                        max = Math.max(ans, max);
                    }
                    
                    
                }
                
            }
            
            
            return max;
        }
        
        private double count (int x1, int y1, int x2, int y2) {
            if (x1 == x2) {
                return Double.MAX_VALUE;
            }
            if (y1 == y2) {
                return Double.MIN_VALUE;
            }
            
            double v = (y2 - y1) * 1.0 / (x2 - x1);
            
            
            return v;
        }
        
        
    }


//leetcode submit region end(Prohibit modification and deletion)

}
