//Using Java 11 using VS code.
//To run this program go to program file folder and initiate CMD.
//Use javac EventManagementSystem.java to compile.
//Then use java EventManagementSystem
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Set;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.Writer;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

class EventManagementSystem{

    public static void main(String[] args){

        //objects for events
        Event e1 = new SportsEvent(1, "Football match", "london", 49.99, "John Smith");
        Event e2 = new MusicEvent(2, "Curtain Call", "Manchester", 74.99, "Eminem");
        Event e3 = new SportsEvent(3, "Gymnastics", "Glasgow", 35.99, "Matt Shaw");
        Event e4 = new MusicEvent(4, "The Big One", "Brighton", 80.00, "Adelle");
        Event e5 = new SportsEvent(5, "Rugby World Cup", "London", 95.99, "Sam Michael");
    
        //array list for events
        List<Event> eventList = new ArrayList<>();
        eventList.add(e1);
        eventList.add(e2);
        eventList.add(e3);
        eventList.add(e4);
        eventList.add(e5);

        //HashMap for events 
        Map<Integer, Event> eventMap = new HashMap<>();
        eventMap.put(e1.getEventId(), e1);
        eventMap.put(e2.getEventId(), e2);
        eventMap.put(e3.getEventId(), e3);
        eventMap.put(e4.getEventId(), e4);
        eventMap.put(e5.getEventId(), e5);
        Set<Integer> id = eventMap.keySet();
        
        //Pre made Attendee objects
        Attendee a1 = new Attendee(1, "Alex", "Trueman", 25, "alex.a.trueman@aol.com", e1);
        Attendee a2 = new Attendee(2, "Katie", "Smith", 29, "katie.e.S@hotmail.com", e2);
        Attendee a3 = new Attendee(3, "Jaocb", "Housden", 24, "jshousden@outlook.com", e3);
        Attendee a4 = new Attendee(4, "Josh", "Suraweera", 28, "joshy@aol.com", e1);
        Attendee a5 = new Attendee(5, "Nav", "Mahil", 30, "Navstar@hotmail.co.uk", e4);
        Attendee a6 = new Attendee(6, "Amanda", "Bignell", 56, "abignell@outlook.co.uk", e5);
        Attendee a7 = new Attendee(7, "Antony", "Trueman", 61, "atruebig@gmail.com", e3);
        Attendee a8 = new Attendee(8, "Patricia", "Biggs", 75, "patty@aol.com", e5);
        Attendee a9 = new Attendee(9, "Anthony", "Withall", 26, "awithall@aol.com", e2);
        Attendee a10 = new Attendee(10, "John", "Madden", 50, "Jmadden@outlook.com", e4);

        //Attendee ArrayList
        List<Attendee> attendeeList = new ArrayList<>();
        attendeeList.add(a1);
        attendeeList.add(a2);
        attendeeList.add(a3);
        attendeeList.add(a4);
        attendeeList.add(a5);
        attendeeList.add(a6);
        attendeeList.add(a7);
        attendeeList.add(a8);
        attendeeList.add(a9);
        attendeeList.add(a10);

        
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        int userChoice;
    try{      
        do{
            
            MenuReader.menuReader();
            userChoice = scan.nextInt();
        
        switch (userChoice){
            case 1: //list all events
                Iterator<Event> el = eventList.iterator();
                while(el.hasNext()){
                    Event e = el.next();
                    System.out.println(e);
                }
                break;
            case 2: //Select 1 event to see details
                System.out.println("Please Select an Id for an Event");
                int userInputId = scan.nextInt();
                if(id.contains(userInputId)){
                    System.out.println(eventMap.get(userInputId));
                }
                else{
                    System.out.println("Sorry no Key exists here!");
                }                                
                break;
            case 3: // edit an event
                el = eventList.iterator();
                    while(el.hasNext()){
                    Event e = el.next();
                    System.out.println(e);
                }
                boolean found = false;
                System.out.println("Enter Event Id to Update");
                int eventId = scan.nextInt();
                ListIterator<Event> el2 = eventList.listIterator();
                while(el2.hasNext() & !found){
                    Event e = el2.next();
                    if(eventId == e.getEventId()){
                        scan.nextLine();
                        System.out.println("Enter new event name");
                        String eventName = scan2.nextLine();
                        System.out.println("Enter New Event City");
                        String eventCity = scan2.nextLine();
                        System.out.println("Enter new Event Price");
                        double eventPrice = scan3.nextDouble();
                        
                        if(e instanceof SportsEvent){
                            System.out.println("Enter new commentator");
                            String commentator = scan2.nextLine();
                            el2.set(new SportsEvent(eventId, eventName, eventCity, eventPrice, commentator));
                        }
                        else if(e instanceof MusicEvent){
                            System.out.println("Enter a new artist");
                            String artist = scan2.nextLine();
                            el2.set(new MusicEvent(eventId, eventName, eventCity, eventPrice, artist));
                        }
                        found = true;   
                    }
                }
                if(!found){
                    System.out.println("No Event found..Not updated");
                }
                else{
                    System.out.println("Event Updated successfully");
                }
                    
                break;
            case 4://delete an event
                el = eventList.iterator();
                    while(el.hasNext()){
                        Event e = el.next();
                        System.out.println(e);
                    }   
                found = false;
                System.out.println("Enter Event Id to delete");
                eventId = scan.nextInt();
                el = eventList.iterator();
                while(el.hasNext()){
                    Event e = el.next();
                    if(e.getEventId() == eventId)
                        el.remove();
                        found = true;   
                }
                if(!found){
                    System.out.println("No Event found");
                }
               else{
                    System.out.println("Event Deleted successfully");
               }
                break;
            case 5: // list attendees attending an event
                el = eventList.iterator();
                while(el.hasNext()){
                    Event e = el.next();
                    System.out.println(e);
                 }
                Iterator<Attendee> al = attendeeList.iterator();
                found = false;
                System.out.println("Select an event Id to view attendees");
                eventId = scan.nextInt();
                al = attendeeList.iterator();
                    while(al.hasNext()){
                        Attendee a = al.next();
                        if(a.getEvent().getEventId() == eventId)    //this line asks to get the event from Attendee class by looking for eventId in the event class.
                            System.out.println(a);
                            found = true;
                    }
                    if(!found){
                        System.out.println("Sorry no Event or Attendees exist with this Event Id");
                    }
                break;
            case 6: // Adding an attendee and adding them to an event
                        al = attendeeList.iterator();
                        while(al.hasNext()){
                            Attendee a = al.next();
                            System.out.println(a);
                        }
                    System.out.println("Please enter a new Attendee Id");
                    int attendeeId = scan.nextInt();
                    System.out.println("Please enter Attendees First Name");
                    String firstName = scan2.nextLine();
                    System.out.println("Please enter Attendees Last Name");
                    String lastName = scan2.nextLine();
                    System.out.println("Please Enter Attendees Age");
                    int age = scan.nextInt();
                    System.out.println("Please enter Attendee email");
                    String email = scan2.nextLine();
                    el = eventList.iterator();
                        while(el.hasNext()){
                            Event e = el.next();
                            System.out.println(e);
                        }
                    System.out.println("Please enter the event Id");
                    eventId = scan.nextInt();
                    for(Event event : eventList){
                        if (eventId == event.getEventId()){
                            attendeeList.add(new Attendee(attendeeId, firstName, lastName, age, email, event));
                        }
                    }
                    System.out.println("Attendee Added thank you");
                
                

                break;
            case 7: // remove an attendee from an event 
                    al = attendeeList.iterator();
                        while(al.hasNext()){
                            Attendee a = al.next();
                            System.out.println(a);
                        }
                    found = false;
                    System.out.println("Select an Attendee Id you wish to remove");
                    int attendeeId2 = scan.nextInt();
                    al = attendeeList.iterator();
                    while(al.hasNext()){
                        Attendee a = al.next();
                        if(a.getAttendeeId() == attendeeId2)
                            al.remove();
                            found = true;
                    }
                    if(!found){
                        System.out.println("No Attendee found with this Id");
                    }
                    else{
                        System.out.println("Attendee Removed Successfully");
                    }
                break;
            case 8: // option to exit from program loop
                System.out.println("Thank you and goodbye!");
                break;
            default:
                System.out.println("Sorry! Wrong Entry: Please Enter a value between 1-8");
                break;
            
            }
        } 
        while(userChoice != 8);
        scan.close();
        scan2.close();
        scan3.close();
    }
    catch(InputMismatchException ex){
        System.out.println("Sorry you used the wrong input type!");
        }
    }
    
}