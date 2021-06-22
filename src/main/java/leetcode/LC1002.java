package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 * @Date 2020/10/14 12:43
 * @Created by lx
 */


public class LC1002 {


    /**
     * 思路：
     * 1，先把第一个字符串的情况遍历出来，放到一个26长度的数组中，对应a-z，如果那个出现则在对应的位置计数，如b出现一次charCount[1]++
     * 2，再遍历后面的每个字符串，按照同样的发放统计每个字母出现的次数
     * 3，吧1和2的两个数组进行比较，因为同样的角标代表的是同样的字母，若两个字符串在该位置的值都不是0，则总共出现了最小值此
     * 4，新建一个列表result，把数组中重复出现的字母加进去，方法：result.add(String.valueOf((char)(i + 'a')))
     *
     */
    public List<String> commonChars(String[] A) {

        //先得到第一个字符串内字符的情况
        int[] charCount = new int[26];
        for (int i = 0; i < A[0].length(); i++){
            charCount[A[0].charAt(i)-'a']++; //表明的是滴几个字符的数量
        }

        //从第1个开始逐个进行比较
        int[] curCount = new int[26];
        for (int i = 1; i< A.length; i++){
            //遍历第i个字符串
            for (int j=0;j<A[i].length();j++){
                curCount[A[i].charAt(j)-'a']++;
            }

            //将此时关于第i个字符串的情况与charCount对比，取小的即可
            for(int k = 0; k < 26; k++){
                charCount[k] = Math.min(charCount[k], curCount[k]);
            }
        }


        //此时的charCount即为所有的字符串出现的共有的最小元素的个数
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            while(charCount[i] != 0){
                result.add(String.valueOf((char)(i + 'a')));
                charCount[i]--;
            }
        }

        return result;


    }


}
