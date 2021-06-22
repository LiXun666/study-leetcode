

import java.util.ArrayList;

/**
 * @Description TODO
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @Date 2020/9/29 11:18
 * @Created by lx
 */
public class ZJ13 {


    /**
     * 思路:
     * 用i进行遍历；每次移动一个位置就判断是否前一个与后一个数的奇数偶数关系，如果不符合就进行互换，每次这样比较可以保证相对位置
     * @param array
     */
    public void reOrderArray(int [] array) {

        int temp;

        for (int i=1; i<=array.length-1;i++){
            for (int j=i-1; j>=0&&array[j+1]%2>array[j]%2; j--){
                temp=array[j+1];
                array[j+1] = array[j];
                array[j] = temp;
            }
        }
    }


    /**
     *用两个list分别存入奇数和偶数，再将奇数和偶数按顺序放入数组即可。
     * @param array
     */
    public void reOrderArray2(int [] array){
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        for (int i = 0; i<array.length;i++){
            if (array[i]%2==1){
                l1.add(array[i]);
            }else{
                l2.add(array[i]);
            }
        }


        for (int i=0; i<l1.size();i++){
            array[i] = l1.get(i);
        }
        for (int i=0; i<l2.size();i++){
            array[l1.size()+i] = l2.get(i);
        }

        System.out.println(array);

    }

}
