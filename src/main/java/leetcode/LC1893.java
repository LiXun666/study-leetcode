package leetcode;

/**
 * @Author lxjj
 * @Date 2021-07-23 22:32
 * @Description
 * 检查是否区域内所有整数都被覆盖
 */
public class LC1893 {
    //暴力
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] iscver  = new boolean[51];
        for(int[] range : ranges){
            for(int i = range[0]; i<= range[1]; i++){
                iscver[i] = true;
            }
        }
        for(int i = left; i<=right; i++){
            if(!iscver[i]) return false;
        }
        return true;
    }

    //差分数组，如果覆盖前缀和大于0，如果没覆盖前缀和小于等于0
    public boolean isCovered2(int[][] ranges, int left, int right){
        int[] diff = new int[52];
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1]+1]--;
        }
        int sum = 0;
        for (int i = 1; i < diff.length; i++) {
            sum += diff[i];
            if (i>=left && i<=right && sum <= 0) return false;
        }
        return true;
    }
}
