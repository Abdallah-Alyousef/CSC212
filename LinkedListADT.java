public class LinkedListADT<T>{
	
	 private Node<T> head;
	 private Node<T> current;
	 
	    public LinkedListADT() {
	        head = current = null;
	    }

	    public boolean empty() {
	        return head == null;
	    }

	    public boolean last() {
	        return current.next == null;
	    }

	    public boolean full() {
	        return false;
	    }

	    public void findFirst() {
	        current = head;
	    }

	    public void findNext() {
	        current = current.next;
	    }

	    public T retrieve() {
	        return current.data;
	    }

	    public void update (T val) {
	        current.data = val;
	    }

	    //This method will Delete the selected Contact n
	    public void deleteCont(T n){
	        current = head;
	        Node<T> temp = head;

	        //if there's no elements in the List
	        if(empty()) {
	            System.out.print("There's no contact at all!");
	            return;
	        }

	        //if there's only one element in the List
	        if(head.data.equals(n) && head.next == null) {
	            head = current = null;
	            return;
	        }

			//if there's more than one element and we want to delete the head
			if(head.data.equals(n)){
				head = head.next;
				//current = head;
				return;
			}

	        //We will go through the List till we find the contact that we want to delete
	        while(!last()) {
	            if(current.data.equals(n)){
	                break;
				}
	            current = current.next;
	        }
	        //Then temp will also go through the List till it locates before the current
	        while(temp.next != current) {  
	            temp = temp.next;
	        }
	        temp.next = current.next;
	        current = head;
	    }
		
	    public void deleteEvents() {
			head = current = null;
		}
		
		//For searching for contact then return true if it's there and false if not
	    public boolean search(T val){
	    	
	        if(empty() || val == null) {
	            return false;
	         }
	    //goes through the list till current in the end
	        current = head;
	        if(current.data.equals(val)) {
	        	return true;
	        }
	        
	        while(current!=null) {
	        	if(current.data.equals(val))
	        		return true;
						else
							current = current.next;
					}	
				return false;
	  	}

		//To print or display the elements of the list "if needed"
		public void printList() {
		 Node<T> temp = head;
		 while(temp!=null) {
			 ((Contact)temp.data).printContact();
			 temp = temp.next;
		 	}
	 	}

		public void printEventList() {
		 Node<T> temp = head;
		 while(temp!=null) {
			 System.out.println(((Event)temp.data).toString());
			 temp = temp.next;
		 	}
	 	}

	 
		public String toString(LinkedListADT<T> l) {
				return (String)l.retrieve();
		}
	
		//Adding contact with sorted
	 	// public void addSorted(T val){
		// 	Node<T> p = new Node<T>(val);

		// 	//Checking if the list id empty
		// 	if(empty()){
		// 		head = current = p;
		// 	}

		// 	//if we want to add it at first
		// 	if(((Contact)val).compareTo((Contact)head.data)<0){
		// 		p.next = head;
		// 		head = p;
		// 		return;
		// 	}

		// 	//Add the contact at the correct position
		// 	else{
		// 		Node<T> q=head, z=null;
		// 		while(q != null && (((Contact)q.data).compareTo((Contact)val) <= 0)){
		// 			z=q;
		// 			q=q.next;
		// 		}
		// 		//Adding after finding the correct position
		// 		z.next = p;
		// 		p.next = q;
		// 	}
		// }

		//Adding event with sorted
		public void addEventSorted(T val){
			Node<T> p = new Node<T>(val);

			//Checking if the list id empty
			if(empty()){
				head = current = p;
			}

			//if we want to add it at first
			if(((Event)val).compareTo((Event)head.data)<0){
				p.next = head;
				head = p;
				return;
			}

			//Add the event at the correct position
			else{
				Node<T> q=head, z=null;
				while(q != null && (((Event)q.data).compareTo((Event)val) <= 0)){
					z=q;
					q=q.next;
				}
				//Adding after finding the correct position
				z.next = p;
				p.next = q;
			}
		}
}

   