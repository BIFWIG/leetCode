
package cn.bif.general_list.p801_p900;

/**
 * <br/>[852]山脉数组的峰顶索引
 * <br/>符合下列属性的数组 arr 称为 山脉数组 ：
 * <br/>
 * <br/> arr.length >= 3
 * <br/> 存在 i（0 < i < arr.length - 1）使得：
 * <br/>
 * <br/> arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * <br/> arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i +
 * <br/>1] > ... > arr[arr.length - 1] 的下标 i 。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/>
 * <br/>输入：arr = [0,1,0]
 * <br/>输出：1
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/>
 * <br/>输入：arr = [0,2,1,0]
 * <br/>输出：1
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/>
 * <br/>输入：arr = [0,10,5,2]
 * <br/>输出：1
 * <br/>
 * <br/>
 * <br/> 示例 4：
 * <br/>
 * <br/>
 * <br/>输入：arr = [3,4,5,1]
 * <br/>输出：2
 * <br/>
 * <br/>
 * <br/> 示例 5：
 * <br/>
 * <br/>
 * <br/>输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * <br/>输出：2
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 3 <= arr.length <= 104
 * <br/> 0 <= arr[i] <= 106
 * <br/> 题目数据保证 arr 是一个山脉数组
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 * <br/> Related Topics 二分查找
 * <br/> 👍 166 👎 0
 **/
public class P852_PeakIndexInAMountainArray {
    public static void main (String[] args) {
        Solution solution = new P852_PeakIndexInAMountainArray().new Solution();
        int[] arr = {3,4,5,1};
        System.out.println(solution.peakIndexInMountainArray(arr));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int peakIndexInMountainArray (int[] arr) {
            int start = 0;
            int end = arr.length-1;
            int mid = start+(end-start)/2;
            while (true){
                mid = start+(end-start)/2;
               if (arr[mid]>arr[mid-1] && arr[mid] > arr[mid+1]){
                   return mid;
               }
               if (arr[mid]>arr[mid-1]){
                   start = mid;
               }
               if (arr[mid]>arr[mid+1]){
                    end = mid;
               }
               
               
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
