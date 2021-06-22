package datastructure.stack;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;

/**
 * @Author:lx
 * 1，先把一个表达式分割成一个arraylist存放每个元素，包括数字和符号
 * 2，计算，初始化一个栈，遍历这个arraylist，如果是数字(使用item.matches("\\d+")：是否为多位数)push进栈，每次遇见符号就计算，把计算结果放到栈中，最后剩一个结果输出
 * @Date: 2020/11/9 15:19
 * @Description:
 */
public class PolandNotation {
    public static void main(String[] args) {

        //定义一个逆波兰表达式
        //(3+4)*5-6
//        String suffixExperssion = "3 4 + 5 * 6 -";
//        List<String> list = getListString(suffixExperssion);
//        int res = calculation(list);
//        System.out.printf("表达式(%s)的结果是%d,", suffixExperssion, res);
        String experssion = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(experssion); //list =  [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        System.out.println(infixExpressionList);
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println(suffixExpressionList);
        int calculation = calculation(suffixExpressionList);
        System.out.println(calculation);
    }

    //将中缀表达式转换成后缀表达式
    //[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] ==》[1,2,3+,4,*,5,-]
    public static List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();
        for (String item : ls) {
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                while (s1.size() !=0 && Operation.getValue(item) <= Operation.getValue(s1.peek())){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }



    //变成list,分割的方式
    public static List<String> getListString(String s) {
        List<String> list = new ArrayList<>();
        String[] splitS = s.split(" ");
        for (String split : splitS) {
            list.add(split);
        }
        return list;
    }

    //将一个表达式转换成对应的list
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        while (i<s.length()){
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                ls.add(""+c);
                i++;
            }else{
                str ="";
                while (i<s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }
        return ls;
    }


    //计算
    public static int calculation(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")){
                stack.push(item);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 +num2;
                }else if (item.equals("-")){
                    res = num1 - num2;
                }else if (item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res+"");
            }

        }
        return Integer.parseInt(stack.pop());
    }
}

class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int res = 0;
        switch (operation){
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("输入的符号有误");
                break;
        }
        return res;
    }
}
