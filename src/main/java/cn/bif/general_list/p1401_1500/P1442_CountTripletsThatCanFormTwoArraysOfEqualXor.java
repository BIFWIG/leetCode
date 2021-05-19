package cn.bif.general_list.p1401_1500;

/**
 * <br/>[1442]形成两个异或相等数组的三元组数目
 * <br/>给你一个整数数组 arr 。
 * <br/>
 * <br/> 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * <br/>
 * <br/> a 和 b 定义如下：
 * <br/>
 * <br/>
 * <br/> a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * <br/> b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * <br/>
 * <br/>
 * <br/> 注意：^ 表示 按位异或 操作。
 * <br/>
 * <br/> 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/> 输入：arr = [2,3,1,6,7]
 * <br/>输出：4
 * <br/>解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/> 输入：arr = [1,1,1,1,1]
 * <br/>输出：10
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/> 输入：arr = [2,3]
 * <br/>输出：0
 * <br/>
 * <br/>
 * <br/> 示例 4：
 * <br/>
 * <br/> 输入：arr = [1,3,5,7,9]
 * <br/>输出：3
 * <br/>
 * <br/>
 * <br/> 示例 5：
 * <br/>
 * <br/> 输入：arr = [7,11,12,9,5,2,7,17,22]
 * <br/>输出：8
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= arr.length <= 300
 * <br/> 1 <= arr[i] <= 10^8
 * <br/>
 * <br/> Related Topics 位运算 数组 数学
 * <br/> 👍 98 👎 0
 **/
public class P1442_CountTripletsThatCanFormTwoArraysOfEqualXor {
    public static void main (String[] args) {
        Solution solution = new P1442_CountTripletsThatCanFormTwoArraysOfEqualXor().new Solution();
        int[] i = {1, 1, 1, 1, 1};
        System.out.println(solution.countTriplets(i));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * <br/> a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
         * <br/> b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
         * <br/> a^b = arr[i]^arr[i+1]...arr[k] = 0
         * 说明 i-k 区间内 异或和=0
         * 所以i-k区间内 任意点都能作为j
         * j=k-i
         *
         * @title
         * @author Ted Wang
         * @created 2021/5/18 11:22 上午
         */
        public int countTriplets (int[] arr) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                int x = arr[i];
                for (int k = i + 1; k < arr.length; k++) {
                    x ^= arr[k];
                    if (x == 0) {
                        count += k - i;
                    }
                }
                
            }
            
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
