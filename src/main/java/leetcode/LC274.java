package leetcode;

import java.util.Arrays;
import java.util.Calendar;

/**
 * @Author lxjj
 * @Date 2021-07-12 9:23
 * @Description
 * H 指数
 */
public class LC274 {
    //排序
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            count++;
            if (citations[i] <= count){
                if (citations[i]<count) count--;
                break;
            }
        }
        return count;
    }
    //计数排序
    public int hIndex2(int[] citations){
        int n = citations.length;
        int[] counts = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                counts[n]++;
            }else{
                counts[citation]++;
            }
        }
        int res = 0;
        for (int i = n; i >= 0; i--) {
            res+=counts[i];
            if (res >= i){
                return i;
            }
        }
        return 0;

    }
}
