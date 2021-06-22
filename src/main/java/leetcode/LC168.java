package leetcode;

/**
 * @Author:lx
 * @Date: 2021/4/22 12:51
 * @Description:
 * Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 */
public class LC168 {
    public static void main(String[] args) {

        System.out.println(convertToTitle(701));
    }
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0){
            int i = columnNumber % 26;
            if ( i == 0){
                sb.append('Z');
                columnNumber = columnNumber/26-1;
            }else{
                sb.append((char) ('A' + i-1));
            }
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}
