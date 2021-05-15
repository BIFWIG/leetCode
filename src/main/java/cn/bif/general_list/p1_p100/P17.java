package cn.bif.general_list.p1_p100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <br>给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <br>
 * <br> 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <br>
 * <br>
 * <br>
 * <br>
 * <br>
 * <br> 示例 1：
 * <br>
 * <br>
 * <br>输入：digits = "23"
 * <br>输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <br>
 * <br>
 * <br> 示例 2：
 * <br>
 * <br>
 * <br>输入：digits = ""
 * <br>输出：[]
 * <br>
 * <br>
 * <br> 示例 3：
 * <br>
 * <br>
 * <br>输入：digits = "2"
 * <br>输出：["a","b","c"]
 * <br>
 * <br>
 * <br>
 * <br>
 * <br> 提示：
 * <br>
 * <br>
 * <br> 0 <= digits.length <= 4
 * <br> digits[i] 是范围 ['2', '9'] 的一个数字。
 * <br>
 * <br> Related Topics 深度优先搜索 递归 字符串 回溯算法
 * <br> 👍 1307 👎 0
 *
 * @author Ted Wang
 * @created 2021/5/12 9:07 下午
 */
public class P17 {
    
    
    public List<String> list = new ArrayList<>();
    List<List<String>> number = new ArrayList<>();
    
    public List<String> letterCombinations (String digits) {
        
        if (digits.isEmpty()){
            return list;
        }
        
        number.add(new ArrayList<>());
        number.add(Arrays.asList("a", "b", "c"));
        number.add(Arrays.asList("d", "e", "f"));
        number.add(Arrays.asList("g", "h", "i"));
        number.add(Arrays.asList("j", "k", "l"));
        number.add(Arrays.asList("m", "n", "o"));
        number.add(Arrays.asList("p", "q", "r", "s"));
        number.add(Arrays.asList("t", "u", "v"));
        number.add(Arrays.asList("w", "x", "y", "z"));
        dfs(digits,new StringBuilder(),0);
        
        return list;
    }
    
    private void dfs (String digits, StringBuilder letter, int index) {
        if (digits.length() == index) {
            list.add(letter.toString());
            return;
        }
        int c = digits.charAt(index) - '1';
        List<String> list = number.get(c);
        
        for (String s : list) {
            letter.append(s);
            dfs(digits, letter, index + 1);
            letter.deleteCharAt(letter.length() - 1);
            
        }
        
        
    }
    
    
    public static void main (String[] args) {
    
        P17 p17 = new P17();
    
        List<String> list = p17.letterCombinations("");
    
    
        System.out.println(list);
    }
}
