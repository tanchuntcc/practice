package designpatterns.factorymethod;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:除法子类
 */
public class OperationDiv extends Operation{

    @Override
    double GetResult() throws Exception {
        if (getNumbebB()==0){
            throw new Exception("除数不能为0");
        }
        return getNumberA()/getNumbebB();
    }
}

