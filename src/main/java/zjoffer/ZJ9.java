package lxjj.demo.zjoffer;

import sun.print.SunMinMaxPage;

/**
 * @Description TODO
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Date 2020/9/25 21:58
 * @Created by lx
 */
public class ZJ9 {

    /**
     * 思路：
     * 跳上第n级台阶之前可能是在 n-1或者n-2级台阶上，
     * 所以f(n)=f(n-1)+f(n-2)+…… f(1)+1
     *     f(n-1)=f(n-2)+f(n-3)+…… 1  可以得到f(n)=2f(n-1)
     *
     */

    //递归f(n)=f(n-1)+f(n-2)+…… 1
    public int JumpFloorII(int target) {

        if(target <= 2){
            return target;
        }
        int sum = 1;
        for (int i=1;i<target;i++){
            sum += JumpFloorII(i);
        }
        return sum;
    }

    //相当于2的n-1次方
    public int JumpFloorII2(int target){
        int sum = 1;
        for (int i = 1; i <target; i++){
            sum = 2* sum;
        }
        return sum;
    }

    //

}
