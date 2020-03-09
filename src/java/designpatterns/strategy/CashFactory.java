package designpatterns.strategy;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:工厂模式版处理打折促销业务，当switch增加分支时，又得改写代码。
 */
public class CashFactory {
    public static Strategy createStrategy(String type){
        Strategy cs=null;
        switch (type){
            case "正常收费":
                cs=new StrategyA();
                break;
            case "满300返100":
                cs=new StrategyC(300,100);
                break;
            case "打8折":
                cs=new StrategyB(0.8);
                break;
                default:
                    System.out.println("输入的类型有误");
        }
        return cs;
    }

    public static void main(String[] args) {
        //工厂模式版处理打折促销业务，当switch增加分支时，又得改写代码。
        Strategy eight = CashFactory.createStrategy("打8折");
        double totalPrices=0d;
        totalPrices=eight.acceptCash(900)*1;
        double total=0;
        total=total+totalPrices;
        System.out.println(totalPrices);

        //使用策略模式可以降低耦合   因为使用简单工厂   客户端要认识CashFactory和Strategy两个类
        //                           使用策略模式只需认识CashContext类
        CashContext eight1 = new CashContext("打8折");
        double totalPrices2=0d;
        totalPrices2 = eight1.getResult(900) * 1;
        double total2=0;
        total2=total2+totalPrices;
        System.out.println(totalPrices2);
    }
}

