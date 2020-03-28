package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 谭春
 * Date: 2020/3/27
 * Description:
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 *
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 *
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *  
 *思路1.先统计出频次数组，取出频次数组中的数进行辗转相除求得最小公约数，如果有最小公约数，则可以进行卡牌分组。
 */
public class hasGroupSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        //统计频次数组
        int[] ints = new int[10000];
        for (int i : deck) {
            ints[i]++;
        }
        //最小公约数
        int gcdNum = 0;
        for (int anInt : ints) {
            if (anInt > 0) {
                gcdNum = gcd(gcdNum, anInt);
                if (gcdNum == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    //辗转相除法求a和b的公约数
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

