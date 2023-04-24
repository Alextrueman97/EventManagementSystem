
class SportsEvent extends Event{
    private String commentator;

    public SportsEvent(int eventId, String eventName, String eventCity, double eventPrice, String commentator){
        super(eventId, eventName, eventCity, eventPrice);
        this.commentator = commentator;
    }

    public void setCommentator(String commentator){
        this.commentator = commentator;
    }
    public String getCommentator(){
        return this.commentator;
    }

    @Override
    public String toString(){
        return super.toString() + " " + getCommentator();
    }

}
