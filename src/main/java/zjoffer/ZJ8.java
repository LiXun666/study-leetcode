package lxjj.demo.zjoffer;

/**
 * @Description TODO
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @Date 2020/9/23 10:38
 * @Created by lx
 */
public class ZJ8 {
    /**
     * 思路:
     *
     * 显然，由于它可以跳1级台阶或者2级台阶，所以它上一步必定在第n-1,或者第n-2级台阶，
     * 也就是说它跳上n级台阶的跳法数是跳上n-1和跳上n-2级台阶的跳法数之和。
     * 设跳上n级台阶有f(n)种跳法，则它跳上n级的台阶有f(n)=f(n=1)+f(n-2)种跳法。
     *
     */


    //存储前两个数
    public int JumpFloor(int target) {
        if(target<=2){
            return target;
        }
        int p1 = 2 ;
        int p2 = 1;
       for (int i = 3; i<=target; i++){
           int sum = p1 + p2;
           p2 = p1;
           p1 = sum;
       }
       return p1;

    }
    //递归
    public int JumpFloor2(int target) {
        if (target <= 2) {
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

}
