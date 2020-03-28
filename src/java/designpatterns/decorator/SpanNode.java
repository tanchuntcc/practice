package designpatterns.decorator;

/**
 * @author 谭春
 * Date: 2020/3/18
 * Description:
 */
public class SpanNode {
    private String text;


    public void setText(String text) {
        this.text=text;
    }


    public String getTest() {
        return "<span>" +text+"<span>";
    }
}

