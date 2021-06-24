package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lxjj
 * @Date 2021-06-24 9:08
 * @Description 直线上最多的点数
 */
public class LC149 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 2) return n;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ans >= n - i || ans > n / 2) break;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gysXY = gys(Math.abs(x),Math.abs(y));
                    x /= gysXY;
                    y /= gysXY;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key,0)+1);
            }
            //然后找到过i点的斜率最大的值
            int maxn = 0;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                int value = entry.getValue();
                maxn = Math.max(maxn,value+1);
            }
            ans = Math.max(ans,maxn);
        }
        return ans;
    }

    private static int gys(int a, int b) {
        return b !=0 ? gys(b,a%b) : a;
    }
}
