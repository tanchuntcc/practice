package designpatterns.proxy;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:被代理类需要接触到的类
 */
public class SchoolGirl {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SchoolGirl(String name) {

        this.name = name;
    }
}

