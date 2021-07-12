package newcoder;

/**
 * @Author lxjj
 * @Date 2021-07-12 21:47
 * @Description
 */
public class NC101 {

    //普通遍历
    public int solve (int[] a) {
        // write code here
        for(int i = 0; i<a.length;i++){
            if(a[i] != i) return i;
        }
        return a.length;
    }
    //二分
    public int solve2 (int[] a) {
        // write code here
        if(a[0] != 0) return 0;
        int left = 0, right = a.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (mid == a[mid]){
                left = mid+1;
            }else{
                if (mid-1 == a[mid-1]) return mid;
                right = mid-1;
            }
        }
        return a.length;
    }
    //求和
    public int solve3 (int[] a){
        int leng = a.length;
        int sum = leng*(leng+1)/2;
        int s = 0;
        for (int j : a) {
            s += j;
        }
        return sum - s;
    }
}
