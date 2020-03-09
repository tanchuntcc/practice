package designpatterns.factorymethod;


/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:
 */
public class DivFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}

