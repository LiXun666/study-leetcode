package leetcode;

import java.util.HashMap;

/**
 * @Author:lx
 * @Date: 2021/3/19 18:31
 * @Description:
 * 设计停车系统
 * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 */
public class ParkingSystem {
    HashMap<Integer,Integer> map;
    public ParkingSystem(int big, int medium, int small) {
        map = new HashMap<Integer,Integer>();
        map.put(1,big);
        map.put(2,medium);
        map.put(3,small);
    }

    public boolean addCar(int carType) {
        if (map.get(carType) > 0){
            map.put(carType,map.get(carType)-1);
            return true;
        }
        return false;
    }
}