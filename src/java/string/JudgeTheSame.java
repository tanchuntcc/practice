package string;

/**
 * Created by TanChun on 2019/1/21.
 * 判断一个字符串正反相同,忽略空格字符
 */
class JudgeTheSame {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        char[] chars = s.toCharArray();

        while(j>i){
            char tolow = tolow(chars[i]);
            char tolow1 = tolow(chars[j]);
            if(!isAlphaNum(chars[i])){i++;}
            else if(!isAlphaNum(chars[j])){j--;}
            else if(tolow ==tolow1){
                i++;j--;
            }else {
                return  false;
            }
        }
        return true;
    }
    boolean isAlphaNum(char ch) {
        if (ch >= 'a' && ch <= 'z') return true;
        if (ch >= 'A' && ch <= 'Z') return true;
        if (ch >= '0' && ch <= '9') return true;
        return false;
    }
      char tolow(char ch) {
         if (ch >= 'A' && ch <= 'Z') {
             ch += 32;
         }
         return  ch;
     }

    public static void main(String[] args) {
        JudgeTheSame judgeTheSame = new JudgeTheSame();
        boolean aba = judgeTheSame.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(aba);
    }
}