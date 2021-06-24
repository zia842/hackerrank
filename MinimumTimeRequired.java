import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumTimeRequired {
	
	 // Complete the minTime function below.
    static long minTimeBruteForce(long[] machines, long goal) {
    	long numberOfDays = 0;
    	long goalReached = 0;
    	
    	if(machines!=null && machines.length > 0) {
    		numberOfDays = 1;
    		while(goalReached <= goal) {
    			for(long l=0;l<machines.length;l++) {
    				goalReached += numberOfDays / machines[(int)l];
    				if(goalReached == goal) {
        				return numberOfDays;
        			}
    			}
    			numberOfDays++;
    			goalReached = 0;
    		}
    	}

    	return numberOfDays;
    }
    
    static long minTime(long[] machines, long goal) {
    	long numberOfDays = 0;
    	long goalReached = 0;
    	long minTime = 1;
    	if(machines!=null && machines.length > 0) {
    		
    		//Assumption machines are sorted
    		
    		long maxTime = machines[machines.length-1] * goal;
    		
    		while(minTime != maxTime) {
    			
    			goalReached = 0;
    			numberOfDays = (maxTime + minTime) / 2;
    			
    			for(long l=0;l<machines.length;l++) {
    				goalReached += numberOfDays / machines[(int)l];
    			}
    			
    			if(goalReached >= goal) {
    				maxTime = numberOfDays;
    			}
    			else 
    			{
    				minTime = numberOfDays + 1;
    			}
    			
    		}
    	}
    	return minTime;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
