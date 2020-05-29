package designpatterns.prototype;

/**
 * @author 谭春
 * Date: 2020/3/9
 * Description:原型模式，使用克隆解决重复创建类问题   1、深复制  (即当属性包含对象引用时  不仅仅赋值对象的引用，要赋值出一个新的对象)
 */
public class Resume2 implements Cloneable{
    private String  name;
    private String  sex;
    private String  age;
    private WorkExprience work;

    public Resume2(String name) {
        this.name = name;
        work=new WorkExprience();
    }
    public Resume2(WorkExprience work) {
        try {
            this.work=(WorkExprience)work.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void setPersonalInfo(String sex,String age){
        this.sex=sex;
        this.age=age;
    }

    public void setWorkExperience(String workDate,String company){
        work.workDate=workDate;
        work.company=company;
    }

    public void  dispaly(){
        System.out.println(name+" " + sex + age);
        System.out.println("工作经历："+ work.workDate+ work.company);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Resume2 resume2 = new Resume2(this.work);
        resume2.name=this.name;
        resume2.sex=this.sex;
        resume2.age=this.age;
        return  resume2;
    }

    public static void main(String[] args) {
        Resume2 a = new Resume2("大鸟");
        a.setPersonalInfo("nan","26");
        a.setWorkExperience("1992-1998","汉得");
        a.dispaly();
        try {
            Resume2 b = (Resume2) a.clone();
            b.setWorkExperience("1899-1998","b汉得");
            Resume2 c = (Resume2) a.clone();
            c.setWorkExperience("1899-1998","c汉得");
            b.dispaly();
            c.dispaly();
            a.dispaly();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }


}


