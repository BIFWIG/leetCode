
package cn.bif.general_list.p401_p500;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/>[401]二进制手表
 * <br/>二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 例如，下面的二进制手表读取 "3:25" 。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0
 * <br/>Unported (CC BY-SA 3.0) ）
 * <br/>
 * <br/> 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * <br/>
 * <br/> 小时不会以零开头：
 * <br/>
 * <br/>
 * <br/> 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * <br/>
 * <br/>
 * <br/> 分钟必须由两位数组成，可能会以零开头：
 * <br/>
 * <br/>
 * <br/> 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：turnedOn = 1
 * <br/>输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：turnedOn = 9
 * <br/>输出：[]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 0 <= turnedOn <= 10
 * <br/>
 * <br/> Related Topics 位运算 回溯算法
 * <br/> 👍 292 👎 0
 **/
public class P401_BinaryWatch {
    public static void main (String[] args) {
        Solution solution = new P401_BinaryWatch().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> readBinaryWatch (int turnedOn) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 60; j++) {
                    if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                        list.add(i + ":" + (j < 10 ? "0" : "") + j);
                    }
                }
            }
            
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
