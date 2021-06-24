import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {
	
	
	/**
	 * Calculate largest area 
	 * Array h contains heights of a building 
	 * @param h
	 * @return
	 */
	static long largestRectangle(int[] h) {
		long area = 0;
		Stack<Integer> s1 = new Stack<Integer>();
		int i;
		for(i=0;i<h.length;) {
			
			//If Stack is Empty or current element in h[] > element at top of stack then push
			if(s1.isEmpty() || (!s1.isEmpty() && h[s1.peek()] <= h[i])) {
				s1.push(i); //Push only Index
				i++; //Increment index only after its pushed in stack
			}
			else 
			{
				int top = s1.pop();
				if(s1.isEmpty()) {
					area = Math.max(area, h[top] * i);
				}
				else 
				{
					area = Math.max(area, h[top] * (i-s1.peek() - 1));
				}
				
			}
			
		}
		while(!s1.isEmpty()) {
			int top = s1.pop();
			if(s1.isEmpty()) {
				area = Math.max(area, h[top] * i);
			}
			else 
			{
				area = Math.max(area, h[top] * (i-s1.peek() - 1));
			}
			
		}
		return area;
    }
	
	static long largestRectangleTwo(int[] h) {
		long area = 0;
		Stack<Integer> s1 = new Stack<Integer>();
		int i;
		
		for(i=0;i<h.length;i++) {
			if(s1.isEmpty() || (!s1.isEmpty() && h[s1.peek()] <= h[i])) {
				s1.push(i); //Push only Index
			}
			else 
			{
				while(!s1.isEmpty()) {
					int top = s1.pop();
					if(s1.isEmpty()) {
						area = Math.max(area, h[top] * i);
					}
					else 
					{
						area = Math.max(area, h[top] * (i-s1.peek() - 1));
					}
				}
			}
		}
		
		while(!s1.isEmpty()) {
			int top = s1.pop();
			if(s1.isEmpty()) {
				area = Math.max(area, h[top] * i);
			}
			else 
			{
				area = Math.max(area, h[top] * (i-s1.peek() - 1));
			}
			
		}
		return area;
	}		
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangleTwo(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
