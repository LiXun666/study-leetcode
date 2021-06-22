package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/26 14:52
 * @Description:
 * Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 */
public class LC171 {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = columnTitle.charAt(i) -'A'+1;
            ans += (int)Math.pow(26,n-1-i) * a;
        }
        return ans;
    }
}
