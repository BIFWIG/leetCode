/*
 * Copyright (c) 2005, 2019, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.bif.general_list.p701_p800;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * <p>
 * <p>
 * 注意:
 * <p>
 * <p>
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复。
 * <p>
 * Related Topics 哈希表
 * 👍 559 👎 0
 *
 * @author Ted Wang
 * @created 2020/9/4 2:42 下午
 */
public class P771 {
    
    public static void main (String[] args) {
        System.out.println(new P771().numJewelsInStones2("aA", "aAAbbbb"));
    }
    
    public int numJewelsInStones (String J, String S) {
        Map<Character, Integer> map = new HashMap<>(50);
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Integer gem = 0;
        for (char c : J.toCharArray()) {
            gem += map.getOrDefault(c, 0);
        }
        
        
        return gem;
    }
    
    public int numJewelsInStones2 (String J, String S) {
        // bitMap解法
        int[] bit = new int[4];
        int lenJ = J.length();
        int lenS = S.length();
        int sum = 0;
        for (int i = 0; i < lenJ; i++) {
            bit[J.charAt(i) / 32] |= (1 << (J.charAt(i) % 32));
        }
        for (int j = 0; j < lenS; j++) {
            if ((bit[S.charAt(j) / 32] & (1 << (S.charAt(j) % 32))) != 0){
                 sum++;
            }
        }
        return sum;
        
        
    }
}
