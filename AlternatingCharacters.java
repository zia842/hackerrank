import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {
	
	// Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
    	int count = 0;
    	if(s!=null && s.length() > 0) {
    		char cArr[] = s.toCharArray();
    		char previousChar = cArr[0]; //Initial Character
    		
    		for(int i=1;i<cArr.length;i++) {
    			if(previousChar == cArr[i]) {
    				count = count + 1;
    			}
    			else 
    			{
    				previousChar = cArr[i];
    			}
    		}
    		
    		
    	}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
	
}
