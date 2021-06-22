package leetcode;

/**
 * @Author:lx
 * @Date: 2021/3/16 18:00
 * @Description:
 * 整数转罗马数字
 */
public class LC12 {
    int[] values = {1000,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] sym = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< values.length; i++){
            while (values[i] <= num){
                num -= values[i];
                sb.append(sym[i]);
            }
        }
        return sb.toString();
    }
}
