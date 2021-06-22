package datastructure.sort;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import sun.security.util.Length;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author:lx
 * @Date: 2021/1/6 14:45
 * @Description:
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {-2,10,7,20,5};
        int[] arr = new int[80];
        for (int i = 0; i<80; i++){
            arr[i] = (int) (Math.random()*800000);
        }
        System.out.println(Arrays.toString(arr));

//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat.format(date));
//        System.out.println("开始");
//        bubbleSort(arr);
//
//        Date date1 = new Date();
//        System.out.println(simpleDateFormat.format(date1));
//        System.out.println("结束");
    }

    public static int[] bubbleSort(int[] arr){
        boolean flag = false;
        int tem = 0;

        for (int i = 0; i<arr.length-1;i++){
            for (int j = 0; j< arr.length - 1-i; j++){
                if (arr[j] > arr[j+1]){
                    flag = true;
                    tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
        return arr;
    }

    public static void bubbleSort2(int[] arr){
        if (arr ==null && arr.length<2){
            return ;
        }
        for (int end = arr.length-1 ; end > 0; end--){
            for (int i = 0; i < end; i++){
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }

    public static void swap(int[] nums,int i, int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
