
public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomStack s = new CustomStack();
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		
		System.out.println("Top item on Stack is " + s.peek());
		
		s.pop();
		
		System.out.println("Top item on Stack is " + s.peek());
		
		System.out.println(s.isEmpty());

	}

}
