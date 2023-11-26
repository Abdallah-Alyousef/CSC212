import java.util.Scanner;

public class Event {
    private String eventTitle;
    private String date;
    private String time;
    private String location;
    private String contactName;
    public LinkedListADT<Event> events = new LinkedListADT<Event>();

    Scanner input = new Scanner(System.in);
    
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getEventTitle() {
        return eventTitle;
    }
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
     public void setTime(String time) {
        this.time = time;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public LinkedListADT<Event> getEvents(){
        return events;
    }

    @Override
    public String toString() {
        return "Event title: "+ eventTitle +"\nContact name: "+ contactName +"\nEvent date and time(MM/DD/YYY HH:MM): " + date + " " + time + "\nEvent location: " + location+"\n";
    }

    public int compareTo(Event e) {
		return eventTitle.compareTo(e.eventTitle);
	}

    public void getEventInfo(){
        System.out.print("Enter event title: ");
        setEventTitle(input.nextLine());
        System.out.print("Enter contact name: ");
        setContactName(input.nextLine());
        System.out.print("Enter event date (MM/DD/YYYY): ");
        setDate(input.nextLine());
        System.out.print("Enter event Time (HH:MM): ");
        setTime(input.nextLine());
        System.out.print("Enter event location: ");
        setLocation(input.nextLine());
        System.out.println("");
    }
}
