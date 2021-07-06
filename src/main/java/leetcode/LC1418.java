package leetcode;

import java.sql.Array;
import java.util.*;

/**
 * @Author lxjj
 * @Date 2021-07-06 21:41
 * @Description
 * 点菜展示表
 */
public class LC1418 {
    public static void main(String[] args) {
        String[] s1 = new String[]{"David","3","Ceviche"};
        String[] s2 = new String[]{"Corina","10","Beef Burrito"};
        String[] s3 = new String[]{"David", "3", "Fried Chicken"};
        String[] s4 = new String[]{"Carla", "5", "Water"};
        String[] s5 = new String[]{"Rous", "3", "Ceviche"};
        List<String> list1 = new ArrayList<>(Arrays.asList(s1));
        List<String> list2 = new ArrayList<>(Arrays.asList(s2));
        List<String> list3 = new ArrayList<>(Arrays.asList(s3));
        List<String> list4 = new ArrayList<>(Arrays.asList(s4));
        List<String> list5 = new ArrayList<>(Arrays.asList(s5));

        List<List<String>> orders = new ArrayList<>();
        orders.add(list1);
        orders.add(list2);
        orders.add(list3);
        orders.add(list4);
        orders.add(list5);
        displayTable(orders);
    }
    public static List<List<String>> displayTable(List<List<String>> orders) {
        //把所有的order放入map
        Map<Integer, Map<String,Integer>> map = new HashMap<>();

        List<String> foodList = new ArrayList<>();
        for (List<String> order : orders) {
            int tableNum = Integer.parseInt(order.get(1));
            Map<String, Integer> foodMap = map.getOrDefault(tableNum, new HashMap<>());
            String foodName = order.get(2);
            foodMap.put(foodName,foodMap.getOrDefault(foodName,0)+1);
            map.put(tableNum,foodMap);
            if (!foodList.contains(foodName)){
                foodList.add(foodName);
            }
        }
        List<List<String>> res = new ArrayList<>();
        //列表1：表头table+foodName
        foodList.sort(String::compareTo);
        foodList.add(0,"Table");

        res.add(foodList);

        //给桌号排序
        int m = map.size();
        List<Integer> ids = new ArrayList<>(map.keySet());
        Collections.sort(ids);

        for (int id : ids) {
            List<String> tableList = new ArrayList<>();
            Map<String, Integer> fn = map.get(id);
            for (String s : foodList){
                if (s.equals("Table")){
                    tableList.add(String.valueOf(id));
                }else{
                    tableList.add(String.valueOf(fn.getOrDefault(s,0)));
                }
            }
            res.add(tableList);
        }
        return res;
    }
}
