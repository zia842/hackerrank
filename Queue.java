
public class Queue {
	
	public static class Node {
		
		private int data;
		private Node next;
		
		private Node(int data) {
			this.data = data;
		}
	}

	
	private Node head; //Remove things from here
	private Node tail; //Add things at last
	
	public boolean isEmpty() {
		return head == null; // If head is null
	}
	
	public int peek() {
		return head.data;
	}
	
	public void add(int data) {
		
		Node node = new Node(data); // Create a new node
		//If Tail is not empty point tail.next to node
		if(tail!=null) {
			tail.next = node;
		}
		tail = node;  //This will get executed regardless tail is empty or not. If empty first item will be at tail 
		
		if(head == null) { //If empty assign node to head. In this case both head and tail are pointing to same node
			head = node;
		}
	}
	
	public int remove() {
		int data = head.data; //Copy
		head = head.next; //Remove Data from Head & Move head.next to next node
		if(head == null) {
			tail = null;
		}
		return data;
	}
	
	
	
}
