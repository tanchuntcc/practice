package swordtooffer;

/**
 * @author 谭春
 * Date: 2020/3/15
 * Description:字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 思路：1、使用substring截取两段拼接起来。
 *       2、使用两个for循环。
 *
*/
public class SpinString {
//   // 1、使用substring截取两段拼接起来。
//    public String reverseLeftWords(String s, int n) {
//        return s.substring(n)+s.substring(0,n);
//    }

        //2、使用两个for循环。
        public String reverseLeftWords(String s, int n) {
            String a="";
            for (int i = n; i < s.length(); i++) {
                a+=s.charAt(i);
            }
            for (int i = 0; i < n; i++) {
                a+=s.charAt(i);
            }
            return a;
        }

}

