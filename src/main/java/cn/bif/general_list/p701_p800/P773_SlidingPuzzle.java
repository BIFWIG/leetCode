
package cn.bif.general_list.p701_p800;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <br/>[773]滑动谜题
 * <br/>在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * <br/>
 * <br/> 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <br/>
 * <br/> 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <br/>
 * <br/> 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <br/>
 * <br/> 示例：
 * <br/>
 * <br/>
 * <br/>输入：board = [[1,2,3],[4,0,5]]
 * <br/>输出：1
 * <br/>解释：交换 0 和 5 ，1 步完成
 * <br/>
 * <br/>
 * <br/>
 * <br/>输入：board = [[1,2,3],[5,4,0]]
 * <br/>输出：-1
 * <br/>解释：没有办法完成谜板
 * <br/>
 * <br/>
 * <br/>
 * <br/>输入：board = [[4,1,2],[5,0,3]]
 * <br/>输出：5
 * <br/>解释：
 * <br/>最少完成谜板的最少移动次数是 5 ，
 * <br/>一种移动路径:
 * <br/>尚未移动: [[4,1,2],[5,0,3]]
 * <br/>移动 1 次: [[4,1,2],[0,5,3]]
 * <br/>移动 2 次: [[0,1,2],[4,5,3]]
 * <br/>移动 3 次: [[1,0,2],[4,5,3]]
 * <br/>移动 4 次: [[1,2,0],[4,5,3]]
 * <br/>移动 5 次: [[1,2,3],[4,5,0]]
 * <br/>
 * <br/>
 * <br/>
 * <br/>输入：board = [[3,2,4],[1,5,0]]
 * <br/>输出：14
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> board 是一个如上所述的 2 x 3 的数组.
 * <br/> board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 * <br/>
 * <br/> Related Topics 广度优先搜索 数组 矩阵
 * <br/> 👍 136 👎 0
 **/
public class P773_SlidingPuzzle {
    public static void main (String[] args) {
        Solution solution = new P773_SlidingPuzzle().new Solution();
        int[][] nums = new int[][]{{4, 1, 2}, {5, 0, 3}};
        System.out.println(solution.slidingPuzzle(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int slidingPuzzle (int[][] board) {
            Set<Integer> checked = new HashSet<>();
            int start = board[0][0] * 100000 + board[0][1] * 10000 + board[0][2] * 1000 + board[1][0] * 100 + board[1][1] * 10 + board[1][2];
            int target = 123450;
            
            if (start == target) {
                return 0;
            }
            
            Queue<Integer> list = new LinkedList<>();
            list.offer(start);
            int ans = 0;
            while (!list.isEmpty()) {
                int size = list.size();
                
                for (int i = 0; i < size; i++) {
                    int cur = list.poll();
                    if (cur == target) {
                        return ans;
                    }
                    String curString = cur < 100000 ? "0" + cur : ""+cur;
                    int zero = curString.indexOf("0");
                    switch (zero) {
                        case 0: {
                            int right = right(cur, curString, zero);
                            int down = down(cur, curString, zero);
                            if (!checked.contains(right)) {
                                list.add(right);
                                checked.add(right);
                            }
                            if (!checked.contains(down)) {
                                list.add(down);
                                checked.add(down);
                            }
                        }
                        break;
                        case 1: {
                            int left = left(cur, curString, zero);
                            int right = right(cur, curString, zero);
                            int down = down(cur, curString, zero);
                            if (!checked.contains(right)) {
                                list.add(right);
                                checked.add(right);
                            }
                            if (!checked.contains(down)) {
                                list.add(down);
                                checked.add(down);
                            }
                            if (!checked.contains(left)) {
                                list.add(left);
                                checked.add(left);
                            }
                        }
                        break;
                        case 2: {
                            int left = left(cur, curString, zero);
                            int down = down(cur, curString, zero);
                            if (!checked.contains(left)) {
                                list.add(left);
                                checked.add(left);
                            }
                            if (!checked.contains(down)) {
                                list.add(down);
                                checked.add(down);
                            }
                        }
                        break;
                        case 3: {
                            int right = right(cur, curString, zero);
                            int up = up(cur, curString, zero);
                            if (!checked.contains(right)) {
                                list.add(right);
                                checked.add(right);
                            }
                            if (!checked.contains(up)) {
                                list.add(up);
                                checked.add(up);
                            }
                        }
                        break;
                        case 4: {
                            int left = left(cur, curString, zero);
                            int right = right(cur, curString, zero);
                            int up = up(cur, curString, zero);
                            if (!checked.contains(right)) {
                                list.add(right);
                                checked.add(right);
                            }
                            if (!checked.contains(up)) {
                                list.add(up);
                                checked.add(up);
                            }
                            if (!checked.contains(left)) {
                                list.add(left);
                                checked.add(left);
                            }
                        }
                        break;
                        case 5: {
                            int left = left(cur, curString, zero);
                            int up = up(cur, curString, zero);
                            if (!checked.contains(left)) {
                                list.add(left);
                                checked.add(left);
                            }
                            if (!checked.contains(up)) {
                                list.add(up);
                                checked.add(up);
                            }
                        }
                        break;
                        
                        
                        default:
                    }
                    
                    
                }
                
                ans++;
            }
            
            return -1;
        }
        
        public int get (int index) {
            switch (index) {
                case 0:
                    return 100000;
                case 1:
                    return 10000;
                case 2:
                    return 1000;
                case 3:
                    return 100;
                case 4:
                    return 10;
                case 5:
                    return 1;
                
                
            }
            return 1;
        }
        
        
        public int left (int cur, String curString, int index) {
            int i = curString.charAt(index - 1) - '0';
            return cur - (i * get(index - 1)) + (i * get(index));
        }
        
        public int right (int cur, String curString, int index) {
            int i = curString.charAt(index + 1) - '0';
            return cur - (i * get(index + 1)) + (i * get(index));
        }
        
        public int up (int cur, String curString, int index) {
            int i = curString.charAt(index - 3) - '0';
            return cur - (i * get(index - 3)) + (i * get(index));
        }
        
        public int down (int cur, String curString, int index) {
            int i = curString.charAt(index + 3) - '0';
            return cur - (i * get(index + 3)) + (i * get(index));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
