import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class IceCreamParlor {

	// Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
    	
    	if(cost!=null && cost.length > 0) {
    		
    		Hashtable<Integer, List> table = new Hashtable<Integer, List>(); 
    		for(int i=0;i<cost.length;i++) {
    			List<Integer> indexList = table.get(cost[i]);
    			
    			if(indexList == null) {
    				indexList = new ArrayList<Integer>();
    			}
    			
    			indexList.add(i);
				table.put(cost[i], indexList);
    		}
    		
    		for(int i=0;i<cost.length;i++) {
    			
    			List<Integer> indexList = table.get(money-cost[i]);	
    			if(indexList!=null && indexList.size() > 0) {
    				
    				if(indexList.size() > 1 && i!= indexList.get(1)) {
    					System.out.println(indexList.get(0)+1 +" " + (indexList.get(1) + 1));
    					break;
    				}
    				if(i!= indexList.get(0)) {
    					System.out.println(i+1+" " + (indexList.get(0)+1));
        				break;
    				}
    				
    			}
    			
    		}
    		
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }

}
