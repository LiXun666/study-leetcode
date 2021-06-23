package zjoffer;

/**
 * @Description TODO
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @Date 2020/9/21 18:42
 * @Created by lx
 */
public class ZJ6 {
    /**
     * 思路：
     * 二分查找
     *定义数组的最左和最右
     * 中间比左边大 把最左向中间移
     * 中间比右边小 吧最右向中间移
     * 指导l比r小一位时循环结束
     * 输出array[r]
     */

    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0 ){
            return 0;
        }

        int l = 0;
        int r = array.length-1;
        while (l < r-1){
            int mid = (l + r) >> 1;
            if (array[l] <= array[mid]){
                l=mid;
            }
            if (array[mid] <= array[r]){
                r = mid;
            }
        }
        return array[r];
    }

}
