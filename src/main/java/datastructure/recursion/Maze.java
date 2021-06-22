package datastructure.recursion;

/**
 * @Author:lx
 * //一个8*7的迷宫，墙设置为1，从指定位置走到右下角
 * @Date: 2020/12/15 9:01
 * @Description:
 */
public class Maze {
    public static void main(String[] args) {
        int[][] m = new int[8][7];

        //另其周围全是1
        for (int i = 0; i < m[1].length; i++) {
            m[0][i] = 1;
            m[7][i] = 1;
        }
        for (int i = 0; i < m.length; i++) {
            m[i][0] = 1;
            m[i][6] = 1;
        }
        m[3][1] = 1;
        m[3][2] = 1;
        setWay(m,1,1);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[1].length; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean setWay(int[][] map, int i, int j){
         if (map[6][5] == 2){
             return true;
         }else{
             if (map[i][j] == 0){
                 map[i][j] = 2;
                 if (setWay(map,i+1,j)){
                     return true;
                 }else if (setWay(map,i,j+1)){
                     return true;
                 } else if (setWay(map, i-1, j)) {
                     return true;
                 }else if (setWay(map,i,j-1)){
                     return true;
                 }else{
                     //下右上左都走不通,返回3
                     map[i][j] = 3;
                     return false;
                 }
             }else{
                 //即map[i][j]非0
                 throw new RuntimeException("初始点不为0");
             }
         }
    }
}
