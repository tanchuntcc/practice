package designpatterns.simplefactory;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:加法子类
 */
public class OperationAdd extends Operation{

    @Override
    double GetResult() {
        return getNumberA()+getNumbebB();
    }
}

