
package leetcode.editor.cn;

import java.util.*;

/**
 * <br/>[218]天际线问题
 * <br/>城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
 * <br/>
 * <br/> 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 * <br/>
 * <br/>
 * <br/>
 * <br/> lefti 是第 i 座建筑物左边缘的 x 坐标。
 * <br/> righti 是第 i 座建筑物右边缘的 x 坐标。
 * <br/> heighti 是第 i 座建筑物的高度。
 * <br/>
 * <br/>
 * <br/> 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。
 * <br/>列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * <br/>
 * <br/> 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答
 * <br/>案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * <br/>输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * <br/>解释：
 * <br/>图 A 显示输入的所有建筑物的位置和高度，
 * <br/>图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：buildings = [[0,2,3],[2,5,3]]
 * <br/>输出：[[0,3],[5,0]]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= buildings.length <= 104
 * <br/> 0 <= lefti < righti <= 231 - 1
 * <br/> 1 <= heighti <= 231 - 1
 * <br/> buildings 按 lefti 非递减排序
 * <br/>
 * <br/> Related Topics 树状数组 线段树 数组 分治 有序集合 扫描线 堆（优先队列）
 * <br/> 👍 423 👎 0
 **/
public class P218_TheSkylineProblem {
    public static void main (String[] args) {
        Solution solution = new P218_TheSkylineProblem().new Solution();
        int[][] nums = new int[][]
                {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        solution.getSkyline(nums);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> getSkyline (int[][] buildings) {
            PriorityQueue<Integer> heightQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
            
           List<List<Integer>> result = new ArrayList<>();
           
           List<int[]> sorted = new ArrayList<>();
    
    
            for (int[] building : buildings) {
                int left = building[0];
                int right = building[1];
                int height = building[2];
                //左接点
                int[] leftHeight = new int[]{left,height,-1};
                //右节点
                int[] rightHeight = new int[]{right,height,1};
                sorted.add(leftHeight);
                sorted.add(rightHeight);
            }
            
            sorted.sort((o1, o2) -> {
                if (o1[0] != o2[0]) {
                    //先按照横座标排序
                    return o1[0] - o2[0];
                }
                // 横座标相同按照左节点优先
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                }
                //横座标相同且 都是左接点或者右节点分类讨论
                //都是左节点 优先高度高的 因为最后的点只看最高的，所以优先进队列
                if (o1[2] == -1) {
                    return o2[1] - o1[1];
                } else {
                    //都是右节点 优先高度低的 和上面一样，右节点最低的实际上被覆盖了，不考虑，优先出队列
        
                    return o1[1] - o2[1];
                }
            });
            
            heightQueue.add(0);
            Integer lastHeight=0;
            for (int[] ints : sorted) {
                int point = ints[0];
                int height = ints[1];
                int leftRight = ints[2];
                
                //出入栈
                if (leftRight==-1){
                    heightQueue.add(height);
                }else{
                    heightQueue.remove(height);
                }
                //判断出入栈后 的栈顶
                int curHeight = heightQueue.peek();
                
                if (curHeight!=lastHeight){
                    //不等，那就要加个点了
                    List<Integer> list = Arrays.asList(point,curHeight);
                    result.add(list);
                    lastHeight = curHeight;
                }
                
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
