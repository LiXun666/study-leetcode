package leetcode;

/**
 * @Author:lx
 *  加油站
 *  在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明: 
 *
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 *
 * @Date: 2020/11/18 16:35
 * @Description:
 */
public class LC134 {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        canCompleteCircuit2(gas,cost);
        System.out.println((4+1)%5);
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i =0; i<len; i++){
            //每一个加油站都判断
            int remainGas= gas[i];
            int j = i;
            //到下一个加油站
            while (remainGas - cost[i] >= 0){
                //j表示当前加油站
                remainGas = remainGas - cost[i]+ gas[(j+1)% len];
                j = (j+1)% len;
                if(j == i){
                    //证明回来了
                    return i;
                }
            }
        }
        return -1;
    }
    public static int canCompleteCircuit2(int[] gas, int[] cost){
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndedx = 0;
        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare){
                minSpare = spare;
                minIndedx = i;
            }
        }
        return spare < 0 ? -1 : (minIndedx+1)%len;
    }
}
