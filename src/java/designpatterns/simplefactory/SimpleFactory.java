package designpatterns.simplefactory;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:简单工厂模式实现一个简易的加减乘除计算
 */
public class SimpleFactory {
    public  static Operation getResult(String operate){
        Operation operation=null;
        switch (operate){
            case "+":
                operation=new OperationAdd();
                break;
            case "-":
                operation=new OperationSub();
                break;
            case "*":
                operation=new OperationMul();
                break;
            case "/":
                operation=new OperationDiv();
                break;
                default:
                    System.out.println("符号输入错误");
        }
        return operation;
    }

    public static void main(String[] args) {
        Operation result = SimpleFactory.getResult("-");
        result.numbebB=1;
        result.numberA=4;
        try {
            System.out.println(result.GetResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

