package hj;

import java.util.Scanner;

/**
 * @Author lxjj
 * @Date 2021-07-19 15:54
 * @Description
 * 购物单
 * 0-1背包
 */
public class HJ16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int moeny = sc.nextInt()/10;
            int n = sc.nextInt();

            int[][] prices = new int[n+1][3];//价格
            int[][] weight = new int[n+1][3];//权重
            for(int i = 1;i < n+1; i++){
                int a = sc.nextInt()/10;
                int b = sc.nextInt()*a;
                int c = sc.nextInt();
                if(c==0){
                    prices[i][0]=a;
                    weight[i][0]=b;
                }else{
                    if(prices[c][1] == 0){
                        prices[c][1]=a;
                        weight[c][1]=b;
                    }else{
                        prices[c][2]=a;
                        weight[c][2]=b;
                    }
                }
            }

            int[][] dp = new int[n+1][moeny+1];
            for(int i=1; i<n+1;i++){
                for(int j =1; j<moeny+1;j++){
                    int a = prices[i][0],b=weight[i][0];
                    int c = prices[i][1],d=weight[i][1];
                    int e = prices[i][2],f=weight[i][2];
                    dp[i][j]=a<=j?Math.max(dp[i-1][j],dp[i-1][j-a]+b):dp[i-1][j];
                    if(c!=0) dp[i][j]=(a+c)<=j?Math.max(dp[i][j],dp[i-1][j-a-c]+b+d):dp[i][j];
                    if(e!=0) dp[i][j]=(a+e)<=j?Math.max(dp[i][j],dp[i-1][j-a-e]+b+f):dp[i][j];
                    if(c!=0&&d!=0)dp[i][j]=(a+e+c)<=j?Math.max(dp[i][j],dp[i-1][j-a-e-c]+b+d+f):dp[i][j];
                }
            }
            System.out.println(dp[n][moeny]*10);
        }
    }
}
