package leetcode;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/4/27 12:22
 * @Description: 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 */
public class LC1011 {
    public int shipWithinDays(int[] weights, int D) {
        //运载力肯定在 最大值与和之间
        int right = 0, left = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        while (left < right) {
            int pivot = left + (right-left)/2;
            //如果重点的位置能运完，那么right = pivot ，否则left = pivot+1
            if (check(weights,D,pivot)){
                right = pivot;
            }else{
                left = pivot+1;
            }
        }
        return left;
    }

    private boolean check(int[] weights, int d, int pivot) {
        //需要云完的最小天数
        int count = 1;
        int weight = 0;
        for (int i = 0; i < weights.length; i++) {
            weight += weights[i];
            if (weight > pivot){
                count++;
                weight = weights[i];
            }
        }
        if (count >d){
            return false;
        }
        return true;
    }
}
