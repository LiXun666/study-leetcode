package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:lx
 * 距离顺序排列矩阵单元格:
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 * @Date: 2020/11/17 18:13
 * @Description:
 */
public class LC1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] arr = new int[R*C][2];
        for (int i = 0; i< R; i++){
            for (int j = 0;j<C ; j++){
                arr[i*C +j][0] = i;
                arr[i*C +j][1] = j;
            }
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> (Math.abs(o[0] - r0) + Math.abs(o[1] - c0))));
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return ((Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0)) - (Math.abs(o2[0]-r0)+Math.abs(o2[1]-c0)));
//            }
//        });
        return arr;
    }
}
