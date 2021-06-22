package leetcode;


import com.sun.scenario.effect.impl.prism.ps.PPSBlend_MULTIPLYPeer;
import jdk.nashorn.internal.ir.IfNode;

/**
 * @Author:lx 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * @Date: 2020/11/12 12:51
 * @Description:
 */
public class LC922 {

    //遍历两次
    public int[] sortArrayByParityII2(int[] A) {
        int[] ints = new int[A.length];
        int ji = 1;
        int ou = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2 ==0){
                ints[ou] = A[i];
                ou += 2;
            }else {
                ints[ji] = A[i];
                ji += 2;
            }
        }
        return ints;
    }

    //双指针法
    //一个指针指向偶数，当碰到不符合的，奇数指针也遍历奇数，找到不符合的互换位置
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 0) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int tem = A[i];
        A[i] = A[j];
        A[j] = tem;
    }
}
