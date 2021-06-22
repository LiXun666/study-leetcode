package lxjj.demo.zjoffer;

/**
 * @Description TODO
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * @Date 2020/9/28 11:47
 * @Created by lx
 */
public class ZJ12 {

    /**
     * 思路：
     * exponent<0; base取倒数，exponent取相反数，循环
     * exponent=0; 返回1
     * exponent>0；直接循环
     *
     */
    public double Power(double base, int exponent) {
        if(base ==1 || exponent == 0){
            return 1;
        }
        double tem = 1;
        if(exponent>0){
             for (int i = 0;i< exponent;i++){
                 tem *= base;
             }
             return tem;
        }
        base = 1/base;
        exponent = -exponent;
        for (int i = 0;i< exponent;i++){
            tem *= base;
        }
        return tem;
    }

    //内置函数
    public double Power2(double base, int exponent){
        return Math.pow(base,exponent);
    }

}
