
class Attendee{
    private int attendeeId;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Event event;

    //creating constructors for Attendees
    
    public Attendee(int attendeeId, String firstName, String lastName, int age, String email, Event event){
        this.attendeeId = attendeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.event = event;
    }

    //creating setters and getters
    public void setAttendeeId(int attendeeId){
        this.attendeeId = attendeeId;
    }
    public int getAttendeeId(){
        return this.attendeeId;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEvent(Event event){
        this.event = event;
    }
    public Event getEvent(){
        return this.event;
    }

    @Override
    public String toString(){
        return this.attendeeId + " " + this.firstName + " " + this.lastName + " " + this.age + " " + this.email;
    }
}