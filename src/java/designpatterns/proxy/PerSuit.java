package designpatterns.proxy;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:被代理的类
 */
public class PerSuit  implements GiveGift {
    SchoolGirl mm;

    public PerSuit(SchoolGirl mm) {
        this.mm = mm;
    }

    @Override
    public void giveDolls() {
        System.out.println(mm.getName()+",送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(mm.getName()+",送你鲜花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(mm.getName()+",送你巧克力");
    }
}

