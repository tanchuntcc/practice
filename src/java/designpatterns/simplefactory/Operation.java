package designpatterns.simplefactory;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description: 运算抽象类
 */
public abstract class Operation {
    protected double numberA=0;
    protected double numbebB=0;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumbebB() {
        return numbebB;
    }

    public void setNumbebB(double numbebB) {
        this.numbebB = numbebB;
    }
    //父类抽象的计算方法噶
     abstract double GetResult() throws Exception;
}

