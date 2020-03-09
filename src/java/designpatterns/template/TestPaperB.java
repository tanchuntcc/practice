package designpatterns.template;

/**
 * @author 谭春
 * Date: 2020/3/9
 * Description:学生B
 */
public class TestPaperB extends TestPaper {
    @Override
    String answer1() {
        return "c";
    }

    @Override
    String answer2() {
        return "a";
    }
}

