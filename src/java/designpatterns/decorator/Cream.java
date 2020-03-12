package designpatterns.decorator;

/**
 * @author 谭春
 * Date: 2020/3/11
 * Description:
 */
public class Cream extends Food {
    private Food basicFood;

    public Cream(Food basicFood) {
        this.basicFood = basicFood;
    }
    @Override
    public String make(){
        return basicFood.make()+"+奶油";
    }
}

