import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinAbsoluteDiff {
	
	// Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifferenceBruteForce(int[] arr) {
    	int minAbsoluteDif = Integer.MAX_VALUE;
    	if(arr!=null && arr.length > 0) {
    		for(int i=0;i<arr.length;i++) {
    			for(int j=i+1;j<arr.length;j++) {
    				int diff = Math.abs(arr[i]-arr[j]);
    				if(diff < minAbsoluteDif) {
    					minAbsoluteDif = diff;
    				}
    			}
    			
    		}
    	}
    	return minAbsoluteDif;
    }
    
    static int minimumAbsoluteDifference(int[] arr) {
    	int minAbsoluteDif = Integer.MAX_VALUE;
    	if(arr!=null && arr.length > 0) {
    		Arrays.sort(arr);
    		for(int i=0;i+1<arr.length;i++) {
    			int diff = Math.abs(arr[i]-arr[i+1]);
    			if(diff < minAbsoluteDif) {
					minAbsoluteDif = diff;
				}
    		}
    	}
    	
    	return minAbsoluteDif;
    }
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
