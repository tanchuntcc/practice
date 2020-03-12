package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 谭春
 * Date: 2020/3/11
 * Description:
 */
public class Secretary {
    private List<Observer> observers=new ArrayList<Observer>();
    private String action;

    public void Attach(Observer observer){
        observers.add(observer);
    }
    public void Detach(Observer observer){
        observers.add(observer);
    }
    public void Notify(){
        for (Observer o : observers) {
            o.update();
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public static void main(String[] args) {
        Secretary qiantai  = new Secretary();
        StoclObserver stoclObserver1 = new StoclObserver("小王", qiantai);
        StoclObserver stoclObserver2 = new StoclObserver("小李", qiantai);
        NBAObserver nbaObserver = new NBAObserver("小张", qiantai);

        qiantai.Attach(stoclObserver1);
        qiantai.Attach(stoclObserver2);
        qiantai.Attach(nbaObserver);
        qiantai.setAction("老板回来了");
        qiantai.Notify();


    }

}

