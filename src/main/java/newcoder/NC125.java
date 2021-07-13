package newcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lxjj
 * @Date 2021-07-13 11:11
 * @Description
 *  未排序数组中累加和为给定值的最长子数组长度
 */
public class NC125 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 1, 1, 1,1,1,1,-3};
        System.out.println(maxlenEqualK(arr, 2));
    }
    //连续的
    public static int maxlenEqualK (int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum-k)){
                res = Math.max(res, i- map.get(sum-k));
            }
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return res;
    }
}
