package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 谭春
 * Date: 2020/3/29
 * Description:
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1
 *  代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 *
 *
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *  
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 *
 */
public class MaxDistance {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        //x和y对应移动的步数，同一时间对应的只能移动一步
        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};
        int len = grid.length;
        boolean isExist = false;
        //遍历地图，将陆地的坐标位置放入队列中
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //海洋的坐标数组
        int[] poll = null;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            //分别将当前陆地向左、向右、向上、向下各走依次。
            for (int i = 0; i < 4; i++) {
                int extendToX = x1 + x[i];
                int extendToY = y1 + y[i];
                //如果走出了地图或者遇到不是海洋，就继续下次循环
                if (extendToX < 0 || extendToY < 0 || extendToX >= len || extendToY >= len ||
                        grid[extendToX][extendToY] != 0) {
                    continue;
                }
                isExist = true;
                //将当前的海洋放入队列
                queue.offer(new int[]{extendToX, extendToY});
                //将原地图的海洋改成该点与原始陆地向（左、右、前、后移动）的距离
                grid[extendToX][extendToY] = grid[x1][y1] + 1;
            }
        }
        //如果没有陆地或者没有海洋，返回-1
        if (poll == null || !isExist) {
            return -1;
        }
        //因为原始陆地是1，所以每个海洋的实际距离都要-1。
        return grid[poll[0]][poll[1]] - 1;
    }
}

