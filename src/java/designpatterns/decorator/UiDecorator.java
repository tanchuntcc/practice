package designpatterns.decorator;

/**
 * @author 谭春
 * Date: 2020/3/18
 * Description:
 */
public class UiDecorator extends Decorator{

    public UiDecorator(SpanNode textNode) {
        super(textNode);
    }

    @Override
    public String getTest() {
        return "<i>"+textNode.getTest()+"<i>";
    }
}

