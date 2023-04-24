class MusicEvent extends Event{

    private String artist;

    public MusicEvent(int eventId, String eventName, String eventCity, double eventPrice, String artist){
        super(eventId, eventName, eventCity, eventPrice);
        this.artist = artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }
    public String getArtist(){
        return this.artist;
    }
    @Override
    public String toString(){
        return super.toString() + " " + getArtist();
    }
}