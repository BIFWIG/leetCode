package cn.bif.general_list.p1_p100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <br>罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <br>
 * <br>
 * <br>字符          数值
 * <br>I             1
 * <br>V             5
 * <br>X             10
 * <br>L             50
 * <br>C             100
 * <br>D             500
 * <br>M             1000
 * <br>
 * <br> 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
 * <br>I 。
 * <br>
 * <br> 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
 * <br> 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <br>
 * <br>
 * <br> I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * <br> X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * <br> C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <br>
 * <br>
 * <br> 给你一个整数，将其转为罗马数字。
 * <br>
 * <br>
 * <br>
 * <br> 示例 1:
 * <br>
 * <br>
 * <br>输入: num = 3
 * <br>输出: "III"
 * <br>
 * <br> 示例 2:
 * <br>
 * <br>
 * <br>输入: num = 4
 * <br>输出: "IV"
 * <br>
 * <br> 示例 3:
 * <br>
 * <br>
 * <br>输入: num = 9
 * <br>输出: "IX"
 * <br>
 * <br> 示例 4:
 * <br>
 * <br>
 * <br>输入: num = 58
 * <br>输出: "LVIII"
 * <br>解释: L = 50, V = 5, III = 3.
 * <br>
 * <br>
 * <br> 示例 5:
 * <br>
 * <br>
 * <br>输入: num = 1994
 * <br>输出: "MCMXCIV"
 * <br>解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <br>
 * <br>
 * <br>
 * <br> 提示：
 * <br>
 * <br>
 * <br> 1 <= num <= 3999
 * <br>
 * <br> Related Topics 数学 字符串
 * <br> 👍 573 👎 0
 * <br>[12]整数转罗马数字
 *
 * @author Ted Wang
 * @created 2021/5/14 10:17 上午
 */
public class P12 {
    
    
    public String intToRoman (int num) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        StringBuilder s = new StringBuilder();
        while (num != 0) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                while (num - entry.getKey() >= 0) {
                    s.append(entry.getValue());
                    num = num - entry.getKey();
                }
            }
        }
        return s.toString();
    }
    
    
    public static void main (String[] args) {
        P12 p12 = new P12();
    
        System.out.println(p12.intToRoman(1800));
    }
}
