/*
 * Copyright (c) 2005, 2019, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.bif.general_list.p301_p400;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 27
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：n = 9
 * <p>
 * 输出：true
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 45
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * 进阶：
 * <p>
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * Related Topics 数学
 * 👍 132 👎 0
 *
 * @author Ted Wang
 * @created 2020/11/28 11:47 下午
 */
public class P326 {
    public static void main (String[] args) {
        System.out.println(new P326().isPowerOfThree(100));
    }
    /**
     * 描述 直接打表，发现数字很少，那直接硬编码
     * @author Ted Wang
     * @created 2020/11/29 12:02 上午
     * @param n
     * @return  boolean
     **/
    public boolean isPowerOfThree (int n) {
//        if (n<=0){
//           return  false;
//        }
//        Set<Long> hash = new HashSet<>();
//        hash.add(1L);
//        long i = 3;
//        while (i < Integer.MAX_VALUE) {
//            hash.add(i);
//            i = i * 3;
//            System.out.print("n=="+i+"||");
//        }
//        return hash.contains((long) n);
        if (n==1 || n==3 || n == 9 || n == 27 || n == 81 || n == 243 || n == 729 || n == 2187 || n == 6561 || n == 19683 || n == 59049 || n == 177147 || n == 531441 || n == 1594323 || n == 4782969 || n == 14348907 || n == 43046721 || n == 129140163 || n == 387420489 || n == 1162261467) {
            return true;
        }
        return false;
    }
}
