import java.util.Scanner;

public class Contact implements Comparable<String>{

    Scanner kb = new Scanner(System.in);

    String contactName;
    String phoneNumber;
    String emailAddress;
    String address;
    String birthday;
    String notes;
    //Setter and Getters

    public String getContactName() {
        return contactName;
    }

    public String getFirstName(String fullName) {
      String [] b = (fullName).split("\\s"); //At index 0 we have the firstName
      return b[0];
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    //Other methods


    
	public int compareTo(String c) {
		return contactName.compareTo(c);
	}

	public int compareTo(Contact c) {
		return contactName.compareTo(c.contactName);
	}

    


    public void printContact(){
		System.out.println("Name: "+contactName);
		System.out.println("Phone Number: "+phoneNumber);
		System.out.println("Email Address: "+emailAddress);
		System.out.println("Address: "+address);
		System.out.println("Birthday: "+birthday);
		System.out.println("Notes: "+notes + "\n");
	}

  public String toString() {
    return "Name: "+contactName + "\nPhone Number: "+phoneNumber + "\nEmail Address: "+emailAddress
     +"\nAddress: "+address+"\nBirthday: "+birthday 
     +"\nNotes: "+notes + "\n";
  }


    //To save the contact information
	public void getCotactInfo(){
		System.out.print("Enter the contact's name: ");
		setContactName(kb.nextLine()); 
				
		System.out.print("Enter the contact's phone number: ");
		setPhoneNumber(kb.nextLine()); 
				
		System.out.print("Enter the contact's email address: ");
		setEmailAddress(kb.next()); 
				
		kb.nextLine();
				
		System.out.print("Enter the contact's address: ");
		setAddress(kb.nextLine()); 

		System.out.print("Enter the contact's birthday: ");
		setBirthday(kb.next()); 
				
		kb.nextLine();
				
		System.out.print("Enter any notes for the contact: ");
		setNotes(kb.nextLine());
	}

  


}