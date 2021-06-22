package datastructure.recursion;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.lang.reflect.Array;

/**
 * @Author:lx
 * @Date: 2020/12/15 11:05
 * @Description:
 */
public class Queue8 {
    int max = 8;
    //定义一个数组，显示所有存放的位置
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {

        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种解法",count);
    }

    //放置皇后
    public void check(int n){
        if (n == max){
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)){//如果执行了，则说明不冲突
                check(n+1);
            }
            //没冲突的话则，array[n]为下一个继续循环
        }

    }

    //编写检查的方法
    public Boolean judge(int n){
        //判断的需要时n之前的
        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //编写一个打印的方法
    public void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
