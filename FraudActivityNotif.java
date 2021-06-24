import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FraudActivityNotif {
	
	// Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int notificationCount = 0;
        
        if(expenditure!=null && expenditure.length > 0) {
            
            for(int i=0;i<expenditure.length;i++) {
                
                if(i < d) { //Skip if least number of trailing days not met
                    continue;
                }
                
                //Here i will be 3 
                
                int end = i; //2
                int start = i-d; //Starting position 3-3 = 0
                
                /**
                 * Do not sort the entire array. Sort is needed only for number of trailing days.
                 * If entire array is sorted it will get disturbed
                 */
                
                //Arrays.sort(expenditure, start, end); 
               // sort(expenditure, start, end);
                int []copyExpenditure = Arrays.copyOfRange(expenditure, start, end);
                double median = getMedian(copyExpenditure);
                
                /*double median = 0;
                int n = (start+1+end)/2;
                //TODO: Validate if this is true in case of start is not 0
                if((start+1+end)%2 == 0) //If Even Number median is sum of two middle values / 2
                { 
                    median = (expenditure[n] + expenditure[n+1]) / 2; 
                }
                else 
                {
                    median = expenditure[n];
                } */
                
                if(expenditure[i] >= (2*median)) {
                    notificationCount = notificationCount + 1;
                }
            }
            
        }
        
        return notificationCount;

    }
    
    public static void copySortedArray(int []expenditure, int []copyExpenditure, int start, int end) {
    	int j=0;
    	while(start < end) {
    		expenditure[start] = copyExpenditure[j];
    		start++;
    		j++;
    	}
    }
    
    public static double getMedian(int[] arr) {
    	double median = 0;
    	if(arr!=null && arr.length > 0) {
    		countSort(arr);
    		int n = arr.length;
    		if(n%2 == 0) //If Even Number median is sum of two middle values / 2
            { 
                median = (double)(arr[n/2] + arr[((n-1)/2)]) / 2; 
            }
            else 
            {
                median = (double)arr[(n-1)/2];
            }
    	}
    	return median;
    }
    
    
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
    
    static int activityNotifications2(int[] expenditure, int d) {
    	int notificationCount = 0;
    	int []countArr = new int[201];
    	
    	for (int i = 0; i < d; i++) {
    	    countArr[expenditure[i]]++;
    	}
    	
    	
    	for (int i = d; i < expenditure.length; i++) {
		    
    		double medianx2 = getMedianx2(countArr, d);
		    
		    if (expenditure[i] >= medianx2) 
		    	notificationCount++;
		    
		    if (i == expenditure.length - 1) 
		    	break;
		    
		    countArr[expenditure[i - d]]--;
		    countArr[expenditure[i]]++;
    	}
    	
    	return notificationCount;
    }
    
    public static double getMedianx2(int[] countArr, int days) {
    	int sum = 0;
    	for (int i = 0; i < countArr.length; i++) {
    		sum += countArr[i];
    		if (sum * 2 == days) 
    			return (double)(i * 2 + 1); //Even
    		if (sum * 2 > days) 
    			return (double)(i * 2);  //Odd
    	}
    	return 0.0;
    }
    
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications2(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }


}
