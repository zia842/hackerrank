import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class SpecialStringAgain {
	
	  // Complete the substrCount function below.
      static long substrCountBruteForce(int n, String s) {
    	  long specialStringCount = 0;
    	  
    	  Hashtable<String,Integer> totalSubStrings = calculateSubStringsUnSorted(s);
    	  if(!totalSubStrings.isEmpty() && totalSubStrings.size() > 0) {
    		  Set<String> keys = totalSubStrings.keySet();
    		  for(String key : keys) {
    			  if(key.length() == 1) {
    				  specialStringCount += totalSubStrings.get(key);
    			  }
    			  else if(key.length()%2 == 0) //If Even all characters should be same
    			  {
    				  char[] charArray = new char[key.length()];
    				  Arrays.fill(charArray, key.substring(0,1).toCharArray()[0]);
    				  if(key.equals(String.valueOf(charArray))) {
    					  specialStringCount += totalSubStrings.get(key);
    				  }
    			  }
    			  else //If Odd
    			  {
    				  char[] charArray = new char[key.length()];
    				  int middle = key.length() / 2;
    				  Arrays.fill(charArray, key.substring(0,1).toCharArray()[0]);
    				  charArray[middle] = key.charAt(middle);
    				  if(key.equals(String.valueOf(charArray))) {
    					  specialStringCount += totalSubStrings.get(key);
    				  }
    			  }
    		  }
    	  }
    	  
    	  return specialStringCount;

      }
      static long substrCount(int n, String s) {
    	  long specialStringCount = 0;	
    	  
    	  if(s!=null && s.length() > 0) {
    		  
    		  /**
    		   * Case 1 : aaa or aba.
    		   * This counts number of palindrome's single char e.g. a is considered as palindrome  or aba 
    		   * aaa  -> a a a -> 3 (Triangular)
    		   *         aa    -> 2
    		   *         aaa  ->  1
    		   * Below logic tracks count if all same char's or aba       
    		   */
    		  int i = 0;
    		  while(i < n) { 
    			  
    			  long charCount = 1;
    			  
    			  while(i+1<n && s.charAt(i) == s.charAt(i+1)) {
    				  i++;
    				  charCount++;
    			  }
    			  specialStringCount += (charCount * (charCount+1))/2 ; // (n*n(n+1))/2
    			  
    			  i++;
    		  }
    		  
    		  //TODO: Revisit this logic to gain better understanding
    		  /**
    		   * Case 2 Tracks count only for valid palindrome e.g ; - aba
    		   * count all the neighbour's
    		   */
    		  for(i=1;i<n;i++) {
    			  int charCount = 1;
    			  while(i+charCount < n   // 2 < 3 //Right Boundary
    					  && i-charCount >= 0  // 1-1 >= 0 // Left Boundary
    					  && s.charAt(i-1)!= s.charAt(i) // a!= b  //Current and Previous Char's
    					  && s.charAt(i-1) == s.charAt(i-charCount) // a == a  
    					  && s.charAt(i-1) == s.charAt(i+charCount)) { // a == a compares left and right
    				  charCount++;
    			  }
    			  specialStringCount += charCount - 1;
    		  }
    		  
    	  }
    	  
    	  return specialStringCount;
      }
      
      static long substrCountNotWorking(int n, String s) {
	      long specialStringCount = 0;	
	      
	      if(s!=null && s.length() > 0) {
	    	  
	    	  long leftArr[] = new long[s.length()];
	    	  long rightArr[] = new long[s.length()];
	    	  
	    	  leftArr[0] = 1;
	    	  rightArr[s.length()-1] = 1;
	    	 
	    	  //Left Array
	    	  for(int i=0;i<s.length();i++) {
	    		  
	    		  if(i > 0 && i <= s.length()-1) {
	    			  if(s.charAt(i-1) == s.charAt(i)) {
	    				  leftArr[i] = leftArr[i-1] + 1;
	    			  }
	    			  else 
	    			  {
	    				  leftArr[i]++; 
	    			  }
	    		  }
	    	  }
	    	  
	    	  //Right Array
	    	  int j=0;
	    	  for(int i=s.length()-2;i>=0;i--) {
    			  if(s.charAt(i+1) == s.charAt(i)) {
    				  rightArr[j] = rightArr[j+1] + 1;
    			  }
    			  else 
    			  {
    				  rightArr[j]++; 
    			  }
	    	  }
	    	  
	    	 for(int i=0;i<s.length();i++) {
	    		 specialStringCount++;
	    		 
	    		 if(i>0 && i<s.length()-1) {
	    			 
	    			 if(s.charAt(i-1) == s.charAt(i+1) && s.charAt(i)!=s.charAt(i-1)) {
	    				 specialStringCount += Math.min(leftArr[i], rightArr[i]);
	    			 }
	    			 else if(s.charAt(i)==s.charAt(i-1)) {
	    				 specialStringCount += leftArr[i]-1;
	    			 }
	    		 }
	    		 
	    		 if(i==s.length()-1 && s.charAt(i)==s.charAt(i-1)) {
	    			 specialStringCount += leftArr[i]-1;
	    		 }
	    		 
	    	 }
	      }
	      return specialStringCount;
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

	  private static final Scanner scanner = new Scanner(System.in);

	  public static void main(String[] args) throws IOException {
	      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));
	
		  int n = scanner.nextInt();
		  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		  String s = scanner.nextLine();
		
		  long result = substrCount(n, s);
		
		  bufferedWriter.write(String.valueOf(result));
		  bufferedWriter.newLine();
		
		  bufferedWriter.close();
		
		  scanner.close();
    }

}
