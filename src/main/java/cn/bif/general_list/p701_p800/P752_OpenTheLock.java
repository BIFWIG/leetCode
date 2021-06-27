
package cn.bif.general_list.p701_p800;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <br/>[752]打开转盘锁
 * <br/>你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
 * <br/> 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <br/>
 * <br/> 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <br/>
 * <br/> 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <br/>
 * <br/> 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1:
 * <br/>
 * <br/>
 * <br/>输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * <br/>输出：6
 * <br/>解释：
 * <br/>可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * <br/>注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * <br/>因为当拨动到 "0102" 时这个锁就会被锁定。
 * <br/>
 * <br/>
 * <br/> 示例 2:
 * <br/>
 * <br/>
 * <br/>输入: deadends = ["8888"], target = "0009"
 * <br/>输出：1
 * <br/>解释：
 * <br/>把最后一位反向旋转一次即可 "0000" -> "0009"。
 * <br/>
 * <br/>
 * <br/> 示例 3:
 * <br/>
 * <br/>
 * <br/>输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], targ
 * <br/>et = "8888"
 * <br/>输出：-1
 * <br/>解释：
 * <br/>无法旋转到目标数字且不被锁定。
 * <br/>
 * <br/>
 * <br/> 示例 4:
 * <br/>
 * <br/>
 * <br/>输入: deadends = ["0000"], target = "8888"
 * <br/>输出：-1
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= deadends.length <= 500
 * <br/> deadends[i].length == 4
 * <br/> target.length == 4
 * <br/> target 不在 deadends 之中
 * <br/> target 和 deadends[i] 仅由若干位数字组成
 * <br/>
 * <br/> Related Topics 广度优先搜索 数组 哈希表 字符串
 * <br/> 👍 337 👎 0
 **/
public class P752_OpenTheLock {
    public static void main (String[] args) {
        Solution solution = new P752_OpenTheLock().new Solution();
        String[] dead = {"0201","0101","0102","1212","2002"};
        String target ="0202";
        System.out.println(solution.openLock(dead, target));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock (String[] deadends, String target) {
            Set<Integer> dead = new HashSet<>();
            for (String deadend : deadends) {
                dead.add(Integer.parseInt(deadend));
            }
            Integer targetInt = Integer.parseInt(target);
            if (targetInt == 0) {
                return 0;
            }
            if (dead.contains(targetInt) || dead.contains(0)) {
                return -1;
            }
            boolean[] checked = new boolean[10000];
            Queue<Integer> list = new LinkedList<>();
            list.offer(0);
            
            int ans = 0;
            while (!list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = list.poll();
                    if (poll.equals(targetInt)) {
                        return ans;
                    }
                    
                    for (int j = 1; j <= 1000; j *= 10) {
                        int curNext = (poll/j % 10) == 9 ? poll - 9 * j : poll + j;
                        if (!checked[curNext] && !dead.contains(curNext)) {
                            list.add(curNext);
                            checked[curNext] = true;
                        }
                        int curPre =  (poll/j % 10) == 0 ? poll + 9 * j : poll - j;
                        if (!checked[curPre] && !dead.contains(curPre)) {
                            list.add(curPre);
                            checked[curPre] = true;
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
