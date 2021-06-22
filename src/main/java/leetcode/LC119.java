package leetcode;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/4/16 15:05
 * @Description: 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class LC119 {
    //暴力法
    public List<Integer> getRow(int rowIndex) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    res.add(1);
                } else {
                    res.add(temp.get(j - 1) + temp.get(j));
                }

            }
            temp = res;
        }
        return temp;
    }

    //O（1）
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

}
