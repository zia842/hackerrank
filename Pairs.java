import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Pairs {
	
	// Complete the pairs function below.
    static int pairs(int k, int[] arr) {
    	int result = 0;
    	Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
    	
    	for(int i=0;i<arr.length;i++) {
    		table.put(arr[i], Integer.valueOf(i));
    	}
    	
    	for(int i=0;i<arr.length;i++) {
    		if(table.get(k+arr[i])!=null && table.containsKey(k+arr[i])) {
    			result++;
    		}
    	}
 	
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
