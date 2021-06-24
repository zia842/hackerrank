import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReverseShuffleMerge {
	
	//TODO: Fix this code
	// Complete the reverseShuffleMerge function below.
    static String reverseShuffleMergeNotWorking(String s) {
    	StringBuilder result = new StringBuilder();
    	
    	int unUsedArr[] = new int [26];
    	int usedArr[]   = new int [26];
    	int requiredArr[] = new int [26];
    	
    	if(s!=null && s.length() > 0) {
    		
    		//Frequency of characters
    		for(char c : s.toCharArray()) {
    			unUsedArr[c-'a']++;
    		}
    		
    		//Required characters are half of Un-Used/Actual String
    		for(int i=0;i<unUsedArr.length;i++) {
    			requiredArr[i] = unUsedArr[i]/2;
    		}
    		
    		//Iterate Right to Left
    		for(int i=s.length()-1;i>=0;i--) {
    			
    			if(usedArr[s.charAt(i)-'a'] < requiredArr[s.charAt(i)-'a']) {
    				
    				if(result.length() > 0 && s.charAt(i)-'a' < result.charAt(result.length()-1)-'a') {
    					
    					int j = result.length()-1;
    					while(j >= 0 && s.charAt(i)-'a' < result.charAt(j)-'a') {
    						//usedArr[s.charAt(i-1)-'a']--;
    						usedArr[result.charAt(j)-'a']--;
    						result.deleteCharAt(j);
        					j--;
    					}
    					usedArr[s.charAt(i)-'a']++;
        				result.append(s.charAt(i));
    					
    				}
    				else	//Big Char 
    				{
    					usedArr[s.charAt(i)-'a']++;
        				result.append(s.charAt(i));
    				}
    				
    				
    			}
    			unUsedArr[s.charAt(i)-'a']--;
    		}
    	}
    	return result.toString();
    }
    
    static String reverseShuffleMerge(String str) {
    	
    	StringBuilder result = new StringBuilder(); 
    	
    	int unused[]=new int [26];
        int used[]=new int [26];
        int required[]=new int [26];
        char res[] = new char[100000];
        int j=0;
        int n= str.length();
        
        //filling array mapping char freq
        for(int i=0; i<n; i++)
        {
            unused[str.charAt(i)-'a']++;
        }
        
        for(int i=0; i<26; i++)
        {
            required[i]= unused[i]/2;
        }
        
        // last character
        char ch = str.charAt(n-1);
        int ch_position = ch-'a'; // index present in above arrays
        res[j++]=ch;
        unused[ch_position]--;
        used[ch_position]++;
        
        //rest of char 
        //add ---- req is smaller than pres
        // ch smaller 
        //ch bigger
       
        for(int i=n-2 ; i>=0; i--)
        {
        	ch =str.charAt(i);
            ch_position = ch-'a';
            
            // to add or not 
            if(used[ch_position]< required[ch_position])
            {
                //add char
                if(ch>res[j-1])
                {
                    res[j++]=ch;
                    unused[ch_position]--;
                    used[ch_position]++;
                }
                else{
                    //check bigger ele -- we re
                    //pop 

                    while(j>0 && ch<res[j-1] && used[res[j-1]-'a']-1 + unused[res[j-1]-'a']>= required[res[j-1]-'a'])
                    {
                        used[res[--j]-'a']--;
                    }
                    res[j++]=ch;
                    unused[ch_position]--;
                    used[ch_position]++;
                }
            }
            else
            {// rejecting / discarding the perticulr char
                unused[ch_position]--;
            }
            
        }
        
        for(int i=0; i<n/2; i++)
        {
        	result.append(res[i]);
        }
        
        return result.toString();
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
