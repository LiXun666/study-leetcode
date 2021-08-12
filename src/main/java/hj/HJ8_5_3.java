package hj;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-08-07 14:44
 * @Description 找出完全相同的子树
 * {1,2,3,1,null,2,null,null,null,null,null,1,null,null,null}
 */
public class HJ8_5_3 {
    static Set<String> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.next();
            //每个节点的左子树2n+1，右子树2n+2
            String[] strs = line.substring(1, line.length() - 1).split(",");
            //最先找到的就是层数最大的
            set = new HashSet<>();
            String res = "";
            for (int i = 0; i < strs.length; i++) {
                String ss = dfs(strs, i);
                if (set.contains(ss)) {
                    res = ss;
                    break;
                } else {
                    set.add(ss);
                }
            }
            if (res.equals("")){
                System.out.println(-1);
            }else{
                System.out.println("["+res+"]");
            }
        }
    }

    private static String dfs(String[] strs, int i) {
        if (i >= strs.length) {
            return "";
        }
        String res = strs[i];
        if (res.equals("null")){
            return res;
        }
        String left = dfs(strs, 2 * i + 1);
        String right = dfs(strs, 2 * i + 2);
        if (left.equals("null") && right.equals("null")) {
            return res;
        }
        if (!left.equals("")) {
            res = res + "," + left;
        }
        if (!right.equals("")) {
            res = res + "," + right;
        }
        return res;
    }
}
