package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:lx
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * @Date: 2020/11/16 10:57
 * @Description:
 */
public class LC406 {
    /**
     * 解题思路：先排序再插入
     *  1.排序规则：按照先H高度降序，K个数升序排序
     *  2.遍历排序后的数组，根据K插入到K的位置上
     *
     *  核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     *
     * @param people
     * @return
     */
    public  static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] people1, int[] people2) {
                //h不相等降序
                if (people1[0] != people2[0]){
                    return people2[0] - people1[0];
                }else{
                    //h相等，k升序
                    return people1[1] - people2[1];
                }
            }
        });
        List<int[]> list = new ArrayList<int[]>();
        for (int[] person : people) {
            list.add(person[1],person);
        }
        return list.toArray(new int[list.size()][]);
    }

}
