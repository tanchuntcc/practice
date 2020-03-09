package designpatterns.decorator;

/**
 * @author 谭春
 * Date: 2020/3/8
 * Description:
 */
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void Show(){
        System.out.println("装扮的"+name);
    }
}

