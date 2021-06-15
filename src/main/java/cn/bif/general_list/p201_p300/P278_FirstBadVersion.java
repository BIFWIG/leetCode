
package cn.bif.general_list.p201_p300;

/**
 * <br/>[278]第一个错误的版本
 * <br/>你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有
 * <br/>版本都是错的。
 * <br/>
 * <br/> 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <br/>
 * <br/> 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
 * <br/>的版本。你应该尽量减少对调用 API 的次数。
 * <br/>
 * <br/> 示例:
 * <br/>
 * <br/> 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * <br/>
 * <br/>调用 isBadVersion(3) -> false
 * <br/>调用 isBadVersion(5) -> true
 * <br/>调用 isBadVersion(4) -> true
 * <br/>
 * <br/>所以，4 是第一个错误的版本。 
 * <br/> Related Topics 二分查找
 * <br/> 👍 327 👎 0
 **/
public class P278_FirstBadVersion {
    public static void main (String[] args) {
        Solution solution = new P278_FirstBadVersion().new Solution();
        int n = 0;
        for (int i = 0; i < 10; i++) {
            solution.errorVersion = (int)(Math.random()*(n+1));
            System.out.print("版本："+solution.errorVersion+"\t");
            System.out.println("答案: "+solution.firstBadVersion(n));
        }
      
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    
    public class Solution extends VersionControl {
        public int firstBadVersion (int n) {
            int start = 0;
            int end = n;
            while (start<end){
                int mid = (end-start)/2+start;
                if (isBadVersion(mid)) {
                    end = mid;
                }else{
                    start  = mid+1;
                }
            }
            
            
            return start;
        }
    }
    
    
    class VersionControl{
        
        public int errorVersion;
        
        public Boolean isBadVersion(int number){
        
            if (number>=errorVersion){
                return true;
            }else{
                return false;
            }
        
        }
    
    }
//leetcode submit region end(Prohibit modification and deletion)

}
