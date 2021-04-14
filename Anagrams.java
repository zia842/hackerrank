import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class Anagrams {
	
	static int makeAnagram(String a, String b) {
		int anagramCount = 0;
		
		Hashtable<String,Integer> tableA = new Hashtable<String,Integer>();
		Hashtable<String,Integer> tableB = new Hashtable<String,Integer>();
		
		if(a!=null && a.length() > 0) {
			for(Character c : a.toCharArray()) {
				Integer o = tableA.getOrDefault(c.toString(), 0);
				if(o > 0) {
					tableA.put(c.toString(), o+1);
				}
				else 
				{
					tableA.put(c.toString(), Integer.valueOf(1));
				}
			}
		}
		
		if(b!=null && b.length() > 0) {
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
		}
		
		if(a!=null && a.length() > 0) {
			Set<String> keys = tableA.keySet();
			for(String key: keys){
				anagramCount += Math.abs(tableA.get(key) - tableB.getOrDefault(key, 0));
			}
		}
		
		if(b!=null && b.length() > 0) {
			Set<String> keys = tableB.keySet();
			for(String key: keys){
				if(!tableA.containsKey(key)) {
					anagramCount += tableB.get(key);
				}
			}
		}
		return anagramCount;
    }

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
