package designpatterns.decorator;

/**
 * @author 谭春
 * Date: 2020/3/11
 * Description:
 */
public class Food {
    private String foodName;

    public Food() {
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public String make(){
        return foodName;
    }

    public static void main(String[] args) {
        //最里面我new了一个香肠，在香肠的外面我包裹了一层奶油，在奶油的外面我又加了一层蔬菜，最外面我放的是面包
        Food food=new Bread(new Vegetable(new Cream(new Food("香肠"))));
        System.out.println(food.make());
    }
}

