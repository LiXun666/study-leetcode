package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/4/15 13:28
 * @Description:
 * 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class LC66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int flag = 1;
        for (int i = n-1; i >= 0; i--) {
            if (digits[i] != 9){
                digits[i] = digits[i]+flag;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
