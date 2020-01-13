package java8;

public class Student {
 
    private String name;
    private int score;
 
    public Student(){
 
    }
 
    public Student(String name, int score) {
        super();
        this.name = name;
        this.score = score;
    }
 
    //setter和getter省略

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "[姓名=" + name + ", 分数=" + score + "]";
    }
 
}