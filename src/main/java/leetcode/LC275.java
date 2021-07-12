package leetcode;

/**
 * @Author lxjj
 * @Date 2021-07-12 10:22
 * @Description H 指数 II
 */
public class LC275 {
    //citations 已经排好序了
    public int hIndex(int[] citations) {
        int n = citations.length;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count++;
            if (citations[i] <= count) {
                if (citations[i] < count) count--;
                break;
            }
        }
        return count;
    }

    //二分查找
    public int hIndex2(int[] citations){
        int n = citations.length;
        int left = 0, right = n-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
