package leetcode;

/**
 * @Author:lx
 * @Date: 2021/3/16 16:39
 * @Description:
 *  盛最多水的容器
 *  给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 *  在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 */
public class LC11 {
    //双指针两边遍历，时间复杂度O(N)，空间O(1)
    public int maxArea(int[] height) {
        int s = 0;
        int l = 0, r = height.length -1;
        while(l < r){
            s = Math.max(s,Math.min(height[l],height[r])*(r-l));
            if(height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }
        return s;
    }
}
