package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/21
 * Description:输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 思路：1.冒泡排序法，相邻的两个数字组成字符串比大小， 再移位。最后变成一个伪排序数组再遍历加入字符串。
 *       2.先将所有数加入字符串数组中，再重写CompareTo方法排序，然后再遍历加入字符串。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        int v1,v2,temp=0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j=i+1;j<numbers.length;j++){
                v1=Integer.valueOf(String.valueOf(numbers[i])+String.valueOf(numbers[j]));
                v2=Integer.valueOf(String.valueOf(numbers[j])+String.valueOf(numbers[i]));
                if (v1>v2){
                    temp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int number:numbers) {
            stringBuffer.append(number);
        }

        return stringBuffer.toString();
    }
//思路2
//    public String PrintMinNumber(int [] numbers) {
//        if(numbers == null || numbers.length == 0) return "";
//        int len = numbers.length;
//        String[] str = new String[len];
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < len; i++){
//            str[i] = String.valueOf(numbers[i]);
//        }
//        Arrays.sort(str,new Comparator<String>(){
//            @Override
//            public int compare(String s1, String s2) {
//                String c1 = s1 + s2;
//                String c2 = s2 + s1;
//                return c1.compareTo(c2);
//            }
//        });
//        for(int i = 0; i < len; i++){
//            sb.append(str[i]);
//        }
//        return sb.toString();
//    }
}

