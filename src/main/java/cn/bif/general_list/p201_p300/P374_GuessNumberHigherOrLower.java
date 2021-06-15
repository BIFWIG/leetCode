
package cn.bif.general_list.p201_p300;

/**
 * <br/>[374]猜数字大小
 * <br/>猜数字游戏的规则如下：
 * <br/>
 * <br/>
 * <br/> 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * <br/> 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * <br/>
 * <br/>
 * <br/> 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <br/>
 * <br/>
 * <br/> -1：我选出的数字比你猜的数字小 pick < num
 * <br/> 1：我选出的数字比你猜的数字大 pick > num
 * <br/> 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * <br/>
 * <br/>
 * <br/> 返回我选出的数字。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：n = 10, pick = 6
 * <br/>输出：6
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：n = 1, pick = 1
 * <br/>输出：1
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：n = 2, pick = 1
 * <br/>输出：1
 * <br/>
 * <br/>
 * <br/> 示例 4：
 * <br/>
 * <br/>
 * <br/>输入：n = 2, pick = 2
 * <br/>输出：2
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= n <= 231 - 1
 * <br/> 1 <= pick <= n
 * <br/>
 * <br/> Related Topics 二分查找
 * <br/> 👍 127 👎 0
 **/
public class P374_GuessNumberHigherOrLower {
    public static void main (String[] args) {
        Solution solution = new P374_GuessNumberHigherOrLower().new Solution();
        solution.num = 2;
        System.out.println(solution.guessNumber(2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * int guess(int num);
     */
    
    public class Solution extends GuessGame {
        public int guessNumber (int n) {
            int start = 1;
            int end = n;
            int mid = 1;
            while (start <= end) {
                mid = start + (end - start) / 2;
                switch (guess(mid)) {
                    
                    case -1:
                        end = mid;
                        break;
                    case 1:
                        start = mid + 1;
                        break;
                    default:
                       return mid;
                }
                
                
            }
            return mid;
        }
        
        
    }
    
    class GuessGame {
        public int num;
        
        int guess (int n) {
            if (n > num) {
                return -1;
            }
            if (n < num) {
                return 1;
                
            }
            return 0;
            
        }
        
        
    }
//leetcode submit region end(Prohibit modification and deletion)

}
