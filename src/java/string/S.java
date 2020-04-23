package string;

/**
 * @author 谭春
 * Date: 2020/3/30
 * Description:
 */
public class S {
    private S s;

    public S() {
    }

    public synchronized  S   getS(){
        if (s==null){
            synchronized (S.class){
                if (s==null) {
                    s=new S();
                }
                }
            }
        return s;
    }
}

