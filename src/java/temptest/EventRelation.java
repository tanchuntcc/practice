package temptest;


public class EventRelation{

    /**
     * 关系表ID
     */
    private Long relationId;

    /**
     * A事件单ID
     */
    private Long eventId;

    /**
     * B事件单ID
     */
    private Long linkEventId;

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getLinkEventId() {
        return linkEventId;
    }

    public void setLinkEventId(Long linkEventId) {
        this.linkEventId = linkEventId;
    }
}
