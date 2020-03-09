package designpatterns.strategy;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:
 */
public class StrategyB extends Strategy {
    private double moneyRebate=1d;

    public StrategyB(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double money) {
        return money*moneyRebate;
    }
}

