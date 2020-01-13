package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/12
 * Description:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路：先摆放第一块，如果竖着放 后面又f(target-1)种摆法，当横着放时，下面的空间也被迫横着放，后面有f(target-2)种摆法
 */
public class CoverRectangular {
    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }else if (target <= 2) {
            return target;
        } else {
            return RectCover((target - 1)) + RectCover(target - 2);
        }
    }
}


