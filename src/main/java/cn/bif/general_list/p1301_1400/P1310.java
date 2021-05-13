package cn.bif.general_list.p1301_1400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <br>有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 * <br>
 * <br> 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为
 * <br>本次查询的结果。
 * <br>
 * <br> 并返回一个包含给定查询 queries 所有结果的数组。
 * <br>
 * <br>
 * <br>
 * <br> 示例 1：
 * <br>
 * <br> 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * <br>输出：[2,7,14,8]
 * <br>解释：
 * <br>数组中元素的二进制表示形式是：
 * <br>1 = 0001
 * <br>3 = 0011
 * <br>4 = 0100
 * <br>8 = 1000
 * <br>查询的 XOR 值为：
 * <br>[0,1] = 1 xor 3 = 2
 * <br>[1,2] = 3 xor 4 = 7
 * <br>[0,3] = 1 xor 3 xor 4 xor 8 = 14
 * <br>[3,3] = 8
 * <br>
 * <br>
 * <br> 示例 2：
 * <br>
 * <br> 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * <br>输出：[8,0,4,4]
 * <br>
 * <br>
 * <br>
 * <br>
 * <br> 提示：
 * <br>
 * <br>
 * <br> 1 <= arr.length <= 3 * 10^4
 * <br> 1 <= arr[i] <= 10^9
 * <br> 1 <= queries.length <= 3 * 10^4
 * <br> queries[i].length == 2
 * <br> 0 <= queries[i][0] <= queries[i][1] < arr.length
 * <br>
 * <br> Related Topics 位运算
 * <br> 👍 109 👎 0
 *
 * @author Ted Wang
 * @created 2021/5/12 9:35 下午
 */
public class P1310 {
    
    
    /**
     * 描述 前缀合并
     * <p>
     * a^0 = a
     * a^a = 0
     * a^b^a = b
     * (a^b)^(b^c) = a^b^b^c = a^c
     *
     *  (arr[l]^arr[l+1]...arr[r]) = (arr[0]^...arr[r]) ^ (arr[0]^arr[l-1])
     * @return int[]
     * @author Ted Wang
     * @created 2021/5/12 10:18 下午
     **/
    public int[] prefixion (int[] arr, int[][] queries) {
        
        int[] ints = new int[arr.length + 1];
        ints[0] = 0;
        
        for (int i = 0; i < arr.length; i++) {
            ints[i + 1] = ints[i] ^ arr[i];
        }
        List<Integer> list = new ArrayList<>();
        for (int[] query : queries) {
            
            list.add(ints[query[0]] ^ ints[query[1] + 1]);
            
            
        }
        
        return list.stream()
                   .mapToInt(Integer::valueOf)
                   .toArray();
    }
    
    /**
     * 描述 暴力算法
     * @title xorQueries
     * @author Ted Wang
     * @param: arr
     * @param queries
     * @created 2021/5/13 10:08 上午
     * @return int[]
     */
    public int[] xorQueries (int[] arr, int[][] queries) {
        
        List<Integer> list = new ArrayList<>();
        
        
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int f = 0;
            
            for (int i = l; i <= r; i++) {
                f = f ^ arr[i];
            }
            list.add(f);
            
        }
        
        return list.stream()
                   .mapToInt(Integer::valueOf)
                   .toArray();
    }
    
    
    public static void main (String[] args) {
        P1310 p1310 = new P1310();
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        
        int[] ints = p1310.xorQueries(arr, queries);
        System.out.println(Arrays.toString(ints));
        
        int[] ints2 = p1310.prefixion(arr, queries);
        System.out.println(Arrays.toString(ints2));
        
    }
}
