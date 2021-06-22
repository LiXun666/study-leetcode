package datastructure.sort;

import com.sun.media.sound.AiffFileReader;

import java.util.Arrays;

/**
 * @Author:lx
 * @Date: 2021/1/17 17:21
 * @Description:
 */
public class RadixSort {
    public static void main(String[] args) {

        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);
    }
    public static void radixSort(int[] arr){
        //找到最大的数
        int max = 0;
        for (int ar : arr) {
            if (ar > max ){
                max = ar;
            }
        }
        //最大的数的位数
        int maxlength = (max + "").length();
        //创建十个桶
        int[][] bucket = new int[10][arr.length];
        int[] bucketIndex = new int[10];

        for (int i = 0 , n = 1; i < maxlength; i++ , n *= 10 ) {
            //把数字全部放入桶中
            for (int j = 0; j<arr.length; j++){
                //该数字的尾数
                int digitOfElement = arr[j] / n % 10;
                //把这个数字放到到该放的那个桶中
                bucket[digitOfElement][bucketIndex[digitOfElement]++] = arr[j];
            }
            int index = 0;
            //把数字需要取出来
            for (int k = 0; k < bucketIndex.length; k++) {
                //如果该桶数字不为零证明有数据需要取出来
                if (bucketIndex[k] != 0){
                    //一个一个桶来遍历取出
                    for (int l = 0;l < bucketIndex[k]; l++){
                        arr[index++] = bucket[k][l];
                    }
                }
                //将一个桶取完了之后，需要吧这个桶的bucketIndex清0，因为在下一轮开始向里放的时候需要从第0的位置开始放
                bucketIndex[k] = 0;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
