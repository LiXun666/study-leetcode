package leetcode;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lx
 * @Date: 2021/4/16 14:44
 * @Description:
 * 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i){
                    row.add(1);
                }else{
                    row.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
                }
            }
            list.add(row);
        }
        return list;
    }
}
