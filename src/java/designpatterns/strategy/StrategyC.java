package designpatterns.strategy;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:返利收费子类
 */
public class StrategyC extends Strategy {

    private double moneyCondition = 0.0d;
    private double moneyReturn=0.0d;

    public StrategyC(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        if (money>moneyCondition){
            return money-Math.floor(money/moneyCondition)*moneyReturn;
        }
        return money;
    }
}

