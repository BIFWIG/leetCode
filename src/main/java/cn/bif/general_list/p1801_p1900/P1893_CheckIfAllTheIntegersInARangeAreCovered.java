
package cn.bif.general_list.p1801_p1900;

import java.util.HashSet;
import java.util.Set;

/**
 * <br/>[1893]检查是否区域内所有整数都被覆盖
 * <br/>给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 star
 * <br/>ti 到 endi 的 闭区间 。
 * <br/>
 * <br/> 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 * <br/>
 * <br/> 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了
 * <br/>。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * <br/>输出：true
 * <br/>解释：2 到 5 的每个整数都被覆盖了：
 * <br/>- 2 被第一个区间覆盖。
 * <br/>- 3 和 4 被第二个区间覆盖。
 * <br/>- 5 被第三个区间覆盖。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * <br/>输出：false
 * <br/>解释：21 没有被任何一个区间覆盖。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= ranges.length <= 50
 * <br/> 1 <= starti <= endi <= 50
 * <br/> 1 <= left <= right <= 50
 * <br/>
 * <br/> Related Topics 数组 哈希表 前缀和
 * <br/> 👍 28 👎 0
 **/
public class P1893_CheckIfAllTheIntegersInARangeAreCovered {
    public static void main (String[] args) {
        Solution solution = new P1893_CheckIfAllTheIntegersInARangeAreCovered().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isCovered (int[][] ranges, int left, int right) {
            Set<Integer> set = new HashSet<>();
            for (int[] range : ranges) {
                for (int i = range[0]; i <=range[1] ; i++) {
                    set.add(i);
                }
            }
            for (int i = left; i <=right ; i++) {
                if (!set.contains(i)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
