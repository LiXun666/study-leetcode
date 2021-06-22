package leetcode;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/1/15 11:07
 * @Description:
 *  整数反转
 *
 *  给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class LC7 {


    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            int temp = x % 10;
            if (res>Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE /10 && temp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-Integer.MAX_VALUE/10 || (res == -Integer.MAX_VALUE/2 && temp<-8)) {
                return 0;
            }
            res = res * 10 +temp;
            x /= 10;
        }
        return res;
    }
}
