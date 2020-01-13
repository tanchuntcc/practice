package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/10
 * Description:请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 * 思路：1.创建一个string往里添字符
 *       2.统计出空格数量，从而得出新的String长度，从后往前遍历字符串，遇到空格就假如%20
 */
public class ReplaceBlank {
    //1.允许开辟空间
//    public String replaceSpace(StringBuffer str) {
//        StringBuffer rep = new StringBuffer();
//        for (int i=0;i<str.length();i++){
//            if (str.charAt(i)!=' '){
//                rep.append(str.charAt(i));
//            }else {
//                rep.append("%20");
//            }
//        }
//        return rep.toString();
//
//    }
    //2.原地操作
    public String replaceSpace(StringBuffer str) {
        if(str==null) {
            return null;
        }
        int numOfblank = 0;//空格数量
        int len=str.length();
        for(int i=0;i<len;i++){  //计算空格数量
            if(str.charAt(i)==' ') {
                numOfblank++;
            }
        }
        str.setLength(len+2*numOfblank); //设置长度
        int oldIndex=len-1;  //两个指针
        int newIndex=(len+2*numOfblank)-1;

        while(oldIndex>=0 && newIndex>oldIndex){
            char c=str.charAt(oldIndex);
            if(c==' '){
                oldIndex--;
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else{
                str.setCharAt(newIndex,c);
                oldIndex--;
                newIndex--;
            }
        }
        return str.toString();
    }
}

