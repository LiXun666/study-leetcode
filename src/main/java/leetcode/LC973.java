package leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.security.x509.CRLDistributionPointsExtension;

import java.util.*;

/**
 * @Author:lx
 * 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * @Date: 2020/11/9 10:48
 * @Description:
 */
public class LC973 {
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        kClosest(points,2);
    }
    public static int[][] kClosest(int[][] points, int K) {
        if (K<1){
            return null;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                //return distance(o2) - distance(o1);
                return (o1[0]*o1[0]+o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1]);  //按升序排列
            }
        });
        for (int[] point : points) {
            System.out.println(point);
        }
        return Arrays.copyOfRange(points,0,K);
    }

}
