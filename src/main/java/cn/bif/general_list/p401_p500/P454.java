/*
 * Copyright (c) 2005, 2019, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.bif.general_list.p401_p500;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[
 * l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最
 * 终结果不会超过 231 - 1 。
 * <p>
 * 例如:
 * <p>
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * Related Topics 哈希表 二分查找
 * 👍 280 👎 0
 *
 * @author Ted Wang
 * @created 2020/11/27 4:56 下午
 */
public class P454 {
    public static void main (String[] args) {
        System.out.println(new P454()
                .fourSumCount(new int[]{1, 2}, new int[]{-1, -2}, new int[]{-1, 2}, new int[]{0, 2}));
    }
    
    
    public int fourSumCount (int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> mapAB = new HashMap<>();
        // 遍历计算所有a+b 的值
        for (int a : A) {
            for (int b : B) {
                Integer times = mapAB.getOrDefault(a + b, 0);
                mapAB.put(a + b, times + 1);
            }
        }
        // 遍历计算所有 -c-d 的值，和上面的map匹配上代表和=0
        for (int c : C) {
            for (int d : D) {
                res += mapAB.getOrDefault(-c - d, 0);
            }
        }
        
        return res;
    }
}
