package leetcode;

import sun.security.util.Length;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuhj
 * @Date: 2021/2/20 10:25
 * Description:
 * 数组的度
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class LC697 {
    /*
    思路：
    1.遍历所有元素，把对应的数字用哈希表存储起来，value用数组表示次数，开始位置和结束位置
    2.再次遍历数组，如果该数字出现的最多，则用一个变量记录他的长度
    3.如果好几个数字出现的一样多，则需要比较哪个的长度最短
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> integerEntry : map.entrySet()) {
            int[] temp = integerEntry.getValue();
            if (temp[0] > maxNum) {
                maxNum = temp[0];
                minLen = temp[2] - temp[1] + 1;
            } else if (temp[0] == maxNum) {
                Math.min(minLen, temp[2] - temp[1] + 1);
            }
        }
        return minLen;
    }
}
