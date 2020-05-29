package test;

/**
 * @author 谭春
 * Date: 2020/5/19
 * Description:
 */
public class Af {
    private  static Af af=new Af();

    public Af() {
    }

    public Af getInstance(){
        return af;
    }
}
class Add{
    private static Af af;

    public Add() {
    }
    public Af getInstance(){
        if (af == null) {
            return  af=new Af();
        }else {
            return af;
        }

    }
}
class Ar{
    private static volatile Ar ar;

    public Ar() {
    }
    public synchronized Ar getInstance  (){
        if (ar==null){
            synchronized (ar){
                if (ar==null){
                    ar = new Ar();
                    return ar;
                }
            }
        }
        return ar;
    }
}

