/*
 * Copyright (c) 2005, 2019, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.bif.general_list.p301_p400;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * <p>
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * Related Topics 数学 动态规划
 * 👍 408 👎 0
 *
 * @author Ted Wang
 * @created 2020/11/27 4:27 下午
 */
public class P343 {
    public static void main (String[] args) {
        System.out.println(new P343().integerBreak(10));
    }
    
    
    public int integerBreak (int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        
        for (int i = 3; i < n + 1; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i - j; j++) {
                // 目前的值 ，只拆分两个， 进一步拆分 三个的最大值作为当前数字的最大乘积
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        
        
        return dp[n];
    }
}
