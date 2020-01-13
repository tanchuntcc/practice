package java8;

/**
 * @author 谭春
 * Date: 2019/12/18
 * Description:
 */
public class Apple {
    private String color;
    private long weight;

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Apple(String color, long weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }
}

