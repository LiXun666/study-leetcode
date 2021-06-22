package datastructure.sort;

import com.sun.xml.internal.ws.api.message.MessageWritable;
import com.sun.xml.internal.ws.api.server.SDDocumentFilter;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author:lx
 * @Date: 2021/1/13 15:04
 * @Description:
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date1));

        shellSort(arr);

        Date date2 = new Date();
        System.out.println(simpleDateFormat.format(date2));

    }


    //交换法的shell排序
    public static void shellSort(int[] arr) {
        int temp = 0;
        //将其分成了两组
        for (int gap = (arr.length / 2); gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //移动法的shell排序
    public static void shellSort2(int[] arr) {

        for (int gap = (arr.length / 2); gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
