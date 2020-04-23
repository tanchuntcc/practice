package string;

import java.util.Arrays;
import java.util.Comparator;

public class MinDistance {
    static Points point = new Points();

    public static void main(String[] args) {
        node[] a = new node[30];
        createPoint(a);
        node[] b = a.clone();
        //比x轴
        Arrays.sort(a, new cmp1());
        //比y轴
        Arrays.sort(b, new cmp2());
        double dis = minDis(0, 29, a, b); //此处异常
        System.out.println("最近点对：");
        System.out.println("( " + point.x1 + " , " + point.y1 + " )," + "( " + point.x2 + " , " + point.y2 + " )");
        System.out.println(dis);
    }

    public static void createPoint(node[] a) {
        for (int i = 0; i < 30; i++) {
            a[i] = new node();
            a[i].x = 10 * Math.random();
            a[i].y = 10 * Math.random();
            for (int j = 0; j < i; j++) {
                if (a[j].x == a[i].x && a[j].y == a[i].y) {
                    i--;
                    break;
                }
            }
        }
    }

    public static double distance(int i, int j, node[] a) {

        double m = Math.pow(a[i].x - a[j].x, 2);    //此处异常
        double n = Math.pow(a[i].y - a[j].y, 2);
        return Math.sqrt(m + n);
    }

    public static double minDis(int low, int high, node[] a, node[] b) {
        if (high - low == 0)
            return Double.MAX_VALUE;
        else if (high - low == 1) {
            point.x1 = a[low].x;
            point.x2 = a[high].x;
            point.y1 = a[low].y;
            point.y2 = a[high].y;
            return distance(low, high, a);
        } else {
            int m = (low + high) / 2;
            double min1 = minDis(low, m, a, b);   //此处异常
            double min2 = minDis(m + 1, high, a, b);
            double mint = min1 < min2 ? min1 : min2;
            if (min1 < min2) {
                point.x1 = a[low].x;
                point.x2 = a[m].x;
                point.y1 = a[low].y;
                point.y2 = a[m].y;
            } else {
                point.x1 = a[m + 1].x;
                point.x2 = a[high].x;
                point.y1 = a[m + 1].y;
                point.y2 = a[high].y;
            }

            double x = a[m].x;

            int k = 0;
            node[] K = new node[30];
            for (int i = 0; i < 30; i++) {
                if ((Math.abs(b[i].x - x)) <= mint) {
                    K[k] = new node();
                    K[k].x = b[i].x;
                    K[k].y = b[i].y;
                    k++;
                }
            }
            for (int i = 0; i < (k - 1); i++) {
                int temp = (i + 7) < k ? (i + 7) : k;
                for (int j = i + 1; j <= temp; j++) {
                    if (distance(i, j, K) < mint) {   //此处异常
                        mint = distance(i, j, K);
                        point.x1 = K[i].x;
                        point.x2 = K[j].x;
                        point.y1 = K[i].y;
                        point.y2 = K[j].y;
                    }
                }
            }
            return mint;
        }
    }
}

class Points {
    public double x1;
    public double y1;
    public double x2;
    public double y2;
}

class node {
    public double x;
    public double y;
}

class cmp1 implements Comparator<node> {
    public int compare(node a, node b) {
        if (a.x < b.x)
            return -1;
        else if (a.x > b.x)
            return 1;
        else return 0;
    }
}


class cmp2 implements Comparator<node> {
    public int compare(node a, node b) {
        if (a.y < b.y)
            return -1;
        else if (a.y > b.y)
            return 1;
        else return 0;
    }
}