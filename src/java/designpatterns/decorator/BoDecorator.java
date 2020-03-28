package designpatterns.decorator;

/**
 * @author 谭春
 * Date: 2020/3/18
 * Description:
 */
public class BoDecorator extends Decorator {
    public BoDecorator(SpanNode textNode) {
        super(textNode);
    }

    @Override
    public String getTest() {
        return "<b>"+textNode.getTest()+"<b>";
    }
}

