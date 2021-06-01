
package cn.bif.general_list.p1701_p1800;

/**
 * <br/>[1744]你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * <br/>给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数
 * <br/>组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 * <br/>
 * <br/> 你按照如下规则进行一场游戏：
 * <br/>
 * <br/>
 * <br/> 你从第 0 天开始吃糖果。
 * <br/> 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * <br/> 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * <br/>
 * <br/>
 * <br/> 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是
 * <br/>：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[
 * <br/>i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 * <br/>
 * <br/> 请你返回得到的数组 answer 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * <br/>输出：[true,false,true]
 * <br/>提示：
 * <br/>1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * <br/>2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型
 * <br/>4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * <br/>3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,3
 * <br/>0],[1,3,1]]
 * <br/>输出：[false,true,true,false,false]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= candiesCount.length <= 105
 * <br/> 1 <= candiesCount[i] <= 105
 * <br/> 1 <= queries.length <= 105
 * <br/> queries[i].length == 3
 * <br/> 0 <= favoriteTypei < candiesCount.length
 * <br/> 0 <= favoriteDayi <= 109
 * <br/> 1 <= dailyCapi <= 109
 * <br/>
 * <br/> Related Topics 数学
 * <br/> 👍 102 👎 0
 **/
public class P1744_CanYouEatYourFavoriteCandyOnYourFavoriteDay {
    public static void main (String[] args) {
        Solution solution = new P1744_CanYouEatYourFavoriteCandyOnYourFavoriteDay().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean[] canEat (int[] candiesCount, int[][] queries) {
            int n = queries.length;
            int m = candiesCount.length;
            //int会溢出
            long[] sum = new long[m + 1];
            for (int i = 1; i <= m; i++) {
                sum[i] = sum[i - 1] + candiesCount[i - 1];
            }
            boolean[] result = new boolean[n];
            for (int i = 0; i < n; i++) {
                int t = queries[i][0];
                int d = queries[i][1] + 1;
                int c = queries[i][2];
                long a = sum[t] / c + 1;
                long b = sum[t + 1];
                
                result[i] = a <= d && d <= b;
            }
            
            return result;
        }
        
        public boolean[] canEat2 (int[] cs, int[][] qs) {
            int n = qs.length, m = cs.length;
            boolean[] ans = new boolean[n];
            long[] sum = new long[m + 1];
            for (int i = 1; i <= m; i++) sum[i] = sum[i - 1] + cs[i - 1];
            for (int i = 0; i < n; i++) {
                int t = qs[i][0], d = qs[i][1] + 1, c = qs[i][2];
                long a = sum[t] / c + 1, b = sum[t + 1];
                ans[i] = a <= d && d <= b;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
