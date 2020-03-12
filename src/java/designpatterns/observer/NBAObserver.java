package designpatterns.observer;

/**
 * @author 谭春
 * Date: 2020/3/11
 * Description:
 */
public class NBAObserver extends Observer {
    public NBAObserver(String name, Secretary sub) {
        super(name, sub);
    }

    @Override
    public void update() {
        System.out.println(sub.getAction()+name+"关闭NBA直播，继续工作");
    }
}

