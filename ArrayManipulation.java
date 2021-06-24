import java.util.Scanner;

public class ArrayManipulation {
	
	/**
	 * 
	 * @param n
	 * @param queries
	 * @return
	 */
	static long arrayManipulation(int n, int[][] queries) {
		
		long maxSum = Long.MIN_VALUE;
		
		if(queries!=null && queries.length > 0) {
			
			//int [][]output = new int[queries.length][n+2];
			
			long []op = new long[n+2];
			
			
			for(int i=0;i<queries.length;i++) { //Number of Rows
				int a = queries[i][0];
				int b = queries[i][1];
				int k = queries[i][2];
				
				//output[i][a] = k;
				//output[i][b+1] = -k;
				
				op[a] +=  k;
				op[b+1] += -k; 
			}
			
			for(int i=1;i<op.length;i++) {
				op[i] = op[i] + op[i-1];
				if(op[i] > maxSum) {
					maxSum = op[i];
				}
			}
			/*long sum = 0;
			for(int i=1;i<n+2;i++) {
				
				
				int row = 0;
				
				while(row < queries.length) {
					sum = sum + output[row][i];
					row++;
				}
				
				if(sum > maxSum) {
					maxSum = sum;
				}
			}*/
		}
		return maxSum;
    }
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String []args) {
		
		String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }
        System.out.println(arrayManipulation(n, queries));
		
	}

}
