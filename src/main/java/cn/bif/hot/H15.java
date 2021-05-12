package cn.bif.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
 * 复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * Related Topics 数组 双指针
 * 👍 3328 👎 0
 *
 * @author Ted Wang
 * @created 2021/5/12 8:22 下午
 */
public class H15 {
    public List<List<Integer>> threeSum (int[] nums) {
        int[] sorted = Arrays.stream(nums)
                             .sorted()
                             .toArray();
        List<List<Integer>> result = new ArrayList<>();
        
        if (sorted.length < 3) {
            return result;
        }
        
        if (sorted[0] > 0) {
            return result;
        }
        
        if (sorted[sorted.length - 1] < 0) {
            return result;
        }
        int cur = 0, first = 1, last = sorted.length - 1;
        if (sorted[0] + sorted[1] > sorted[sorted.length - 1]) {
            // 最小的两个加起来都比最后一个大，肯定不满足条件
            return result;
        }
        while (cur < sorted.length - 2) {
            // 从头
            first = cur + 1;
            //从尾
            last = sorted.length - 1;
            while (first < last) {
                int sum = sorted[cur] + sorted[first] + sorted[last];
                //满足条件
                if (sum == 0) {
                    result.add(Arrays.asList(sorted[cur], sorted[first], sorted[last]));
                }
                // 太小，头往后移动
                if (sum <= 0) {
                    //过滤和当前值相同的
                    while (sorted[first] == sorted[++first] && first != last) {
                    }
                }
                // 太大，尾往前移动
                else {
                    //过滤和当前值相同的
                    while (sorted[last] == sorted[--last] && first != last) {
                    }
                }
            }
            //基准值往后移动
            while (sorted[cur] == sorted[++cur] && cur != sorted.length-1) {
            
            }
            
        }
        
        return result;
    }
    
    public static void main (String[] args) {
        H15 h15 = new H15();
        
        int[] i = {0, 0, 0,0};
        List<List<Integer>> lists = h15.threeSum(i);
        System.out.println(lists);
    }
}
