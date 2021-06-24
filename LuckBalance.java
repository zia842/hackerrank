import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LuckBalance {
	
	// Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
    	int maxLuckBalance = 0;
    	
    	if(contests!=null && contests.length > 0) {
    		
    		//Decreasing Order flip compare parameters to a, b in case of increasing order
        	Arrays.sort(contests, (a, b) -> Integer.compare(b[0],a[0]));
        	
        	int count = 0;
        	
        	for(int i=0;i<contests.length;i++) {
        		if(contests[i][1] == 0) {
        			maxLuckBalance += contests[i][0];
        		}
        		else 
        		{
        			if(count < k) {
        				maxLuckBalance += contests[i][0];
        				count++;
        			}
        			else 
        			{
        				maxLuckBalance -= contests[i][0];
        			}
        		}
        	}
    	}
    	return maxLuckBalance;

    }
    
    

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
