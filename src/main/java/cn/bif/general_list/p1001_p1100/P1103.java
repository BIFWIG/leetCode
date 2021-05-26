/*
 * Copyright (c) 2005, 2019, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.bif.general_list.p1001_p1100;

import java.util.Arrays;

/**
 * 排排坐，分糖果。
 * <p>
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * <p>
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * <p>
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * <p>
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发
 * 出的糖果多），这些糖果也会全部发给当前的小朋友。
 * <p>
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candies = 7, num_people = 4
 * 输出：[1,2,3,1]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 * 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：candies = 10, num_people = 3
 * 输出：[5,2,3]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3]。
 * 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= candies <= 10^9
 * 1 <= num_people <= 1000
 * <p>
 * Related Topics 数学
 * 👍 82 👎 0
 * 没啥内容，纯数学公式推导， 先计算完美的几轮，完美发放完后，每个人的糖，然后计算剩余的糖怎么发
 * @author Ted Wang
 * @created 2020/11/27 3:36 下午
 **/
public class P1103 {
    public static void main (String[] args) {
        System.out.println(Arrays.toString(new P1103().distributeCandies(7, 4)));
    }
    
    
    public int[] distributeCandies (int candies, int num_people) {
        
        int n = 0;
        int last = candies;
        while (true) {
            int t = (1 + (n + 1) * num_people) * ((n + 1) * num_people) / 2;
            if (t > candies) {
                break;
            } else {
                n++;
                last = candies - t;
            }
        }
        
        int[] result = new int[num_people];
        int nn = n - 1;
        for (int i = 0; i < num_people; i++) {
            result[i] = ((nn * nn) + nn) / 2 * num_people + (nn + 1) * (i + 1);
            if (last > 0) {
                result[i] += Math.min(last, n * num_people + i + 1);
                last -= num_people * n + i + 1;
            }
        }
        
        
        return result;
    }
}
