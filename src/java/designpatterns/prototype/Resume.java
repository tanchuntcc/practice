package designpatterns.prototype;

/**
 * @author 谭春
 * Date: 2020/3/9
 * Description:原型模式，使用克隆解决重复创建类问题  1、浅复制
 */
public class Resume implements Cloneable{
    private String  name;
    private String  sex;
    private String  age;
    private String  timeArea;
    private String  company;

    public Resume(String name) {
        this.name = name;
    }

    public void setPersonalInfo(String sex,String age){
        this.sex=sex;
        this.age=age;
    }

    public void setWorkExperience(String timeArea,String company){
        this.timeArea=timeArea;
        this.company=company;
    }

    public void  dispaly(){
        System.out.println(name+" " + sex + age);
        System.out.println("工作经历："+ timeArea+ company);
    }

    public static void main(String[] args) {
        Resume a = new Resume("大鸟");
        a.setPersonalInfo("nan","26");
        a.setWorkExperience("1992-1998","汉得");
        a.dispaly();
        try {
            Resume b = (Resume) a.clone();
            b.setWorkExperience("1899-1998","b汉得");
            Resume c = (Resume) a.clone();
            c.setWorkExperience("1899-1998","c汉得");
            b.dispaly();
            c.dispaly();
            a.dispaly();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }


}

