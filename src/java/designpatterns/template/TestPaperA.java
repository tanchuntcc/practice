package designpatterns.template;

/**
 * @author 谭春
 * Date: 2020/3/9
 * Description:学生A
 */
public class TestPaperA extends TestPaper {
    @Override
    String answer1() {
        return "a";
    }

    @Override
    String answer2() {
        return "b";
    }
}

