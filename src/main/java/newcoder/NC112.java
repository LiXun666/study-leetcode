package newcoder;

/**
 * @Author lxjj
 * @Date 2021-07-15 0:33
 * @Description
 */
public class NC112 {
    public static void main(String[] args) {
        System.out.println(solve(7, 2));
    }
    public static String solve (int M, int N) {
        // write code here
        boolean f = false;
        if (M < 0) {
            f= true;
            M = -M;
        }
        StringBuilder sb = new StringBuilder();
        while(M != 0){
            int i = M % N;
            if (i>=10){
                sb.append((char)('A' + i - 10));
            }else{
                sb.append(String.valueOf(i));
            }

            M /= N;
        }
        if (f){
            return "-"+sb.reverse().toString();
        }else{
            return sb.reverse().toString();
        }
    }
}
