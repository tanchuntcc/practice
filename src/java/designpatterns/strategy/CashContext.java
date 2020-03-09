package designpatterns.strategy;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:
 */
public class CashContext {
    private Strategy cs;

    public CashContext(String type) {
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
    }

    public double getResult(double money){
        return cs.acceptCash(money);
    }
}

