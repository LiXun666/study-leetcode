package leetcode;

/**
 * @Author:lx
 * @Date: 2021/3/29 11:27
 * @Description:
 *  颠倒二进制位
 */
public class LC190 {
    public static void main(String[] args) {

        reverseBits(3);
    }
    public static int reverseBits(int n) {
        int  res = 0;
        for(int i = 0; i < 32 && n != 0; i++){
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return res;
    }
}
