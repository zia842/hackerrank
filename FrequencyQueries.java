import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {
	
	
	/**
	 * Function is slow as it has to search data 
	 * @param queries
	 * @return
	 */
	// Complete the freqQuery function below.
    static List<Integer> freqQueryOneMap(List<List<Integer>> queries) {

    	List<Integer> frequencyResult = new ArrayList<Integer>();
    	Map<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
    	
    	if(queries!=null && queries.size() > 0) {
    		
    		for(List<Integer> queriesRowItems : queries) {
    			
    			int operation = queriesRowItems.get(0);
    			int data = queriesRowItems.get(1);
    			
    			Integer p = freqMap.getOrDefault(data, 0);
    			
    			if(operation == 1) {
    				freqMap.put(data, p + 1);
    			}
    			
    			if(operation == 2) {
    				if(p<= 1) {
    					freqMap.remove(data);
    				}
    				else 
    				{
    					freqMap.put(data, p - 1);
    				}
    				
    			}
    			
    			if(operation == 3) {
    				if(freqMap.containsValue(data)) {
    					frequencyResult.add(Integer.valueOf(1));
    				}
    				else {
    					frequencyResult.add(Integer.valueOf(0));
    				}
    			}
    		}
    		
    	}
    	
    	return frequencyResult;

    }
    
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	List<Integer> frequencyResult = new ArrayList<Integer>();
    	Map<Integer,Integer> mapOne = new HashMap<Integer,Integer>();
    	Map<Integer,Integer> mapTwo = new HashMap<Integer,Integer>();
    	
    	if(queries!=null && queries.size() > 0) {
    		
    		for(List<Integer> queriesRowItems : queries) {
    			
    			int operation = queriesRowItems.get(0);
    			int data = queriesRowItems.get(1);
    			
    			Integer p = mapOne.getOrDefault(data, 0);
    			
    			if(operation == 1) {
    				
    				//Decrement/Remove Previous Occurrence d2(-)
    				if(mapTwo.containsKey(p)) {
    					Integer oc = mapTwo.getOrDefault(p, 0);
    					if(oc<=1) {
    						mapTwo.remove(p); //If not removed data occurrence will go -ve
    					}
    					else 
    					{
    						mapTwo.put(p, oc-1);
    					}
    				}
    				
    				//Actual Data and Occurrence Increment  d1(+)
    				mapOne.put(data, p+1);
    				
    				//Add the Occurrence as key d2(+)
    				Integer oc = mapTwo.getOrDefault(mapOne.get(data), 0);
    				mapTwo.put(mapOne.get(data), oc+1);
    				
    				
    			}
    			else if(operation == 2) 
    			{
    				//Decrement/Remove Previous Occurrence d2(-)
    				if(mapTwo.containsKey(p)) {
    					Integer oc = mapTwo.getOrDefault(p, 0);
    					if(oc<=1) {
    						mapTwo.remove(p); //If not removed data occurrence will go -ve
    					}
    					else 
    					{
    						mapTwo.put(p, oc-1);
    					}
    				}
    				
    				//Actual Data and Occurrence Decrease or Remove  d1(-)
    				if(p<= 1) 
    				{
    					mapOne.remove(data); //If not removed data occurrence will go -ve
    				}
    				else 
    				{
    					mapOne.put(data, p-1);
    				}
    				
    				//Increase the Occurrence as key d2(+)
    			    Integer oc = mapTwo.getOrDefault(mapOne.get(data), 0);
    				mapTwo.put(mapOne.get(data), oc+1);
    				
    		    }
    			if(operation == 3) {
    				if(mapTwo.containsKey(data)) {
    					frequencyResult.add(Integer.valueOf(1));
    				}
    				else {
    					frequencyResult.add(Integer.valueOf(0));
    				}
    			}
    			
    		}	
    	}
    	return frequencyResult;	
    	
    }
	

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
            bufferedWriter.write(String.valueOf(ans.get(i)));

            if (i != ans.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

	}

}
