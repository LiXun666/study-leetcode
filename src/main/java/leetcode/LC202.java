package leetcode;

import java.util.HashSet;

/**
 * @Author:lx
 * @Date: 2021/4/27 16:41
 * @Description:
 * 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 */
public class LC202 {
    //要么回到以 要么是个循环，使用set来存储
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        //编写一个函数求 该数的下一个数是啥
        while (n!=1 && !set.contains(n)){
            set.add(n);
            n = next(n);
        }
        return n==1;
    }

    //相当于判断一个链表是否有环，快慢指针
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = next(n);
        while (fast !=1 && slow != fast){
            slow = next(slow);
            fast = next(next(fast));
        }


        return fast==1;
    }

    private int next(int n) {
        int ans = 0;
        while(n>0){
            int i = n % 10;
            ans += i*i;
            n /= 10;
        }
        return ans;
    }
}
