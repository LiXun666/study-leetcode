package lxjj.demo.zjoffer;

/**
 * @Description TODO
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * @Date 2020/9/27 15:38
 * @Created by lx
 */
public class ZJ11 {

    /**
     * 思路:
     * 1、先将数字转换成二进制字符串
     * 2、用String.split()函数存入一个数组中
     * 3、遍历数组跟1比较，同时计数
     * 4、输出计数值
     *
     * >>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；
     * >>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0
     */



    public int NumberOf1(int n){

        String s=Integer.toBinaryString(n);
        String[] split = s.split("");
        int a= 0;
        for (int i = 0;i < split.length;i++){
            if (split[i].equals("1")){
                a++;
            }
        }

        return a;
    }

    public int NumberOf1x(int n){
        int count = 0;
        while(n!=0){
                count++;
                n=n&(n-1);
        }
        return count;
    }
}
