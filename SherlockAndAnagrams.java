import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;

public class SherlockAndAnagrams {
	
	// Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	int count = 0;
    	Hashtable<String, Integer> table = calculateSubStrings(s);
    	
    	if(table!=null && !table.isEmpty()) {
    		Iterator<String> itr = table.keySet().iterator();
    		while(itr.hasNext()){
    			int keyValue = table.get(itr.next());
    			keyValue = (keyValue * (keyValue -1))/2;
    		    count = keyValue + count;
    		}
    	}
    	
    	return count;
    }
    
    /**
     * Calculates the Sub Strings, sorts it and keeps track of length 
     * abcd 
     * a	b	c	d
     * ab	bc	cd
     * abc	bcd 
     *
     * @param s
     * @return
     */
    
    public static Hashtable<String, Integer> calculateSubStrings(final String s) {
    	Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    	if(s!=null && s.length() > 0) {
    		for(int i=0;i<s.length();i++) {
    			int start = 0;
    			int end = start + (i+1);
    			while(end <= s.length()) {
        			String c = sortString(s.substring(start, end));
        			if(table.containsKey(c)) {
        				Integer count = table.get(c);
        				count = count + 1;
        				table.put(c, count);
        			}
        			else
        			{
        				table.put(c, Integer.valueOf(1));
        			}
        			
        			start = start + 1;
        			end = start + (i+1);
        		}
    		}
    	}
    	return table;
    }
    
    public static Hashtable<String, Integer> calculateSubStringsUnSorted(final String s) {
    	Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    	if(s!=null && s.length() > 0) {
    		for(int i=0;i<s.length();i++) {
    			int start = 0;
    			int end = start + (i+1);
    			while(end <= s.length()) {
        			String c = s.substring(start, end);
        			if(table.containsKey(c)) {
        				Integer count = table.get(c);
        				count = count + 1;
        				table.put(c, count);
        			}
        			else
        			{
        				table.put(c, Integer.valueOf(1));
        			}
        			
        			start = start + 1;
        			end = start + (i+1);
        		}
    		}
    	}
    	return table;
    }
    
    public static String sortString(final String s) 
    { 
        char tempArray[] = s.toCharArray(); 
        Arrays.sort(tempArray); 
        return new String(tempArray); 
    } 
    
	
	public static void main(String []args) {
		System.out.println(sherlockAndAnagrams("mom"));
		System.out.println(sherlockAndAnagrams("abba"));
		System.out.println(sherlockAndAnagrams("abcd"));
		System.out.println(sherlockAndAnagrams("ifailuhkqq"));
		System.out.println(sherlockAndAnagrams("kkkk"));
		System.out.println(sherlockAndAnagrams("cdcd"));
		System.out.println(calculateSubStringsUnSorted("asasd"));
		System.out.println(calculateSubStringsUnSorted("mnonopoo"));
		
	}

}
