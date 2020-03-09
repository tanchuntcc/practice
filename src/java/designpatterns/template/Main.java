package designpatterns.template;

/**
 * @author 谭春
 * Date: 2020/3/9
 * Description:当我们要完成在某一细节层次一致的一个过程或系列步骤，但个别步骤在更加详细的层次上
 * 实现可能不同时，我们通常考虑用模板方法模式来处理
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("学生A的试卷");
        TestPaperA testPaperA = new TestPaperA();
        testPaperA.testQ1();
        testPaperA.testQ2();
        System.out.println("学生B的试卷");
        TestPaperB testPaperB = new TestPaperB();
        testPaperB.testQ1();
        testPaperB.testQ2();
    }
}

