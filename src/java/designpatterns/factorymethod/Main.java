package designpatterns.factorymethod;


/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        IFactory iFactory = new AddFactory();
        Operation operation = iFactory.createOperation();
        operation.setNumbebB(1);
        operation.setNumbebB(2);
        double v=0;
        try {
             v = operation.GetResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(v);
    }
}

