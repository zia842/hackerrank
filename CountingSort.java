import java.util.Arrays;

public class CountingSort {
	
	public static void countSort(int[] arr)
    {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
 
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
 
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
	
	public static void sort(int []arr) {
		
		if(arr!=null && arr.length > 0) {
			
			int maxNumber = Integer.MIN_VALUE; //K
			/**
			 * Find the Maximum Number to calculate the Range
			 */
			for(int i=0;i<arr.length;i++) {
				if(arr[i] > maxNumber) {
					maxNumber = arr[i];
				}
			}
			
			/**
			 * Consider an Count Array which will keep track of Frequency
			 */
			int countArr[] = new int[maxNumber+1];
			for(int i=0;i<arr.length;i++) {
				countArr[arr[i]] += 1;
			}
			
			/**
			 * Sum up the previous number with current 
			 */
			for(int i=1;i<countArr.length;i++) {
				countArr[i] = countArr[i-1] + countArr[i];
			}
			
			/**
			 * Create an new array size of original array
			 * Traverse from Right to Left to maintain stability example 9, 9 although both are same numbers if these were ages of two different people and names were already sorted
			 * Take the current element go to count array decrement by 1 and update the current element in new sorted array
			 */
			
			int[] sorted = new int[arr.length];
			for(int i=arr.length-1;i>=0;i--) {
				int current = arr[i];
				countArr[current] = countArr[current] - 1 ;
				sorted[countArr[current]] = current;
				
			}
			for(int i=0;i<arr.length;i++) {
				arr[i] = sorted[i];
			}
			
		}
		
	}
	
	
	public static void main(String []args) {
	    int[] input = {4, 3, 2, 5, 4, 3, 5, 1, 0, 2, 5};
	    
	    sort(input);
	    for(int i : input) {
	    	System.out.println(i);
	    }
	    
	    int[] input2 = {41, 3, 2, 5, 4, 3, 51, 1, 0, 2, 5};
	    System.out.println("Sorting Input 2");
	    sort(input2);
	    for(int i : input2) {
	    	System.out.println(i);
	    }
	    
	}

}
