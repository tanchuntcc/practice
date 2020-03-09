package designpatterns.factorymethod;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:乘法子类
 */
public class OperationMul extends Operation{

    @Override
    double GetResult() {
        return getNumberA()*getNumbebB();
    }
}

