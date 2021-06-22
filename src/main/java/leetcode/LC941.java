package leetcode;


/**
 * @Author:lx
 * 有效的山脉数组
 *
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 *      A[0] < A[1] < ... A[i-1] < A[i]
 *      A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * @Date: 2020/11/3 10:47
 * @Description:
 */
public class LC941 {

    //双指针，前后各一个找到左边最高和右边最高看是不是同一个
    public boolean validMountainArray(int[] A) {
        if(A.length<3){
            return false;
        }
        int left = 0;
        int right = A.length-1;
        while (left+1< A.length && A[left+1]>A[left]){
            left++;
        }
        while (right>0 && A[right-1]>A[right] ){
            right--;
        }
        return left>0 && right<A.length-1&&left ==right;
    }

    //线性扫描,如果下降数组最后就指向最后一个数，那么就是符合要求的，返回true
    public boolean validMountainArray2(int[] A){
        int i =0;
        //扫描递增数组
        while (i+1<A.length&&A[i]<A[i+1]){
            i++;
        }
        //判断是否是一个单增或者单减数组，如果是返回false
        if (i==0||i==A.length-1){
            return false;
        }
        //递减数组
        while (i+1<A.length&&A[i]>A[i+1]){
            i++;
        }
         return i==A.length-1;
    }
}
