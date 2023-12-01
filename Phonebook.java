import java.util.Scanner;
public class Phonebook {

	Scanner input = new Scanner(System.in); 
	int userChoice = 0;
    BST<Contact> contacts = new BST<Contact>();
	LinkedListADT<Event> events = new LinkedListADT<Event>();

    //For searching for either name or phone
    public boolean searchName_Phone(Contact c) {
        if(contacts.empty()) {
            return false;
        }
        if(searchName(c.getContactName()) != null || searchPhoneNumber(c.getPhoneNumber()) != null) {
            return true;
        }
        return false;
    }

    //This method will search a contact by its name
    public Contact searchName(String name) {
        if (contacts.empty()) {
            return null;
        }
    
        return searchNameRecursive(contacts.findRoot(), name);
    }
    
    private Contact searchNameRecursive(BSTNode<Contact>node, String name) {
        if (node == null) {
            return null;
        }
    
        int comparison = node.data.getContactName().compareToIgnoreCase(name);
    
        if (comparison == 0) {
            return node.data;
        } else if (comparison > 0) {
            return searchNameRecursive(node.left, name);
        } else {
            return searchNameRecursive(node.right, name);
        }
    }

    //this method will search for a contact by phone number Recursively
    public Contact searchPhoneNumber(String number) {
        if(contacts.empty()) {
            return null;
        }
        
        if(contacts.findPhone(number)) {
            return contacts.retrieve();
        } 
        return null;
    }

    //BST method to find firstName
    public BST<Contact> searchByFirstName(String firstName) {
        BST<Contact> tmp = new BST<>();
    
        if (contacts.empty()) {
            return null;
        }
        else 
        searchByFirstNameRecursive(contacts.findRoot(), firstName, tmp);
    
        if(tmp.empty()) {
            return null;
        }

        return tmp;
    }
    
    private void searchByFirstNameRecursive(BSTNode<Contact> node, String firstName, BST<Contact> tmp) {
        if (node != null) {
            searchByFirstNameRecursive(node.left, firstName, tmp);
    
            if (node.data.getFirstName(node.data.getContactName()).equalsIgnoreCase(firstName)) {
                tmp.insert(node.data.getContactName(), node.data);
            }
    
            searchByFirstNameRecursive(node.right, firstName, tmp);
        }
    }

	//For deleting the contact by it's name
	public void deleteByName(String name) {
		if(contacts.empty()) {
			System.out.print("There is no contacts to delete!\n");
			return;
		}
        if(contacts.remove_key(name)) {
            System.out.println("\nContact Succesfully Deleted..\n");
        }else {
            System.out.println("\nThis contact either doesnt exist or its a invalid input\n");
        }
    
		// //This for deleting every event of the contact that you want to delete ..
		events.findFirst();
		if(!events.empty()){
		while(!events.last()) {
			if(events.retrieve().getContactName().equalsIgnoreCase(name)) {
				events.deleteCont(events.retrieve());
			}
			events.findNext();
		}

		//Checking last one
		if(events.retrieve().getContactName().equalsIgnoreCase(name)) {
				events.deleteCont(events.retrieve());
			}
		} 
	}

    //Recursive method to search for emails
    public BST<Contact> searchByEmail(String email) {
        BST<Contact> tmp = new BST<>();
    
        if (contacts.empty()) {
            return null;
        }
        else 
        searchByEmailRecursive(contacts.findRoot(), email, tmp);
    
        if(tmp.empty()) {
            return null;
        }

        return tmp;
    }
    
    private void searchByEmailRecursive(BSTNode<Contact> node, String email, BST<Contact> tmp) {
        if (node != null) {
            searchByEmailRecursive(node.left, email, tmp);
    
            if (node.data.getEmailAddress().equalsIgnoreCase(email)) {
                tmp.insert(node.data.getContactName(), node.data);
            }
    
            searchByEmailRecursive(node.right, email, tmp);
        }
    }
    //Recursive method to search for birthdays
    public BST<Contact> searchByBirthday(String Bday) {
        BST<Contact> tmp = new BST<>();
    
        if (contacts.empty()) {
            return null;
        }
        else 
        searchByBirthdayRecursive(contacts.findRoot(), Bday, tmp);
    
        if(tmp.empty()) {
            return null;
        }
        
        return tmp;
    }
    
    private void searchByBirthdayRecursive(BSTNode<Contact> node, String Bday, BST<Contact> tmp) {
        if (node != null) {
            searchByBirthdayRecursive(node.left, Bday, tmp);
    
            if (node.data.getBirthday().equalsIgnoreCase(Bday)) {
                tmp.insert(node.data.getContactName(), node.data);
            }
    
            searchByBirthdayRecursive(node.right, Bday, tmp);
        }
    }

    //Recursive method to search for addresses
    public BST<Contact> searchByAddress(String address) {
        BST<Contact> tmp = new BST<>();
    
        if (contacts.empty()) {
            return null;
        }
        else 
        searchByAddressRecursive(contacts.findRoot(), address, tmp);
    
        if(tmp.empty()) {
            return null;
        }
        return tmp;
    }
    
    private void searchByAddressRecursive(BSTNode<Contact> node, String address, BST<Contact> tmp) {
        if (node != null) {
            searchByAddressRecursive(node.left, address, tmp);
    
            if (node.data.getAddress().equalsIgnoreCase(address)) {
                tmp.insert(node.data.getContactName(), node.data);
            }
    
            searchByAddressRecursive(node.right, address, tmp);
        }
    }

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
				if(event.getDate().equalsIgnoreCase(events.retrieve().getDate()) && event.getTime().equalsIgnoreCase(events.retrieve().getTime())) {
					return true; //conflict found!
				}
				events.findNext();
			}

			//for the last one
			if(event.getDate().equalsIgnoreCase(events.retrieve().getDate()) && event.getTime().equalsIgnoreCase(events.retrieve().getTime())) {
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
			System.out.println("4. Schedule an event \\ appointment");
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
			case 2: //searching and display the citeria menu for searching
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

				input.nextLine(); //For fixing some problems about nextLine ...

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

				input.nextLine(); //For fixing some problems about nextLine ...

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

				input.nextLine(); //For fixing some problems about nextLine ...

				String emailAdress = input.nextLine();
				if(searchByEmail(emailAdress)!=null) {
						System.out.println("Contacts found!");
						System.out.println("");
						searchByEmail(emailAdress).printTree();
				}
				else {
					System.out.println("Contact doesn't exist\n");
				}
				break;
				case 4:
				System.out.print("Enter the contact's Address:");

				input.nextLine(); //Fixes Line problem in console

				String address = input.nextLine();

				if(searchByAddress(address)!=null ) {
						System.out.println("Contacts found!");
						System.out.println("");
						searchByAddress(address).printTree();
				}
				else {
					System.out.println("Contact doesn't exist\n");
				}
				break;
				case 5:
				System.out.print("Enter the contact's Birthday:");
				input.nextLine(); //For fixing some problems about nextLine ...
				String birthDay = input.next();

				if(searchByBirthday(birthDay)!=null) {
					System.out.println("Contacts found!");
					System.out.println("");
					searchByBirthday(birthDay).printTree();
				}
				else {
					System.out.println("Contact doesn't exist\n");
				}
				break;
			}
				break;
			case 3: //deleting contact
			    System.out.print("Enter The contact's full name: ");
			    String fullName = input.nextLine();
			    deleteByName(fullName);
				break;
			case 4: //Schedule an event or appointment
				System.out.println("1. Schedule an event");
				System.out.println("2. make an appointment\n");
				System.out.print("Enter your choice: ");
				userChoice = input.nextInt();
				if(userChoice == 1){
					event.getEventInfo();
					if(!conflictEvent(event, event.getContactName()) && scheduleEvent(event, event.getContactName())){
						System.out.println("Event scheduled successfully!\n");
					} else {
						System.out.println("Can't schedule this event!\n");
					}
				}else if (userChoice == 2){
					//Need to be fill !!!!!!!!!!!!!


				}else {
					System.out.println("\ninvalid input!\n");
				}
				break;
			case 5: //Printing event details
				System.out.println("Enter search criteria: ");
				System.out.println("1. Contact name");
				System.out.println("2. Event title\n");
				System.out.print("Enter your choice: ");
				userChoice = input.nextInt();

				if(userChoice == 1) {
					input.nextLine(); //Fixing input problems
					System.out.print("Enter the contact's name: ");
					String name = input.nextLine();
					if(searchEventByName(name)!=null && getEventsByName(name) != null) { 
						System.out.println("\nEvents found!");
						getEventsByName(name).printEventList(); 
					} else {
						System.out.println("\nThis Contact doesn't exists\n");
					}	
				} else if(userChoice == 2) {
					input.nextLine();
					System.out.print("Enter the event title: ");
					String title = input.nextLine();
					if(searchEventByTitle(title)!=null){
						System.out.println("\nEvent found!");
						printEventList(title);
					} else {
						System.out.println("\nThis Event doesn't exists\n");
					}
				} else {
					System.out.println("\ninvalid input!\n");
				}
				break;
			case 6: //display every contact that has the same name
			System.out.print("Enter first name: ");
			String firstName = input.nextLine();
			System.out.println("");
			
			if(searchByFirstName(firstName) != null) {
				searchByFirstName(firstName).printTree();
			}
			else {
				System.out.println(firstName+" doesn't exist in the contact list!\n");
			}
				break;
			case 7: //display all events alphabetically
				events.printEventList();
				break;
            }
        
        }while(userChoice != 8);
        System.out.println("Goodbye!\n");
    }
 }


