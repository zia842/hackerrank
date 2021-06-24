import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

	// Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
    	int minimumUnFairness = Integer.MAX_VALUE;
    	if(arr!=null && arr.length > 0) {
    		Arrays.sort(arr);
    		int j = k;
    		for(int i=0;j-1<arr.length;i++) {
    			minimumUnFairness = Math.min(arr[j-1] - arr[i], minimumUnFairness);
    			j++;
    		}
    	}
    	return minimumUnFairness;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
