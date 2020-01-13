package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/23
 * Description:小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他不满并足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一
 * 组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数
 * 序列? Good Luck!
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
import java.util.ArrayList;
public class FindCoutinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int left=1,right=2;
        while (left<right){
                if (((left+right)*(right-left+1))/2==sum){
                    ArrayList<Integer> integers = new ArrayList<>();
                    for (int i = left; i <=right ; i++) {
                        integers.add(i);
                    }
                    arrayLists.add(integers);
                    right++;
                }else if(((left+right)*(right-left+1))/2>sum){
                    left++;
                } else {
                    right++;
                }
        }
        return arrayLists;
    }

    public static void main(String[] args) {
        final FindCoutinuousSequence findCoutinuousSequence = new FindCoutinuousSequence();
        final ArrayList<ArrayList<Integer>> arrayLists = findCoutinuousSequence.FindContinuousSequence(3);
        System.out.println(arrayLists);

    }
}

