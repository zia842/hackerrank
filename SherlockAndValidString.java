import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class SherlockAndValidString {
	
	// Complete the isValid function below.
    static String isValid(String s) {
    	
    	String valid = "NO";
    	Hashtable<String,Integer> tableA = new Hashtable<String,Integer>();
    	Hashtable<Integer,Integer> tableB = new Hashtable<Integer,Integer>();
    	
    	if(s!=null && s.length() > 0) {
    		
    		//Count the frequency
    		for(Character c : s.toCharArray()) {
				Integer o = tableA.getOrDefault(c.toString(), 0);
				if(o > 0) {
					tableA.put(c.toString(), o+1);
				}
				else 
				{
					tableA.put(c.toString(), Integer.valueOf(1));
				}
			}
    		
    		Set<String> keys = tableA.keySet();
    		for(String key : keys) {
    			Integer f = tableA.get(key);
    			Integer o = tableB.getOrDefault(f,0);
    			if(f > 0) {
    				tableB.put(f, o+1);
    			}
    			else 
    			{
    				tableB.put(f, Integer.valueOf(1));
    			}
    		}
    		
    		//Max, Min Key
    		Set<Integer> occurenceKeys = tableB.keySet();
    		int max = Collections.max(occurenceKeys);
    		int min = Collections.min(occurenceKeys);
    		
    		if(occurenceKeys.size() > 2) {
    			return valid;
    		}
    		
			if (max - min == 0
					|| (max - min == 1 && tableB.get(max) == 1)  || (min == 1 && tableB.get(min) == 1)) {
    			valid = "YES";
    			return valid;
    		}
    		
    	}
    	
    	return valid;
    }
    

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
