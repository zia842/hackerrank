import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SalesByMatch {

	static int sockMerchant(int n, int[] ar) {
		Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
		if(n > 1){

			for(int i=0;i<ar.length;i++){
				if(countMap.get(ar[i]) !=null && countMap.get(ar[i]) > 0)
				{
					int temp =    countMap.get(ar[i]);
					countMap.put(ar[i],temp+1);
				}
				else
				{
					countMap.put(ar[i],1);
				}
			}
			Iterator<Map.Entry<Integer,Integer>> itr = countMap.entrySet().iterator();
			int noOfPairs = 0;
			while(itr.hasNext())
			{
				Map.Entry<Integer,Integer> entry = itr.next(); 
				if(entry.getValue() % 2 == 0){
					noOfPairs = noOfPairs + (entry.getValue() / 2);
				}
				else
				{
					noOfPairs = noOfPairs +   ((entry.getValue() - 1) / 2);
				}

			}
			return noOfPairs;
		}

		return 0;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
