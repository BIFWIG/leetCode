package cn.bif.general_list.p1701_p1800;

/**
 * <br/>[1736]替换隐藏数字得到的最晚时间
 * <br/>给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * <br/>
 * <br/> 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * <br/>
 * <br/> 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：time = "2?:?0"
 * <br/>输出："23:50"
 * <br/>解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：time = "0?:3?"
 * <br/>输出："09:39"
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：time = "1?:22"
 * <br/>输出："19:22"
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> time 的格式为 hh:mm
 * <br/> 题目数据保证你可以由输入的字符串生成有效的时间
 * <br/>
 * <br/> Related Topics 字符串
 * <br/> 👍 42 👎 0
 **/
public class P1736_LatestTimeByReplacingHiddenDigits {
    public static void main (String[] args) {
        Solution solution = new P1736_LatestTimeByReplacingHiddenDigits().new Solution();
        System.out.println(solution.maximumTime("2?:?0"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maximumTime (String time) {
            StringBuffer sb = new StringBuffer();
            sb.append(time.charAt(0) == '?' ? ((time.charAt(1) <= '3' || time.charAt(1) == '?') ? '2' : '1') : time.charAt(0));
            sb.append(time.charAt(1) == '?' ? (time.charAt(0) <= '1' ? '9' : '3') : time.charAt(1));
            sb.append(':');
            sb.append(time.charAt(3)=='?'?'5':time.charAt(3));
            sb.append(time.charAt(4)=='?'?'9':time.charAt(4));
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
