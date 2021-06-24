import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GreedyFlorist {
	
	// Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
    	int minimumCost = 0;
    	if(c!=null && c.length > 0) {
    		int reversedArr[] = Arrays.stream(c).boxed()
    			    .sorted(Collections.reverseOrder())
    			    .mapToInt(Integer::intValue)
    			    .toArray();
    		for(int i=0;i<reversedArr.length;i++) {
    			minimumCost += ((i/k)+1) * reversedArr[i];
    		}
    	}
    	return minimumCost;
    }
    
    
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
