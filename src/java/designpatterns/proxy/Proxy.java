package designpatterns.proxy;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:代理类
 */
public class Proxy implements GiveGift {

    PerSuit gg;

    public Proxy(SchoolGirl mm) {
        gg = new PerSuit(mm);
    }

    @Override
    public void giveDolls() {
        gg.giveDolls();
    }

    @Override
    public void giveFlowers() {
        gg.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        gg.giveChocolate();
    }

    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl("lili");
        Proxy proxy = new Proxy(schoolGirl);
        proxy.giveDolls();
        proxy.giveFlowers();
        proxy.giveChocolate();

    }
}

