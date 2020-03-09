package designpatterns.strategy;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:正常收费子类
 */
public class StrategyA extends Strategy {

    @Override
    public double acceptCash(double money) {
        return money;
    }
}

