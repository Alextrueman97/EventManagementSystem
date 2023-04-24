import java.util.Set;

class Event{
    private int eventId;
    private String eventName;
    private String eventCity;
    private double eventPrice;


    //default constructor
    public Event(){
        this.eventId = 0;
        this.eventName = "null";
        this.eventCity = "null";
        this.eventPrice = 00.00;
    }
    //Constructor
    public Event(int eventId, String eventName, String eventCity, double eventPrice){
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventCity = eventCity;
        this.eventPrice = eventPrice;
    }
    //setters and getters
    public void setEventId(int eventId){
        this.eventId = eventId;
    }
    public int getEventId(){
        return this.eventId;
    }
    public void setEventName(String eventName){
        this.eventName = eventName;
    }
    public String getEventName(){
        return this.eventName;
    }
    public void setEventCity(String eventCity){
        this.eventCity = eventCity;
    }
    public String getEventCity(){
        return this.eventCity;
    }
    public void setEventPrice(double eventPrice){
        this.eventPrice = eventPrice;
    }
    public double getEventPrice(){
        return this.eventPrice;
    }

    @Override
    public String toString(){
        return this.eventId + " " + this.eventName + " " + this.eventCity + " " + this.eventPrice;
    }

   
    


}