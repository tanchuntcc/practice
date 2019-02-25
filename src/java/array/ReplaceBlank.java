package array;

/**
 * Created by TanChun on 2019/2/18.
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 */
public class ReplaceBlank {
    public String replaceSpace(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        int len = str.length() - 1;
        for(int i = len; i >= 0; i--){
            if(str.charAt(i) == ' ')
                res.append("02%");
            else
                res.append(str.charAt(i));
        }
        return res.reverse().toString();
    }
}
