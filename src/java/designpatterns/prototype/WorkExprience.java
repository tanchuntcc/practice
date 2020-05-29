package designpatterns.prototype;

/**
 * @author 谭春
 * Date: 2020/3/9
 * Description:
 */
public class WorkExprience implements Cloneable {
    public String workDate;
    public String company;

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

