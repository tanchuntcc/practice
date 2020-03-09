package designpatterns.template;

/**
 * @author 谭春
 * Date: 2020/3/9
 * Description:答题考卷
 */
abstract class TestPaper {
    public void testQ1(){
        System.out.println("第一题。。。");
        System.out.println("答案"+answer1());
    }
    abstract String answer1();
    public void testQ2(){
        System.out.println("第二题。。。");
        System.out.println("答案"+answer2());
    }
    abstract String answer2();
}

