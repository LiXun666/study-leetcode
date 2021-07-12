package newcoder;

import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 * @Author lxjj
 * @Date 2021-07-12 21:20
 * @Description 扑克牌顺子
 */
public class NC63 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 5, 4};
        System.out.println(IsContinuous(nums));
    }
    //如果有重复的非0，直接false,只要最大减去最小小于5就行，别重复
    public static boolean IsContinuous(int[] numbers) {
        Arrays.sort(numbers);

        int low = 0,high = numbers[4];
        for(int j = 0; j < numbers.length; j++){
            if(numbers[j] == 0) {
                low++;
            }else if(j+1<numbers.length && numbers[j] == numbers[j+1]) return false;
        }
        return high-numbers[low]<5;

    }
}
