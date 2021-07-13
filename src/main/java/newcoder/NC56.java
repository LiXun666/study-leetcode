package newcoder;

/**
 * @Author lxjj
 * @Date 2021-07-13 10:47
 * @Description
 * 回文数字
 */
public class NC56 {
    //反转字符x
    public boolean isPalindrome (int x) {
        // write code here
        if(x<0) return false;
        int temp = x, y =0;
        while(temp >0){
            y = y*10+temp % 10;
            temp /= 10;
        }
        return x==y;
    }

    //逐位比较
    public boolean isPalindrome2 (int x){
        if(x<0) return  false;
        int hi = 1;
        while (x / hi >=10){
            hi *=10;
        }
        while (x!=0){
            int left = x/hi;
            int right = x%10;
            if (left != right) return false;
            x = (x%hi) /10; //去掉最高和最低位
            hi /= 100;
        }
        return true;
    }
}
