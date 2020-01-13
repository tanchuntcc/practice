package recursion;

/**
 * @author 谭春
 * Date: 2019/9/9
 * Description:
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        //输出地图
//        System.out.println("地图情况：");
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }

        //使用递归回溯给小球找路
        boolean b = setWay(map, 1, 1);
        System.out.println(b);
        System.out.println("小球能到达终点吗？" +b);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 1.map 表示地图
     * 2.i,j表示从哪个位置开始出发（1，1）
     * 3.如果小球能到map[6][5]位置，则说明通路找到
     * 4.约定：当map[i][j]为 0表示该点没有走过；1表示墙；2表示通路可以走；3表示该点已经走了，但没走通
     * 5.走迷宫的策略：下->右->上->左 ，如果某一点走不通，则回溯
     * @param map 表示地图
     * @param i 从那个位置开始找
     * @param j
     * @return  如果找到通路就返回true
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            //通路已经找到
            return true;
        }else {
            if (map[i][j]==0){
                //如果当前点还未走过  按照策略下->右->上->左走
                map[i][j]=2;
                if (setWay(map,i+1,j)){
                    return  true;
                }else if (setWay(map,i,j+1)){
                    return  true;
                }else if (setWay(map,i-1,j)){
                    return  true;
                }else if (setWay(map,i,j-1)){
                    return  true;
                }else {
                    map[i][j]=3;
                    return false;
                }

            }else {
                return false;
            }
        }
    }
}

