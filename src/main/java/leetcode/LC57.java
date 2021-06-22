package leetcode;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lx
 * 插入区间
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * @Date: 2020/11/4 10:48
 * @Description:
 */
public class LC57 {
    //思路：
    //遍历intrvals，把每个区间与newInterval比较，无交集的加入到新的列表中，有交集的取并集加入的新的列表中
    //把列表转化成二维数组输出
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int left = newInterval[0];
        int right = newInterval[1];
        //判断是否加入了并集
        boolean p = false;
        List<int[]> ansLists = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            //该区间在新区建的右边,无交集
            if (interval[0] > right){
                //把并集也加进去
                if (!p){
                    ansLists.add(new int[]{left,right});
                    p=true;
                }
                ansLists.add(interval);
            }
            //该区间在新区建的左边,无交集
            else if (interval[1]<left){
                ansLists.add(interval);
            }else{
                //有交集，去两个区间的并集
                left=Math.min(left,interval[0]);
                right=Math.max(right,interval[1]);
            }
        }
        //如果这里还没有吧并集加进去，在这里加进去，此时并集到了最后
        if (!p){
            ansLists.add(new int[]{left,right});
        }
        //现在ansLists是答案，需要把它转换成int[][]
        int[][] ans = new int[ansLists.size()][2];
        int i =0;
        for (int[] ansList : ansLists) {
            ans[i] = ansList;
            i++;
        }
        return ans;
    }
}
