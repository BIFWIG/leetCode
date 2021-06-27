
package cn.bif.general_list.p901_p1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <br/>[909]蛇梯棋
 * <br/>N x N 的棋盘 board 上，按从 1 到 N*N 的数字给方格编号，编号 从左下角开始，每一行交替方向。
 * <br/>
 * <br/> 例如，一块 6 x 6 大小的棋盘，编号如下：
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 boa
 * <br/>rd[r][c]。
 * <br/>
 * <br/> 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
 * <br/>
 * <br/> 每一回合，玩家需要从当前方格 x 开始出发，按下述要求前进：
 * <br/>
 * <br/>
 * <br/> 选定目标方格：选择从编号 x+1，x+2，x+3，x+4，x+5，或者 x+6 的方格中选出一个目标方格 s ，目标方格的编号 <= N*N。
 * <br/>
 * <br/>
 * <br/> 该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 [x+1, x+6] 之间。
 * <br/>
 * <br/>
 * <br/> 传送玩家：如果目标方格 S 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 S。
 * <br/>
 * <br/>
 * <br/> 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
 * <br/>
 * <br/> 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例：
 * <br/>
 * <br/> 输入：[
 * <br/>[-1,-1,-1,-1,-1,-1],
 * <br/>[-1,-1,-1,-1,-1,-1],
 * <br/>[-1,-1,-1,-1,-1,-1],
 * <br/>[-1,35,-1,-1,13,-1],
 * <br/>[-1,-1,-1,-1,-1,-1],
 * <br/>[-1,15,-1,-1,-1,-1]]
 * <br/>输出：4
 * <br/>解释：
 * <br/>首先，从方格 1 [第 5 行，第 0 列] 开始。
 * <br/>你决定移动到方格 2，并必须爬过梯子移动到到方格 15。
 * <br/>然后你决定移动到方格 17 [第 3 行，第 5 列]，必须爬过蛇到方格 13。
 * <br/>然后你决定移动到方格 14，且必须通过梯子移动到方格 35。
 * <br/>然后你决定移动到方格 36, 游戏结束。
 * <br/>可以证明你需要至少 4 次移动才能到达第 N*N 个方格，所以答案是 4。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 2 <= board.length = board[0].length <= 20
 * <br/> board[i][j] 介于 1 和 N*N 之间或者等于 -1。
 * <br/> 编号为 1 的方格上没有蛇或梯子。
 * <br/> 编号为 N*N 的方格上没有蛇或梯子。
 * <br/>
 * <br/> Related Topics 广度优先搜索 数组 矩阵
 * <br/> 👍 40 👎 0
 **/
public class P909_SnakesAndLadders {
    public static void main (String[] args) {
        Solution solution = new P909_SnakesAndLadders().new Solution();
//        int[][] board = new int[][]{
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 35, -1, -1, 13, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 15, -1, -1, -1, -1}};
        int[][] board = new int[][]{
                {1, 1, -1},
                {1, 1, 1},
                {-1, 1, 1}
        };
        System.out.println(solution.snakesAndLadders(board));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int snakesAndLadders (int[][] board) {
            int[] nums = new int[board.length * board[0].length];
            int k = 0;
            int column = 0;
            for (int i = board.length - 1; i >= 0; i--) {
                if (column % 2 == 0) {
                    for (int i1 = 0; i1 < board[i].length; i1++) {
                        nums[k] = board[i][i1];
                        k++;
                    }
                } else {
                    for (int i1 = board[i].length - 1; i1 >= 0; i1--) {
                        nums[k] = board[i][i1];
                        k++;
                    }
                }
                column++;
            }
            
            boolean[] checked = new boolean[nums.length];
            checked[0] = true;
            Queue<Integer> list = new LinkedList<>();
            list.add(0);
            int ans = 0;
            while (!list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = list.poll();
                    if (poll == nums.length - 1) {
                        return ans;
                    }
                    for (int j = 1; j <= 6 && poll + j < nums.length; j++) {
                        if (checked[poll + j]) {
                            continue;
                        }
                        checked[poll+j] =true;
                        if (nums[poll + j] == -1) {
                            list.add(poll + j);
                        } else {
                            list.add(nums[poll + j] - 1);
                        }
                    }
                }
                
                ans++;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
