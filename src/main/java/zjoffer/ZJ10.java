package lxjj.demo.zjoffer;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * @Description TODO
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 * @Date 2020/9/26 11:00
 * @Created by lx
 */
public class ZJ10 {

    /**
     * 思路：
     * f(n)=f(n-1)+f(n-2)
     *
     * n = 4 的时候
     * 第 4 级横着覆盖，用了一级，剩下 n = 3，有三种覆盖方法
     * 第 4 级竖着覆盖，用了两级，剩下 n = 2，有两种覆盖方法
     * 总共有 5 种方法
     * 第n级
     * 第 n 级横着覆盖，用了一级，剩下n-1，有f(n-1)种
     * 第 n 级竖着覆盖，用了两级级，剩下n-1，有f(n-2)种
     * 故f(n)=f(n-1)+f(n-2)
     */

    //递归，f(n)=f(n-1)+f(n-2)
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        return RectCover(target-1)+RectCover(target-2);

    }

    //循环
    public int RectCover2(int target){
        if (target <= 2) {
            return target;
        }
        int f = 1;
        int s = 2;
        for (int i = 3;i<=target;i++){
            int sum = f + s;
            f = s;
            s = sum;
        }
        return s;
    }

    //循环优化
    public int RectCover3(int target){
        if (target <= 2) {
            return target;
        }
        int sum = 2;
        int f = 1;
        for (int i = 3;i<=target;i++){
            sum = sum +f;
            f = sum - f;
        }
        return sum;
    }

    //数组 但是数组长度不行
//    public int RectCover4(int target){
//
//        int[] ints = new int[100];
//        ints[0] = 0;
//        ints[1] = 1;
//        ints[2] = 2;
//        for (int i = 3;i<=target;i++){
//            ints[i] = ints[i-1]+ints[i+2];
//        }
//        return ints[target];
//    }
}
