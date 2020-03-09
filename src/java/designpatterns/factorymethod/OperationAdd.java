package designpatterns.factorymethod;



public class OperationAdd extends Operation {

    @Override
    double GetResult() {
        return getNumberA()+getNumbebB();
    }
}