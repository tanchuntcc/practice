package designpatterns.observer;

/**
 * @author 谭春
 * Date: 2020/3/11
 * Description:
 */
abstract class Observer {
    protected String name;
    protected Secretary sub;

    public Observer(String name, Secretary sub) {
        this.name = name;
        this.sub = sub;
    }

    public abstract void update();
}

