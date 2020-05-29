package temptest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 谭春
 * Date: 2020/5/29
 * Description:
 */
public class A {
    public static void main(String[] args) {

        List<EventRelation> eventRelationList=new ArrayList<>();
        EventRelation e1 = new EventRelation();
        e1.setRelationId(1L);
        e1.setEventId(4L);
        e1.setLinkEventId(5L);
        EventRelation e2 = new EventRelation();
        e2.setRelationId(1L);
        e2.setEventId(1L);
        e2.setLinkEventId(6L);
        EventRelation e3 = new EventRelation();
        e3.setRelationId(1L);
        e3.setEventId(2L);
        e3.setLinkEventId(1L);
        EventRelation e4 = new EventRelation();
        e4.setRelationId(1L);
        e4.setEventId(2L);
        e4.setLinkEventId(4L);
        EventRelation e5 = new EventRelation();
        e5.setRelationId(1L);
        e5.setEventId(3L);
        e5.setLinkEventId(4L);
        eventRelationList.add(e1);
        eventRelationList.add(e2);
        eventRelationList.add(e3);
        eventRelationList.add(e4);
        eventRelationList.add(e5);
        Map<Long, Set<Long>> leftMap = eventRelationList.stream()
                .collect(Collectors.groupingBy(EventRelation::getEventId,
                        Collectors.mapping(EventRelation::getLinkEventId, Collectors.toSet())));
        //对LinkEventId排序，获得每个LinkEventId的EventId集合
        Map<Long, Set<Long>> rightMap = eventRelationList.stream()
                .collect(Collectors.groupingBy(EventRelation::getLinkEventId,
                        Collectors.mapping(EventRelation::getEventId, Collectors.toSet())));
        System.out.println("1");

        for (EventRelation eventRelation : eventRelationList) {
            //如果以EventId分组，过滤掉重复的关联关系 如id1 id2  和id2 id1。
            if (leftMap.get(eventRelation.getLinkEventId()) != null && leftMap.get(eventRelation.getLinkEventId()).contains(eventRelation.getEventId())) {
                System.out.println("重复");
            }
            //如果以LinkEventId分组，过滤掉重复的关联关系
            if (rightMap.get(eventRelation.getEventId()) != null && rightMap.get(eventRelation.getEventId()).contains(eventRelation.getLinkEventId())) {
                System.out.println("重复");
            }
        }
    }
}

