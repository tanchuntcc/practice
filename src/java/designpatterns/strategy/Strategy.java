package designpatterns.strategy;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:现金收费抽象类
 */
abstract class Strategy {
    public abstract double acceptCash(double money);
}

