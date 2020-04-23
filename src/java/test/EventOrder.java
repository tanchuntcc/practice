package test;

import java.security.PrivateKey;
import java.util.List;

/**
 * @author 谭春
 * Date: 2020/4/20
 * Description:
 */
public class EventOrder {
    private Integer aaa;
    private Integer bbb;
    private List<Item> itemList;

    public EventOrder() {
    }

    public EventOrder(Integer aaa, Integer bbb, List<Item> itemList) {
        this.aaa = aaa;
        this.bbb = bbb;
        this.itemList = itemList;
    }

    public Integer getAaa() {
        return aaa;
    }

    public void setAaa(Integer aaa) {
        this.aaa = aaa;
    }

    public Integer getBbb() {
        return bbb;
    }

    public void setBbb(Integer bbb) {
        this.bbb = bbb;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "EventOrder{" +
                "aaa=" + aaa +
                ", bbb=" + bbb +
                ", itemList=" + itemList +
                '}';
    }
}

