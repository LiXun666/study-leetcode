import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-05 9:33
 * @Description
 * 错误的集合
 */
public class LC645 {
    //map
    public int[] findErrorNums(int[] nums) {
        int er = 0;
        int ri = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.getOrDefault(i, 0) == 2) {
                er = i;
            } else if (map.getOrDefault(i, 0) == 0) {
                ri = i;
            }

        }
        return new int[]{er, ri};
    }

    //数学
    public int[] findErrorNums2(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        int repeat = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                repeat = nums[i];
            }else{
                set.add(nums[i]);
                sum1 += nums[i];
            }
        }
        int lose = (n+1)*n/2 - sum1;
        return new int[]{repeat, lose};
    }

    //排序
    public int[] findErrorNums3(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        int repeat = 0, lose = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr == prev) {
                repeat = prev;
            } else if (curr - prev > 1) {
                lose = prev + 1;
            }
            prev = curr;
        }
        if (nums[n-1] != n) lose = n;
        return new int[]{repeat,lose};
    }
}
