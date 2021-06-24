import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TripleSum {
	
	// Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {

    	long tripletCount = 0;
    	
    	//Eliminate Duplicate
    	int []duplicateRemovedA = eliminateDuplicate(a);
    	int []duplicateRemovedB = eliminateDuplicate(b);
    	int []duplicateRemovedC = eliminateDuplicate(c);
    	
    	Arrays.sort(duplicateRemovedA);
    	Arrays.sort(duplicateRemovedB);
    	Arrays.sort(duplicateRemovedC);
    	
    	for(int i=0;i<duplicateRemovedB.length;i++) {
    		
    		long a1 = binarySearch(duplicateRemovedA, duplicateRemovedB[i]) + 1;
    		long c1 = binarySearch(duplicateRemovedC, duplicateRemovedB[i]) + 1;
    		
    		tripletCount += a1  * c1;
    	}
    	
    	
    	return tripletCount;

    }
    
    /**
     * Both of this 2 binary search method works goal here is to count the numbers which are less then or equal mentioned key. It does not matter key is present or not
     * 
     * e.g Key 2 | arr -> 1, 2, 3 Here outcome is 2. There are 2 numbers 1,2 which are less than or equal to 
     * e.g Key 2 | arr -> 1, 3, 5 Here outcome is 1. Although key 2 does not exist there is 1(1) number which is <= key
     * 
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearchD(int []arr, int key) {
		int index = -1; //If Key not found will work for -ve numbers also
		
		if(arr!=null && arr.length > 0) {
			
			int low = 0;
			int high = arr.length-1;
			
			while(low <= high) {
				
				int mid = (high + low)/2;
				
				if(key == arr[mid]) { //Key found 
					return mid;
				}
				else if(key < arr[mid]) { // Search Key Left Side of Array
					high = mid - 1;
				}
				else  //Search Key Right Side of Array
				{
					index = mid;
					low = mid + 1;
				}
				
			}
		}
		return index;
	}
    
    public static int binarySearch(int []arr, int key) {
		int index = -1; //If Key not found will work for -ve numbers also
		
		if(arr!=null && arr.length > 0) {
			
			int low = 0;
			int high = arr.length-1;
			
			while(low <= high) {
				
				int mid = low + (high - low)/2;
				
				if(arr[mid] <= key) {
					index = mid;
					low = mid + 1;
				}
				else 
				{
					high = mid - 1;
				}
			}
		}
		
		return index;
	}
    
    
    public static int[] eliminateDuplicate(int []array) {
    	if(array!=null && array.length > 0) {
    		Set<Integer> set = new HashSet<Integer>();
    		
    		for(int i=0;i<array.length;i++) {
    			set.add(Integer.valueOf(array[i]));
    		}
    		
    		int []result = new int[set.size()];
    		int i = 0;
    		for(int item : set) {
    			result[i++] = item;
    		} 
    		
    		return result;
    		
    	}
    	
    	return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
