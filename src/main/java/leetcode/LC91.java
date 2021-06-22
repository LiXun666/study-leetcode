package leetcode;

import javax.annotation.Resource;

/**
 * @Author:lx
 * @Date: 2021/4/21 12:47
 * @Description:
 * 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 */
public class LC91 {
    public int numDecodings(String s) {
        //如果第一位是0，返回0
        //如果3-9后面有0，返回0
        //如果0后面有0.返回0
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

}
