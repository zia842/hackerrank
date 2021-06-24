import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class TwoStrings {
	
	final static String YES = "YES";
	final static String NO  = "NO";
	// Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	
    	Hashtable<String, Integer> tableOne = new Hashtable<String, Integer>(); 
    	Hashtable<String, Integer> tableTwo = new Hashtable<String, Integer>(); 
    	
    	String [] strArry = {s1,s2};
    	
    	if(strArry!=null && strArry.length > 0) {
    		
    		for(int i=0;i<strArry.length;i++) {
    			char []charOne = strArry[i].toCharArray();
    			for(char c : charOne) {
    				if(i == 0) {
    					if(tableOne.containsKey(String.valueOf(c))) {
            				Integer count = tableOne.get(String.valueOf(c));
            				count = count + 1;
            				tableOne.put(String.valueOf(c), count);
            			}
            			else
            			{
            				tableOne.put(String.valueOf(c), Integer.valueOf(1));
            			}
    				}
    				else
    				{
    					if(tableTwo.containsKey(String.valueOf(c))) {
            				Integer count = tableTwo.get(String.valueOf(c));
            				count = count + 1;
            				tableTwo.put(String.valueOf(c), count);
            			}
            			else
            			{
            				tableTwo.put(String.valueOf(c), Integer.valueOf(1));
            			}
    				}
    				
    			}
    		}
    		
    		for(int i=0;i<strArry.length;i++) {
    			char []charOne = strArry[i].toCharArray();
    			for(char c : charOne) {
    				if(tableOne.containsKey(String.valueOf(c)) && tableTwo.containsKey(String.valueOf(c))) {
    					return YES;
    				}
    			}
    		}
    	}
    	
    	return NO;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       /* BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();*/
    	
    	System.out.println(twoStrings("hello", "world"));
    	System.out.println(twoStrings("hi", "world"));
    	System.out.println(twoStrings("and", "art"));
    	System.out.println(twoStrings("be", "cat"));
    }

}
