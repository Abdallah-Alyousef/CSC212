import java.util.Scanner;
public class Phonebook {
	int userChoice = 0;
	Scanner input = new Scanner(System.in); 
	// LinkedListADT<Contact>  contacts = new LinkedListADT<Contact>(); NEEDS TO BE BST
    BST<Contact> contacts = new BST<Contact>();
	LinkedListADT<Event>  events = new LinkedListADT<Event>();
    
	//For searching the contact in the list "contacts"
	// public boolean searchName_Phone(Contact c) {
	// 	if (contacts.empty()) {
	// 		return false;
	// 	}
	// 	contacts.findKey(contacts.root.key); //Find first !
	// 	//It will go through the list till the last contact and search for the contact by the name or phone number
	// 	while(contacts) {
	// 		if (contacts.retrieve().getContactName().equals(c.getContactName()) || contacts.retrieve().getPhoneNumber().equals(c.getPhoneNumber())) {
	// 			return true;
	// 		}
	// 		contacts.findNext();
	// 	}
	// 	//For checking the last contact that we stopped at while searching
	// 	if (contacts.retrieve().getContactName().equals(c.getContactName()) || contacts.retrieve().getPhoneNumber().equals(c.getPhoneNumber())) { 
	// 		return true;
	// 	}
	// 	//If not found at all
	// 	return false;
	// }


    public boolean searchName_Phone(Contact c) {
        if(contacts.empty()) {
            return false;
        }
        if(contacts.findKey(c.getContactName()) || contacts.findKey(c.getPhoneNumber())) {
            return true;
        }
        return false;
    }
    //This method will search a contact by its name
    public Contact searchName(String name) {
        if(contacts.empty()) {
            return null;
        }
        if(contacts.findKey(name)) {
            return contacts.retrieve();
        }
        return null;
    }

    //this method will search for a contact by phone number
    public Contact searchPhoneNumber(String number) {
        if(contacts.empty()) {
            return null;
        }
        
        if(contacts.findPhone(number)) {
            return contacts.retrieve();
        } 
        return null;
    }


	

	//this method will return a list of contacts that share the first name, to print them
	// public LinkedListADT<Contact> printByFirstName(String firstName) {
	// 	LinkedListADT<Contact> l = new LinkedListADT<Contact>();

	// 	if(contacts.empty()) { 
	// 		return null;
	// 	}
	// 	contacts.findFirst();
	// 	//It will go through the list till the last contact and search for the contact by the name or phone number
	// 	while(!contacts.last()) {
	// 		String [] a = (contacts.retrieve().getContactName()).split("\\s"); //for spliting the first name from the last name
	// 		if (a[0].equalsIgnoreCase(firstName)) {
	// 			l.addSorted(contacts.retrieve());
	// 		}
	// 		contacts.findNext();
	// 	}
	
	// 	String [] b = (contacts.retrieve().getContactName()).split("\\s");//for spliting the first name from the last name
	// 	//For checking the last contact that we stopped at while searching
	// 	if (b[0].equalsIgnoreCase(firstName)) {
	// 		l.addSorted(contacts.retrieve());
	// 	}

	// 	//if we don't find any contact has the first name
	// 	if(l.empty()) {
	// 		return null;
	// 	}
	// 	return l;
	// }

	//For adding contact to the list "If it's not exists"
	// public void addContact(Contact c) {
	// 	//Checking if the contact is already exsists or not
	// 	boolean exists = searchName_Phone(c);
	// 	if(!exists) {
	// 		// contacts.addSorted(c);
    //         contacts.insert(k, c);
	// 	}
	// }

	//For deleting the contact by it's name
	// public void deleteByName(String name) {
	// 	if(contacts.empty()) {
	// 		System.out.print("There is no contacts to delete!\n");
	// 		return;
	// 	}

	// 	//This for deleting every event of the contact that you want to delete ..
	// 	events.findFirst();
	// 	while(!events.last()) {
	// 		if(events.retrieve().getContactName().equalsIgnoreCase(name)) {
	// 			events.deleteCont(events.retrieve());
	// 		}
	// 		events.findNext();
	// 	}

	// 	//Checking last one
	// 	if(events.retrieve().getContactName().equalsIgnoreCase(name)) {
	// 			events.deleteCont(events.retrieve());
	// 		}

	// 	//This for deleting the contact itself ..
	// 	contacts.findFirst();
	// 	while(!contacts.last()) {
	// 		if(contacts.retrieve().getContactName().equalsIgnoreCase(name)) {
	// 			contacts.deleteCont(contacts.retrieve());
	// 			System.out.println("Contact deleted ..\n");
	// 			return;
	// 		}
	// 		contacts.findNext();
	// 	}

	// 	//For checking the last contact ..
	// 	if (contacts.retrieve().getContactName().equalsIgnoreCase(name)) {
	// 		contacts.deleteCont(contacts.retrieve());
	// 		System.out.println("Contact deleted ..\n");
	// 		return;
	// 	}
	// 	else {
	// 		System.out.println("This contact either doesnt exist or its a invalid input");
	// 	}
	// }

    public BST<Contact> searchByEmail(String email) {
        BST<Contact> tmp = new BST<Contact>();

        if(contacts.empty()) {
            return null;
        }

        while(contacts.traverseBST()) {
            if(contacts.findEmailAddress(email)) {
                tmp.insert(contacts.retrieve().getContactName(), contacts.retrieve()); 
            } 
        }
         
        
        
        
        return tmp;
    }

	//This will return a linked list that contains contact with the same email we want to search of
	// public LinkedListADT<Contact> searchByEmail(String email) {
	// 	LinkedListADT<Contact> tmp = new LinkedListADT<Contact>();

	// 	if(contacts.empty()) {
	// 		return null;
	// 	}
	// 	contacts.findFirst();

	// 	//Go through the List "except the last one" and insert any contact that has the same email that selected
	// 	while(!contacts.last()) {
	// 		if(contacts.retrieve().getEmailAddress().equalsIgnoreCase(email)) {
	// 			tmp.addSorted(contacts.retrieve());
	// 		}
	// 		contacts.findNext();
	// 	}

	// 	//Will check the last one's email
	// 	if(contacts.retrieve().getEmailAddress().equalsIgnoreCase(email)) {
	// 		tmp.addSorted(contacts.retrieve());
	// 	}

	// 	//if we don't find any contact has the email
	// 	if(tmp.empty()) {
	// 		return null;
	// 	}
	// 	return tmp;
	// }

	//This will return a linked list that contains contact with the same birthday we want to search of
	// public LinkedListADT<Contact> searchByBirthday(String Bday) {
	// 	LinkedListADT<Contact> tmp = new LinkedListADT<Contact>();

	// 	if(contacts.empty()) {
	// 		return null;
	// 	}
	// 	contacts.findFirst();

	// 	//Go through the List "except the last one" and insert any contact that has the same birthday that selected
	// 	while(!contacts.last()) {
	// 		if(contacts.retrieve().getBirthday().equalsIgnoreCase(Bday)) {
	// 			tmp.addSorted(contacts.retrieve());
	// 		}
	// 		contacts.findNext();
	// 	}
	// 	//Will check the last one's birthday
	// 	if(contacts.retrieve().getBirthday().equalsIgnoreCase(Bday)) {
	// 		tmp.addSorted(contacts.retrieve());
	// 	}
		
	// 	//if we don't find any contact has the birthday
	// 	if(tmp.empty()) {
	// 		return null;
	// 	}
	// 	return tmp;
	// }

	//This will return a linked list that contains contact with the same address we want to search of
	// public LinkedListADT<Contact> searchByAddress(String address) {
	// 	LinkedListADT<Contact> tmp = new LinkedListADT<Contact>();

	// 	if(contacts.empty()) {
	// 		return null;
	// 	}
	// 	contacts.findFirst();

	// 	//Go through the List "except the last one" and insert any contact that has the same address that selected
	// 	while(!contacts.last()) {
	// 		if(contacts.retrieve().getAddress().equalsIgnoreCase(address)) {
	// 			tmp.addSorted(contacts.retrieve());
	// 		}
	// 		contacts.findNext();
	// 	}

	// 	//Will check the last one's address
	// 	if(contacts.retrieve().getAddress().equalsIgnoreCase(address)) {
	// 		tmp.addSorted(contacts.retrieve());
	// 	}
		
	// 	//if we don't find any contact has the address
	// 	if(tmp.empty()) {
	// 		return null;		
	// 	}
	// 	return tmp;
	// }

	//This will print each event and the contacts that share that event (For requirements)
	public void printEventList(String eventTitle) {
		if(events.empty()) {
			System.out.println("There is no events at all!");
		}

		System.out.println(eventTitle);
		System.out.println("Here is all events that holds this title: \n");
		events.findFirst();

		while(!events.last()) {
			if(events.retrieve().getEventTitle().equalsIgnoreCase(eventTitle)){
				System.out.println(events.retrieve().toString());
			}
			System.out.println("");
			events.findNext();
		}
		
		if(events.retrieve().getEventTitle().equalsIgnoreCase(eventTitle)) {
			System.out.println(events.retrieve().toString());
		}
		System.out.println("");
	}

	//Searching for an event by it's title
	public Event searchEventByTitle(String title) {
		if(events.empty()) {
			return null;
		}
		events.findFirst();

		//go through the list for searching
		while(!events.last()) {
			if(events.retrieve().getEventTitle().equalsIgnoreCase(title)) {
				return events.retrieve();
			}
			events.findNext();
		}
		//For checking the last one
		if(events.retrieve().getEventTitle().equalsIgnoreCase(title)) {
			return events.retrieve();
		}
		//if we don't find it at all
		return null;
	}

	//Searching for an event by the contact's name
	public Event searchEventByName(String name) {
		if(events.empty()) {
			return null;
		}
		events.findFirst();

		//go through the list for searching
		while(!events.last()) {
			if(events.retrieve().getContactName().equalsIgnoreCase(name)) {
				return events.retrieve();
			}
			events.findNext();
		}

		//For checking the last one
		if(events.retrieve().getContactName().equalsIgnoreCase(name)) {
			return events.retrieve();
		}

		//if we don't find it at all
		return null;
	}

	//for checking if there's a conflict between events or not
	public boolean conflictEvent(Event event, String name) {
		Contact contact = searchName(name);

		//To check if the contact exists 
		if(contact != null) {
			// LinkedListADT<Event> eventsContact = contact.get();
			if(events.empty()) {
				return false; //There's no events for this contact, so there's no conflict
			}
			events.findFirst();

			//going through tha events and check the date and time of each one
			while(!events.last()) {
				if(event.getDate().equalsIgnoreCase(events.retrieve().getDate()) && event.getTime().equalsIgnoreCase(events.retrieve().getTime()) && event.getEventTitle().equalsIgnoreCase(events.retrieve().getEventTitle())) {
					return true; //conflict found!
				}
				events.findNext();
			}

			//for the last one
			if(event.getDate().equalsIgnoreCase(events.retrieve().getDate()) && event.getTime().equalsIgnoreCase(events.retrieve().getTime()) && event.getEventTitle().equalsIgnoreCase(events.retrieve().getEventTitle())) {
				return true; //conflict found!
			}

			//if there's no conflict at all 
			return false;
		} 
		else {
			return false;
		}
	}

	//For scheduling an event with contact by it's name
	public boolean scheduleEvent(Event event, String contactName) { 
		Contact contact = searchName(contactName); //This needs to be changed according to BST

		if(contact==null) {
			System.out.println(contactName+" doesn't exists!");
			return false;
		}

		boolean conflict = conflictEvent(event, contactName);
		if(contact!=null && !conflict) {
			System.out.println(event.getEventTitle()+" is scheduled with "+contact.getContactName());

			// //adding new event for the contact
			// contact.eventsOfContact.addEventSorted(event);

			//adding new contact for the event
			// event.contactsEvent.addSorted(contact);
			// addEvent(event);
            events.addEventSorted(event);
			return true;
		}

		//if there's a conflict with the events of the contact
		if(conflictEvent(event, contactName)) {
			return false;
		}
		return false;
	}

    public LinkedListADT<Event> getEventsByName(String name) {
        LinkedListADT<Event> list = new LinkedListADT<Event>();
        
        if(searchName(name) == null) {
            return null;
        }
        events.findFirst();
        while(!events.last()) {
            if(events.retrieve().getContactName().equalsIgnoreCase(name)) {
                list.addEventSorted(events.retrieve());
            }
            events.findNext();
        }
        if(events.retrieve().getContactName().equalsIgnoreCase(name)) {
                list.addEventSorted(events.retrieve());
         }
         return list;
    }

	//For printing the menu of the phonebook
	public void displayMenu() {

		System.out.println("Welcome to the Linked Tree Phonebook!");
		do {
			System.out.println("Please choose an option: ");
			System.out.println("1. Add a contact");
			System.out.println("2. Search for a contact");
			System.out.println("3. Delete a contact");
			System.out.println("4. Schedule an event");
			System.out.println("5. Print events details");
			System.out.println("6. Print contacts by first name");
			System.out.println("7. Print all events alphabetically");
			System.out.println("8. Exit"+"\n");
			System.out.print("Enter your choice: ");
			userChoice = input.nextInt();
			System.out.println("");
			
			input.nextLine(); // Fixes spaces between Next int and NextLine so it doesn't skip
			if(userChoice < 1 || userChoice > 8) {
				System.out.println("This is not a valid value!!\n");
				continue;
			}
			
			Event event = new Event();
			Contact contact = new Contact();
			switch(userChoice) {
			case 1: //Adding contacts
				contact.getCotactInfo();
				if(!searchName_Phone(contact)) {
					contacts.insert(contact.getContactName(),contact);
					System.out.println("");
					System.out.println("Contact added successfully!\n");
				}else {
					System.out.println("The contact already added!\n");
				}
				break;
			case 2: //searching and display the citeria menu for searching //NEEDS FIXING
			System.out.println("Enter search citeria:");
			System.out.println("1. Name");
			System.out.println("2. Phone Number");
			System.out.println("3. Email Address");
			System.out.println("4. Address");
			System.out.println("5. Birthday\n");
			System.out.print("Enter your choice: ");
			userChoice = input.nextInt();

			switch(userChoice) {
				case 1:
				System.out.println("");
				System.out.print("Enter the contact's name:");

				input.nextLine(); //For fixing some problrms about nextLine ...

				String name = input.nextLine();
				if(searchName(name)!=null) {
					System.out.println("Contact found!");
					System.out.println("");
					searchName(name).printContact();
				}
				else {
					System.out.println("Contact doesn't exist\n");
				}
				break;
				case 2:
				System.out.print("Enter the contact's Phone Number:");

				input.nextLine(); //For fixing some problrms about nextLine ...

				String number = input.nextLine();
				if(searchPhoneNumber(number)!=null) {
						System.out.println("Contact found!");
						System.out.println("");
						searchPhoneNumber(number).printContact();
				}
				else {
					System.out.println("Contact doesn't exist\n");
				}
				break;
				case 3:
				System.out.print("Enter the contact's Email Address:");

				input.nextLine(); //For fixing some problrms about nextLine ...

				String emailAdress = input.nextLine();
				if(searchByEmail(emailAdress)!=null) {
						System.out.println("Contacts found!");
						System.out.println("");
						searchByEmail(emailAdress).printBST();
				}
				else {
					System.out.println("Contact doesn't exist\n");
				}
				break;
				// case 4:
				// System.out.print("Enter the contact's Address:");

				// input.nextLine(); //Fixes Line problem in console

				// String address = input.nextLine();

				// if(searchByAddress(address)!=null) {
				// 		System.out.println("Contacts found!");
				// 		System.out.println("");
				// 		searchByAddress(address).printList();
				// }
				// else {
				// 	System.out.println("Contact doesn't exist\n");
				// }
				// break;
				// case 5:
				// System.out.print("Enter the contact's Birthday:");
				// input.nextLine(); //For fixing some problems about nextLine ...
				// String birthDay = input.next();

				// if(searchByBirthday(birthDay)!=null) {
				// 	System.out.println("Contacts found!");
				// 	System.out.println("");
				// 	searchByBirthday(birthDay).printList();
				// }
				// else {
				// 	System.out.println("Contact doesn't exist\n");
				// }
				// break;
			// }
			// 	break;
			// case 3: //deleting contact //NEEDS FIXING
			// System.out.print("Enter The contact's full name: ");
			// String fullName = input.nextLine();
			// deleteByName(fullName);
			// 	break;
				//CANNOT DO BEFORE EVENT
			// case 4: //Schedule an event
			// 	event.getEventInfo();
			// 	if(!conflictEvent(event, event.getContactName()) && scheduleEvent(event, event.getContactName())){
			// 		System.out.println("Event scheduled successfully!\n");
			// 	} else {
			// 		System.out.println("Can't schedule this event!\n");
			// 	}
			// 	break;
			// case 5: //Printing event details
			// 	System.out.println("Enter search criteria: ");
			// 	System.out.println("1. Contact name");
			// 	System.out.println("2. Event title\n");
			// 	System.out.print("Enter your choice: ");
			// 	userChoice = input.nextInt();

			// 	if(userChoice == 1) {
			// 		input.nextLine(); //Fixing input problems
			// 		System.out.print("Enter the contact's name: ");
			// 		String name = input.nextLine();
			// 		if(searchEventByName(name)!=null && getEventsByName(name) != null) { 
			// 			System.out.println("\nEvents found!");
			// 			getEventsByName(name).printEventList(); 
			// 		} else {
			// 			System.out.println("\nThis Contact doesn't exists\n");
			// 		}	
			// 	} else if(userChoice == 2) {
			// 		input.nextLine();
			// 		System.out.print("Enter the event title: ");
			// 		String title = input.nextLine();
			// 		if(searchEventByTitle(title)!=null){
			// 			System.out.println("\nEvent found!");
			// 			printEventList(title);
			// 		} else {
			// 			System.out.println("\nThis Event doesn't exists\n");
			// 		}
			// 	} else {
			// 		System.out.println("\ninvalid input!\n");
			// 	}
			// 	break;
			// case 6: //display every contact that has the same name //NEEDS FIXING
			// System.out.print("Enter first name: ");
			// String firstName = input.nextLine();
			// System.out.println("");
			
			// if(printByFirstName(firstName) != null) {
			// 	printByFirstName(firstName).printList();
			// }
			// else {
			// 	System.out.println(firstName+" doesn't exist in the contact list!\n");
			// }
			// 	break;
			case 7: //display all events alphabetically
				events.printEventList();
				break;
            }
            
            
        }
    }while(userChoice != 8);
    System.out.println("Goodbye!\n");
    }
}
