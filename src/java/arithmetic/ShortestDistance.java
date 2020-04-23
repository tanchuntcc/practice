package arithmetic;

import java.util.Arrays;

/**
 * @author Tcc
 */
public class ShortestDistance {

    private double[][] points;

    Point p1, p2;

    public ShortestDistance(double[][] points) {
        this.points = points;
    }

    public double getMinimumDistance() {
        Point[] orderByx = new Point[points.length];
        for (int i = 0; i < orderByx.length; i++){
            orderByx[i] = new Point(points[i][0], points[i][1]);
        }
        //按照x坐标排序
        Arrays.sort(orderByx);
        // 重复点距离为0，不符合题意
        if (checkIdentical(orderByx)) {
            return 0;
        }
        Point[] orderByy = orderByx.clone();
        //按照y坐标排序
        Arrays.sort(orderByy, new CompareY());
        return distance(orderByx, 0,orderByx.length - 1, orderByy);
    }

    /**
     * 检查重复点
     */
    public boolean checkIdentical(Point[] orderByx) {
        for (int i = 0; i < orderByx.length - 1; i++) {
            if (orderByx[i].compareTo(orderByx[i + 1]) == 0) {
                p1 = orderByx[i];
                p2 = orderByx[i + 1];
                return true;
            }
        }
        return false;
    }

    /**
     * 返回最近的距离
     */
    public double distance( Point[] orderByx, int low, int high,Point[] orderByy) {

        //两个点以下的情况
        if (low >= high){
            return Double.MAX_VALUE;
        } else if (low + 1 == high) {
            p1 = orderByx[low];
            p2 = orderByx[high];
            return distance(orderByx[low], orderByx[high]);
        }

        //把X分为两组，左边和右边
        int mid = (low + high) / 2;
        Point[] orderByyLeft = new Point[mid - low + 1];
        Point[] orderByyRight = new Point[high - mid];
        int j1 = 0;
        int j2 = 0;
        for (int i = 0; i < orderByy.length; i++) {
            if (orderByy[i].compareTo(orderByx[mid]) <= 0){
                orderByyLeft[j1++] = orderByy[i];
            } else{
                orderByyRight[j2++] = orderByy[i];
            }
        }
        //递归找到左边和右边的最近距离值
        double dLeft = distance(orderByx, low, mid, orderByyLeft);
        double dRight = distance(orderByx, mid + 1, high, orderByyRight);
        double d = Math.min(dLeft, dRight);

        // 找到左边离中线距离小于最小距离d的点
        int count = 0;
        for (Point orderByyLeftz : orderByyLeft) {
            if (orderByyLeftz.x >= orderByx[mid].x - d){
                count++;
            }
        }
        Point[] leftPoint = new Point[count];
        count = 0;
        for (Point orderByyLeftz : orderByyLeft) {
            if (orderByyLeftz.x >= orderByx[mid].x - d){
                leftPoint[count++] = orderByyLeftz;
            }
        }

        // 找到右边离中线距离小于最小距离d的点
        count = 0;
        for (Point orderByyRightz : orderByyRight) {
            if (orderByyRightz.x <= orderByx[mid].x + d){
                count++;
            }
        }
        Point[] rightPoint = new Point[count];
        count = 0;
        for (Point orderByyRightz : orderByyRight) {
            if (orderByyRightz.x <= orderByx[mid].x + d){
                rightPoint[count++] = orderByyRightz;
            }
        }

        // 找到这些小于d的点中 左边和右边两边距离最小的值
        double dMid = d;
        int j = 0;
        for (Point aLeftPoint : leftPoint) {
            //过滤一些值
            while (j < rightPoint.length && aLeftPoint.y > rightPoint[j].y + d) {
                j++;
            }
            int k = j;
            while (k < rightPoint.length && rightPoint[k].y <= aLeftPoint.y + d) {
                if (dMid > distance(aLeftPoint, rightPoint[k])) {
                    dMid = distance(aLeftPoint, rightPoint[k]);
                    p1 = aLeftPoint;
                    p2 = rightPoint[k];
                }
                k++;
            }
        }
        return Math.min(d, dMid);
    }

    /**
     * 计算p1和p2的坐标
     */
    public static double distance(Point p1, Point p2) {
       return Math.sqrt(Math.pow(p2.x-p1.x,2)+Math.pow((p2.y-p1.y),2));
    }

    /**
     * 定义一个有x和y坐标点的类
     */
    static class Point implements Comparable<Point> {
        double x;
        double y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point p2) {
            if (this.x < p2.x) {
                return -1;
            } else if (this.x == p2.x) {
                return Double.compare(this.y, p2.y);
            } else {
                return 1;
            }
        }

    }

    /**
     * 先比较y坐标，y坐标相同比较x坐标
     */
    static class CompareY implements java.util.Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            if (p1.y < p2.y) {
                return -1;
            } else if (p1.y == p2.y) {
                return Double.compare(p1.x, p2.x);
            } else{
                return 1;
            }
        }
    }

    public static void main(String[] args) {

        //随机生成30个点
        double[][] points = new double[30][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = Math.random() * 10;
            points[i][1] = Math.random() * 10;
        }
        ShortestDistance shortestDistance = new ShortestDistance(points);
        System.out.println("最短距离：" + shortestDistance.getMinimumDistance());
        System.out.print("(" + shortestDistance.p1.x + ", " + shortestDistance.p1.y + ")和"+"(" + shortestDistance.p2.x + ", " + shortestDistance.p2.y + ")");
        System.out.println();
    }
}
