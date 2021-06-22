package leetcode;

/**
 * @author: liuhj
 * @Date: 2021/2/23 10:25
 * Description:
 * 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业customers.length分钟。
 * 每分钟都有一些顾客（customers[i]）会进入书店，
 * 所有这些顾客都会在那一分钟结束后离开。
 *在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0
 * 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续X 分钟不生气，但却只能使用一次。
 *
 * 思路：
 * 所有满意的人可以分为两部分
 * 1 所有老板满意时的人数 把所有 grumpy==0 的人数加起来
 * 2 老板使用技能后满意的人数 在X范围内，grumpy==1的人加起来，并找到最大值
 */
public class LC1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //先计算出所有满意的顾客
        int total = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        //使用滑动窗口,找到x范围内的可增加值
        int increse = 0;
        for (int i = 0; i < X; i++) {
            increse += customers[i] * grumpy[i];
        }
        //窗口滑动，maxincrese为最大得增加值,开始的时候最大增加值就是增加值
        int maxIncrese = increse;
        for (int i = X; i < grumpy.length; i++) {
            increse = increse - grumpy[i - X] * customers[i - X] + grumpy[i] * customers[i];
            maxIncrese = Math.max(increse,maxIncrese);
        }
        return total + maxIncrese;
    }
}
