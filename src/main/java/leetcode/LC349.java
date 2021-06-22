package leetcode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @Author:lx
 * 两个数组的交集:
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @Date: 2020/11/2 14:34
 * @Description:
 */
public class LC349 {
    //+排序+双指针
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ints = new int[nums1.length + nums2.length];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1<nums1.length && index2<nums2.length){
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1 == num2){
                if (index == 0 || num1 != ints[index-1] ){
                    ints[index++] = num1;
                }
                index1++;
                index2++;
            }else if (num1<num2){
                index1++;
            }else {
                index2++;
            }
        }
        return Arrays.copyOfRange(ints,0,index);
    }

    //java集合的使用hashset
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(),set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums1){
            list.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        list.retainAll(set2); //取交集
        set1.addAll(list); //全部加入
        return set1.stream().mapToInt(i->i).toArray();
    }

}
