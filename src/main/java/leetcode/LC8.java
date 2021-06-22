package leetcode;

import javax.annotation.Resource;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * @Author:lx
 * @Date: 2021/3/15 11:36
 * @Description:
 * 字符串转换整数 (atoi)
 *
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 *
 * 步骤：
 * 1.处理空格，遇见空格指针跳过
 * 2.处理符号，遇见负号记录，遇见正号不管，index都++
 * 3.从当前index开始遍历，遇见字母 直接跳出
 * 4.返回该数字
 */
public class LC8 {
    //时间O(N),空间(1)
    public int myAtoi(String s) {
        int len = s.length();
        int index = 0;
        while (index<len && s.charAt(index) == ' '){
            index++;
        }
        if (index == len){
            return 0;
        }
        int sign = 1;
        if (s.charAt(index) == '+'){
            index++;
        }else if (s.charAt(index) == '-'){
            index++;
            sign= -1;
        }
        int res = 0;
        while (index <len){
            char c = s.charAt(index);
            if (c > '9' || c < '0'){
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && ( c- '0') > Integer.MAX_VALUE % 10)){
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && -(c - '0') < Integer.MIN_VALUE %10)){
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (c - '0');
            index++;
        }
        return res;
    }
}
