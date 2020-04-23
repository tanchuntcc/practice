package test;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author 谭春
 * Date: 2020/4/10
 * Description:
 */
public class Gz {
    public void geta(EventOrder eventOrder) {
        setFieldValue(eventOrder,"aaa",999);
        List<Item> itemList = eventOrder.getItemList();
        for (Item item : itemList) {
            item.setAge(999);
        }
    }

    public static void main(String[] args) {
        EventOrder eventOrder = new EventOrder();
        eventOrder.setAaa(1);
        eventOrder.setBbb(2);
        Item item1 = new Item("修改前", 1);
        List<Item> list=new ArrayList<Item>();
        list.add(item1);
        eventOrder.setItemList(list);
        Gz gz = new Gz();
        gz.geta(eventOrder);
        System.out.println(eventOrder);
    }
    public static final<T> void setFieldValue(T target,String fieldName,Object fieldValue){
        if ( fieldName.equals("") || fieldValue == null || target == null)
            return;
        Field field;
        try{
            field = target.getClass().getDeclaredField( fieldName );
            field.setAccessible( true );
            //获得fieldName属性的修饰类型对象
            Class< ? > type = field.getType();
            //如果fiedlName的类型名等于fieldValue的类型名
            if ( type.getName().equals( fieldValue.getClass().getName() ) ){
                //设置fieldName的值为fieldValue
                field.set( target,fieldValue );
                return;
            }
            //如果fiedlName的类型名等于以下的，则将fieldValue转化为相应类型
            if ( type.getName().equals( Float.class.getName() ) ){
                field.set( target,Float.valueOf( fieldValue.toString() ) );
            }else if ( type.getName().equals( Double.class.getName() ) ){
                field.set( target,Double.valueOf( fieldValue.toString() ) );
            }else if ( type.getName().equals( Integer.class.getName() ) ){
                field.set( target,Integer.valueOf( fieldValue.toString() ) );
            }else if ( type.getName().equals( Date.class.getName() ) ){
                SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:ss:mm" );
                field.set( target,sdf.parse( fieldValue.toString() ) );
            }else if ( type.getName().equals( String.class.getName() ) ){
                field.set( target,fieldValue.toString() );
            }else {
                field.set( target,fieldValue );
            }
        } catch ( Exception e ){
            e.printStackTrace();
        }
    }


}

