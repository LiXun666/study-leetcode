package datastructure.Algorithm;

/**
 * @Author:lx
 * @Date: 2021/3/1 15:42
 * @Description:
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1 ,3,8,10,11,67,100};
        int index = binarySearchNoRecur(arr,100);
        System.out.println(binarySearchRecur(arr, 3, 0, 6));
        System.out.println(index);
    }

    /**
     *
     * @param arr 待查找数组 非递归实现，并且是个升序数组
     * @param target 目标数
     * @return 返回对应下标，-1没找到
     *
     */
    public static int binarySearchNoRecur(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] > target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecur(int[] arr, int target,int left, int right){
        int mid = (left + right) >> 1;
        if (arr[mid] == target){
            return mid;
        }else if(arr[mid] >target){
            return binarySearchRecur(arr,target,left,mid-1);
        }else {
            return binarySearchRecur(arr,target,mid+1,right);
        }
    }
}
