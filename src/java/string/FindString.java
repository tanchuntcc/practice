package string;

/**
 * Created by TanChun on 2019/1/21.
 * 统计一个字符串在另一个字符串中出现的次数
 */
public class FindString {
    public static void main(String[] args) {
        String str = "avava";
        String sToFind = "ava";
        int num = new FindString().countStr(str,sToFind);
        System.out.println("共找到" + num + "个" + sToFind);
    }

    /**
     * @param str 原字符串
     * @param sToFind 需要查找的字符串
     * @return 返回在原字符串中sToFind出现的次数
     */
    private int countStr(String str,String sToFind) {
        int num = 0;
        while (str.contains(sToFind)) {
            str = str.substring(str.indexOf(sToFind) + 1);
            num ++;
        }
        return num;
    }
}