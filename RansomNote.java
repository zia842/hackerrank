import java.util.Hashtable;
import java.util.Scanner;

public class RansomNote {
	
	public RansomNote(){
		super();
	}
	
	static void checkMagazine(String[] magazine, String[] note) {

		Hashtable<String, Integer> magazineTable = new Hashtable<String, Integer>(); 
		
		if(magazine!=null && magazine.length > 0) {
			
			for(String s : magazine) {
				if(magazineTable.containsKey(s)) {
					Integer count = magazineTable.get(s);
					count = count + 1;
					magazineTable.put(s, Integer.valueOf(count));
				}
				else 
				{
					magazineTable.put(s, Integer.valueOf(1));
				}
			}
			
		}
		
		if(note!=null && note.length > 0) {
			
			boolean doesNotExist = false;
			for(String s : note) {
				if(magazineTable.containsKey(s)) {
					Integer count = magazineTable.get(s);
					if(count > 0) 
					{
						count = count - 1;
						magazineTable.put(s, Integer.valueOf(count));
					}
					else 
					{
						System.out.println("No");
						doesNotExist = true;
						break;
					}
				}
				else 
				{
					System.out.println("No");
					doesNotExist = true;
					break;
				}
			}
			
			if(!doesNotExist) {
				System.out.println("Yes");
			}
			
		}

    }
	
	static boolean canConstructLetter(String text, String note) {

		Hashtable<Character, Integer> magazineTable = new Hashtable<Character, Integer>(); 
		
		if(text!=null && text.length() > 0) {
			
			for(Character s : text.toCharArray()) {
				if(magazineTable.containsKey(s)) {
					Integer count = magazineTable.get(s);
					count = count + 1;
					magazineTable.put(s, Integer.valueOf(count));
				}
				else 
				{
					magazineTable.put(s, Integer.valueOf(1));
				}
			}
			
		}
		
		if(note!=null && note.length() > 0) {
			
			boolean doesNotExist = false;
			for(Character s : note.toCharArray()) {
				if(magazineTable.containsKey(s)) {
					Integer count = magazineTable.get(s);
					if(count > 0) 
					{
						count = count - 1;
						magazineTable.put(s, Integer.valueOf(count));
					}
					else 
					{
						//System.out.println("No");
						//doesNotExist = true;
						//break;
						return false;
					}
				}
				else 
				{
					//System.out.println("No");
					//doesNotExist = true;
					//break;
					return false;
				}
			}
			
			if(!doesNotExist) {
				//System.out.println("Yes");
				return true;
			}
			
		}
		
		return true;

    }
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
	

}
