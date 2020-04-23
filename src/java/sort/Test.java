package sort;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws Exception {

        //格式化日期的对象(转化成习惯的时间格式)
        SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        System.out.println("当前系统时间: "+sdFormat.format(calendar.getTime()));

        calendar.add(Calendar.YEAR, 10);
        System.out.println("10年后: "+calendar.getTime());
    }

}
