
public class LinkList {
	
	Node head;
	
	
	public void insert(int data) {
		//Create New Node
		Node node = new Node();
		node.data = data;
		
		if(head == null) { //If Head or Root Node is Null assign created node first node is treated as head
			head = node;
		}
		else 
		{
			Node n = head; //Get the Head 
			while(n.next!=null) { //Traverse Node until last node
				n = n.next;
			}
			n.next = node; //Assign the Node
			
		}
	}
	
	public void show() {
		Node n = head; //Get the Head 
		while(n.next!=null) { //Traverse Node until last node
			System.out.println("Node Value is " + n.data);
			n = n.next;
		}
		System.out.println("Node Value is " + n.data);
	}
	

}
