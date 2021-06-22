package datastructure.sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @author: liuhj
 * @Date: 2021/2/22 17:38
 * Description:
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //把数组arr变成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //最后一个位置上的数字与0位置上的交换
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        //把交换好的数组再还原成一个大根堆
        while (heapSize > 0) {
            heapIfy(arr,0,heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    //这个函数每次把一个数组重新还原成一个大根堆
    public static void heapIfy(int[] arr, int index, int heapSize) {
        //找出该index的左 右子节点与index的最大值，让index 与 最大值交换，直到最后结束

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
