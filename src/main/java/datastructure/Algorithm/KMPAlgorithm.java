package datastructure.Algorithm;

/**
 * @Author:lx
 * @Date: 2021/3/18 10:41
 * @Description:
 * KMP算法，解决一个字符串是否是另一个字符串的子串，如果是返回其实坐标，如果没有返回-1
 */
public class KMPAlgorithm {


    public static void main(String[] args) {

        String s = "BBC ABCDAB ABCDABCDABDE";
        String des = "ABCDABD";
        int i = kmpSearch(s, des);
        System.out.println(i);
    }

    public static int kmpSearch(String s, String des){
        int[] next = kmpNext(des);

        for (int i = 0, j = 0; i < s.length(); i++){
            if (j > 0 && s.charAt(i) != des.charAt(j)){
                j = next[j-1];
            }

            if (s.charAt(i) == des.charAt(j)){
                j++;
            }

            if (j == des.length()){
                return i-j+1;
            }

        }
        return -1;
    }
    //找到des串的next数组
    private static int[] kmpNext(String des){
        int[] next = new int[des.length()];
        for (int i = 1, j = 0; i < des.length(); i++){

            while (j > 0 && des.charAt(i) != des.charAt(j)){
                j = next[j-1];
            }

            if (des.charAt(i) == des.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;

    }
}
