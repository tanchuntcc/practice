package designpatterns.decorator;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:
 */
public class Finery extends Person {
    protected  Person component;

    public void Decorate(Person component) {
        this.component = component;
    }
}

