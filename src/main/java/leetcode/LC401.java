package leetcode;

import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-06-21 17:24
 * @Description
 *  二进制手表
 */
public class LC401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){
                    res.add(i + ":" + (j < 10 ? "0" : "")+j);
                }
            }
        }
        return res;
    }
}
