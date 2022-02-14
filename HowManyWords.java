import java.util.StringTokenizer;

public class HowManyWords {
	
	public static int howManyHackerRank(String sentence) {
		int wordCount = 0;
		
		if(sentence == null || sentence.isEmpty()) {
			return wordCount;
		}
		
		String s = new String(sentence);
		
		String inputArr[] = s.split("\\s");
		
		
		
		for(int i=0;i<inputArr.length;i++) {
			if(isStringOnlyAlphabet(inputArr[i].replaceAll("[^a-zA-Z]", ""))) {
				wordCount++;
			}
		}
		
		return wordCount;
		
	}
	
	public static boolean isStringOnlyAlphabet(String str) 
	{
	    return ((!str.equals(""))
	            && (str != null)
	            && (str.matches("^[a-zA-Z]*$")));
	}
	
	public static int howMany(String sentence) {
		   // Spliting the array based on 
        // words starting with dot
        // words starting with space
        // words starting with comma
        // words ending with ?
        // words ending with !
        String arr[] = sentence.split("[. ,?!]+");
        // Count the wrong words
        int wrongWords = 0;
        // For each word
        for(int i = 0; i < arr.length; i++){
            // Iterate the word 
            for(int j = 0; j < arr[i].length(); j++){
                char ch = arr[i].charAt(j);
                // Check if each character is [A-Z], [a-z], -
                if((ch >= 'A' && ch <= 'Z') || 
                    (ch >= 'a' && ch <= 'z') ||
                    (ch == '-')){
                        continue;
                }else{
                    // If no, count this as wrong word
                    wrongWords += 1;
                    break;
                }
            }
        }
        // Return the answer as length - wrong words
        return arr.length - wrongWords;



	}
	
	
	public static void main(String []args) {
		HowManyWords h = new HowManyWords();
		System.out.println(h.howMany("How many eggs are in a half-dozen, 13"));
		System.out.println(h.howMany("he is a good programmer, he won 865 competitions, but sometimes he dont. What do you think? All test-cases should pass. Done-done?"));
	}

}
