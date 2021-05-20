
package cn.bif.general_list.p601_p700;

import java.util.*;

/**
 * <br/>[692]前K个高频单词
 * <br/>给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <br/>
 * <br/> 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * <br/>输出: ["i", "love"]
 * <br/>解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * <br/>    注意，按字母顺序 "i" 在 "love" 之前。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
 * <br/> = 4
 * <br/>输出: ["the", "is", "sunny", "day"]
 * <br/>解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * <br/>    出现次数依次为 4, 3, 2 和 1 次。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 注意：
 * <br/>
 * <br/>
 * <br/> 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * <br/> 输入的单词均由小写字母组成。
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 扩展练习：
 * <br/>
 * <br/>
 * <br/> 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 * <br/>
 * <br/> Related Topics 堆 字典树 哈希表
 * <br/> 👍 247 👎 0
 **/
public class P692_TopKFrequentWords {
    public static void main (String[] args) {
        Solution solution = new P692_TopKFrequentWords().new Solution();
        String[] s = {"i", "love", "leetcode", "i", "love", "coding", "a", "a"};
        List<String> l= new ArrayList<>();
        l.add("a");
        l.add("i");
        l.stream().sorted(String::compareTo).forEach(System.out::println);
        
        l.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        
        System.out.println(solution.topKFrequent(s, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent (String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
                // 相同情况，字母大的排前面
                if (map.get(o1)
                       .equals(map.get(o2))) {
                    return o2.compareTo(o1);
                } else {
                    // 不同情况，数字小的排前面
                    return map.get(o1) - map.get(o2);
                }
            });
            
            for (String s : map.keySet()) {
                queue.offer(s);
                if (queue.size() > k) {
                    // 弹出小的或者字母大的
                    queue.poll();
                }
            }
            ArrayList<String> arrayList = new ArrayList<>();
            while (queue.size()>0){
                arrayList.add(queue.poll());
            }
            // 最后逆序输出
            Collections.reverse(arrayList);
            return arrayList;
        }
    
    
    }
//leetcode submit region end(Prohibit modification and deletion)

}
