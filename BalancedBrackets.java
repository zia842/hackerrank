import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	
	final public static String LEFT_CURLY_BRACKET = "{";
	final public static String LEFT_SQUARE_BRACKET = "[";
	final public static String LEFT_BRACKET = "(";
	
	final public static String RIGHT_CURLY_BRACKET = "}";
	final public static String RIGHT_SQUARE_BRACKET = "]";
	final public static String RIGHT_BRACKET = ")";

	// Complete the isBalanced function below.
    static String isBalanced(String s) {
    	String result = "NO";
    	if(s!=null && s.length() > 0) {
    		
    		s = s.trim();
    		Stack<String> stack = new Stack<String>();
    		
    		for(Character c : s.toCharArray()) {
    			if(LEFT_CURLY_BRACKET.equals(c.toString()) || LEFT_SQUARE_BRACKET.equals(c.toString()) || LEFT_BRACKET.equals(c.toString())) {
    				stack.push(c.toString());
    			}
    			else if(!stack.isEmpty() 
    					&& stack.size() > 0 
    					&&  ((LEFT_CURLY_BRACKET.equals(stack.peek()) && RIGHT_CURLY_BRACKET.equals(c.toString())) 
    					|| (LEFT_SQUARE_BRACKET.equals(stack.peek()) && RIGHT_SQUARE_BRACKET.equals(c.toString()))
						|| (LEFT_BRACKET.equals(stack.peek()) && RIGHT_BRACKET.equals(c.toString())))) 
    			{
    					stack.pop();
    			}
    			else 
    			{
    				stack.push(c.toString());
    			}
    		}
    		if(stack.isEmpty()) {
    			result = "YES";
    		}
    	}
    	return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
	
}
