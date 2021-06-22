package leetcode;

/**
 * @author: liuhj
 * @Date: 2021/2/19 11:11
 * Description:
 */
public class LC1004 {
    public static void main(String[] args) {
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(A, 3));
    }

    public static int longestOnes(int[] A, int K) {
        int l = 0, r = 0;
        while (r < A.length) {
            if (A[r++] == 0){
                K--;
            }
            if (K < 0 && A[l++] == 0) {
                K++;
            }
        }
        return r - l;
    }

    //滑动窗口
    public static int longestOnes2(int[] A, int K){
        int l = 0, r = 0;
        int ans = 0;
        int zeros = 0;
        while (r<A.length){
            if (A[r] == 0){
                zeros++;
            }
            while (zeros >K){
                if (A[l++] == 0){
                    zeros --;
                }
            }
            ans = Math.max(ans,r - l + 1);
            r++;
        }
        return ans;
    }
    /*
    滑动窗口模板
    def findSubArray(nums):
    N = len(nums) # 数组/字符串长度
    left, right = 0, 0 # 双指针，表示当前遍历的区间[left, right]，闭区间
    sums = 0 # 用于统计 子数组/子区间 是否有效，根据题目可能会改成求和/计数
    res = 0 # 保存最大的满足题目要求的 子数组/子串 长度
    while right < N: # 当右边的指针没有搜索到 数组/字符串 的结尾
        sums += nums[right] # 增加当前右边指针的数字/字符的求和/计数
        while 区间[left, right]不符合题意：# 此时需要一直移动左指针，直至找到一个符合题意的区间
            sums -= nums[left] # 移动左指针前需要从counter中减少left位置字符的求和/计数
            left += 1 # 真正的移动左指针，注意不能跟上面一行代码写反
        # 到 while 结束时，我们找到了一个符合题意要求的 子数组/子串
        res = max(res, right - left + 1) # 需要更新结果
        right += 1 # 移动右指针，去探索新的区间
    return res
     */
}
