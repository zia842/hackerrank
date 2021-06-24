import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Candies {
	
	// Complete the candies function below.
    static long candies(int n, int[] arr) {
        long maxCandies = 0;
        int leftResultArr[] = new int[arr.length];
        int rightResultArr[] = new int[arr.length];
        if(arr!=null && arr.length > 0){
            
        	leftResultArr[0] = 1; //Base Initialization
        	rightResultArr[arr.length-1] = 1;
            //maxCandies = 1;
            
            for(int i=1;i<arr.length;i++){
                
                if(arr[i] > arr[i-1]){ //If Current Rating is > Previous Rating
                	leftResultArr[i] = leftResultArr[i-1] + 1; //Increase 1 Candy to the previous 
                }
                else
                {
                	leftResultArr[i] = 1;   
                }
                //maxCandies += resultArr[i]; //Store the count
            }
            
            for(int i=arr.length-2;i>=0;i--) {
            	if(arr[i] > arr[i+1]){ //If Current Rating is > Previous Rating
            		rightResultArr[i] = rightResultArr[i+1] + 1; //Increase 1 Candy to the previous 
                }
                else
                {
                	rightResultArr[i] = 1;   
                }
            }
            
            for(int i=0;i<arr.length;i++){
            	maxCandies += Math.max(leftResultArr[i], rightResultArr[i]);
            }
            
            
        }
        return maxCandies;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
