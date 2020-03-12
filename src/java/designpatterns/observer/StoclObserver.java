package designpatterns.observer;

/**
 * @author 谭春
 * Date: 2020/3/11
 * Description:
 */
public class StoclObserver extends Observer {
    public StoclObserver(String name, Secretary sub) {
        super(name, sub);
    }

    @Override
    public void update() {
        System.out.println(sub.getAction()+name+"关闭股票行情，继续工作");
    }
}

