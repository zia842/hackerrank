import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStack {

	public static class MyQueue<Integer> 
	{
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		public void enqueue(Integer value) { // Push onto newest stack
			s1.push(value);
		}

		public Integer peek() {
			if(s2.isEmpty()) {
				while(!s1.isEmpty()) {
					s2.push(s1.pop());
				}
			}
			
			Integer data = (Integer)s2.peek();
			return data;
		}

		public Integer dequeue() {
			if(s2.isEmpty()) {
				while(!s1.isEmpty()) {
					s2.push(s1.pop());
				}
			}
			
			Integer data = (Integer)s2.pop();
			return data;
		}
	}


	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek() + "\n");
			}
		}
		scan.close();
	}

}
