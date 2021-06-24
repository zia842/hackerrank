
public class TestQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue queue = new Queue();
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		
		System.out.println("First item in Queue is " + queue.peek());
		
		queue.remove();
		
		System.out.println("First item in Queue is " + queue.peek());
		
		System.out.println(queue.isEmpty());
		
	}

}
