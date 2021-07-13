package newcoder;

/**
 * @Author lxjj
 * @Date 2021-07-13 14:43
 * @Description
 * 反转数字
 */
public class NC57 {
    public int reverse (int x) {
        // write code here
        int y = 0;
        while(x != 0){
            int temp = x%10;

            if(y>Integer.MAX_VALUE/10 || y == Integer.MAX_VALUE/10 && temp >7
                    || y<Integer.MIN_VALUE/10 || y ==Integer.MIN_VALUE/10 && temp>8)
                return 0;

            y = y*10 + temp;
            x/=10;
        }
        return y;
    }
}
