import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Abbreviation {

	// Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
    	String result = "YES";
    	
    	if(a!=null && a.length() > 0 && b!=null && b.length() > 0) {
    		
    		Hashtable<String, Integer> tableB = new Hashtable<String, Integer>();
    		Hashtable<String, Integer> tableA = new Hashtable<String, Integer>();
    		Hashtable<String, Integer> tableANoChange = new Hashtable<String, Integer>();
    		
    		for(Character c : b.toCharArray()) {
    			Integer o = tableB.getOrDefault(c.toString(), 0);
				if(o > 0) {
					tableB.put(c.toString(), o+1);
				}
				else 
				{
					tableB.put(c.toString(), Integer.valueOf(1));
				}
    		}
    		
    		for(Character c : a.toCharArray()) {
    			Integer o = tableA.getOrDefault(c.toString().toUpperCase(), 0);
    			Integer o1 = tableANoChange.getOrDefault(c.toString(), 0);
				if(o > 0) {
					tableA.put(c.toString().toUpperCase(), o+1);
				}
				else 
				{
					tableA.put(c.toString().toUpperCase(), Integer.valueOf(1));
				}
				
				if(o1 > 0) {
					tableANoChange.put(c.toString(), o1+1);
				}
				else 
				{
					tableANoChange.put(c.toString(), Integer.valueOf(1));
				}
    		}
    		
    		for(Character c : b.toCharArray()) {
    			Integer o1 = tableA.getOrDefault(c.toString(), 0);
    			Integer o2 = tableB.getOrDefault(c.toString(), 0);
    			
    			if(o1 < o2) {
    				return result = "NO";
    			}
    		}
    		
    		for(Character c : a.toCharArray()) {
    			if(Character.isUpperCase(c)) {
    				
    				Integer o1 = tableANoChange.getOrDefault(c.toString(), 0);
    				Integer o2 = tableB.getOrDefault(c.toString(), 0);
    				Integer o3 = tableANoChange.getOrDefault(c.toString().toLowerCase(), 0);
    				
    				if(o1!=o2 && o3 <= 0) {
    					return result = "NO";
    				}
    				
    			}
    		}
    		
    	}

    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
