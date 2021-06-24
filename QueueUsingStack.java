import java.util.*;

public class QueueUsingStack {
	
	static Stack<Integer> s1 = new Stack<Integer>(); 
    static Stack<Integer> s2 = new Stack<Integer>(); 
    
    
    public static void enQueue(int data) 
    {
    	while(!s1.isEmpty()) {
    		s2.push(s1.pop());
    	}
    	
    	s1.push(data);
    	
    	while(!s2.isEmpty()) {
    		s1.push(s2.pop());
    	}
    }
    
    public static int deQueue() {
    	int x = s1.peek();
    	s1.pop();
    	return x;
    }
    
    public static void main(String []args) {
    	QueueUsingStack q = new QueueUsingStack();
    	q.enQueue(1);
    	q.enQueue(2);
    	q.enQueue(3);
    	q.enQueue(4);
    	
    	System.out.println("First Stack Peek " + s1.peek());
    	//System.out.println("Second Stack Peek " + s2.peek());
    }

}
