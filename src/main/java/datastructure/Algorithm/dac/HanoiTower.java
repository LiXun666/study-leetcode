package datastructure.Algorithm.dac;

/**
 * @Author:lx
 * @Date: 2021/3/1 16:21
 * @Description:
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘子" + a + " -> " + c);
        } else {
            //两个及以上的盘子 看做两个盘子 1上面的所有 2下面的一个
            //上面的所有从a-c
            hanoiTower(num - 1, a, c, b);
            //吧下面的一个盘子从a -c
            System.out.println("第" + num + "个盘子从" + a + " -> " + c);
            //吧第一堆盘子从b-c
            hanoiTower(num - 1, b, a, c);
        }
    }
}
