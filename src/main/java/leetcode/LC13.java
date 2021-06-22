package leetcode;

/**
 * @Author:lx
 * @Date: 2021/3/15 16:34
 * @Description:
 * 罗马数字转整数
 * 思路：
 * 需要看一下后一位，如果前一位比后一位大，直接相加，前一位比后一位小，减掉前一位
 */
public class LC13 {
    //时间O(N) s的长度,空间O(1)
    public int romanToInt(String s) {
        int len = s.length();
        int res = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < len; i++){
            int curNum = getValue(s.charAt(i));
            if (preNum < curNum){
                res -= preNum;
            }else {
                res += preNum;
            }
            preNum = curNum;
        }
        res += preNum;
        return res;
    }

    private int getValue(char c) {
        switch (c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }

    }
}
