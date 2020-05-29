package string;

class StringReverse {
      public static void main(String[] args) {
          String str="hello";
          System.out.println(reverse(str));

      }
      public static String reverse(String str){
          int len=str.length();
          if(len==1)
             return str;
         //subString(1)表示把字符串中索引1之后的字串拿出来；charAt(0)表示取字符串的第一个字符
         return reverse(str.substring(1))+str.charAt(0);
     }
 }