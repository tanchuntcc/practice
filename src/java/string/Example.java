package string;

public class Example {
    public int strStr(String haystack, String needle) {
        int l1=haystack.length();
        int l2=needle.length();

        int l=l1-l2;
        if(l2>l1){
            return -1;
        }else if(l2==0 || haystack.equals(needle)){
            return 0;
        }else{
            for(int i=0;i<=l;i++){
                if(haystack.substring(i,i+l2).equals(needle)) {
                    return i;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
