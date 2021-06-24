import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class CountTriplets {
	
	// Complete the countTriplets function below.
    static long countTripletsUsingTable(List<Long> arr, long r) {
    	long numberOfTriplets = 0;
    	if(arr!=null && arr.size() > 0) {
    		
    		HashMap<Long,Long> leftMap = new HashMap<Long,Long>();
    		HashMap<Long,Long> rightMap = new HashMap<Long,Long>();
    		
    		for(Long l : arr) {
    			rightMap.put(l, rightMap.getOrDefault(l, 0L) + 1);
    		}
    		
    		for(int i=0;i<arr.size();i++) {
    			
    			long midTerm = arr.get(i);
    			long c1 = 0; long c3 = 0;
    			
    			rightMap.put(midTerm, rightMap.getOrDefault(midTerm, 0L) - 1);
    			
    			if(leftMap.containsKey(midTerm/r) && midTerm % r == 0) {
    				c1 = leftMap.get(midTerm/r);
    			}
    			
    			if(rightMap.containsKey(midTerm*r)) {
    				c3 = rightMap.get(midTerm*r);
    			}
    			
    			numberOfTriplets += c1*c3;
    			
    			leftMap.put(midTerm, leftMap.getOrDefault(midTerm, 0L) + 1);
    		}
    		
    		
    	}
    	
    	
    	return numberOfTriplets;
    } 	
	
	// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

    	long numberOfTriplets = 0;
    	
    	if(arr!=null && arr.size() > 0) {
    		
    		Hashtable<Long,Long> previousTable = new Hashtable<Long,Long>();
    		Hashtable<Long,Long> afterTable = new Hashtable<Long,Long>();
    		
    		
    		for(Long l : arr) {
    			if(afterTable.containsKey(l)) {
    				Long count = afterTable.get(l);
    				count = count + 1;
    				afterTable.put(l, count);
    			}
    			else 
    			{
    				afterTable.put(l, Long.valueOf(1));
    			}
    		}
    		
    		/*if(afterTable!=null && afterTable.size() == 1) 
    		{
    			if(r == 1) 
    			{
    				Long count = afterTable.get(arr.get(0));
    				numberOfTriplets = ((count)*(count-1)*(count-2))/6;
    				return numberOfTriplets;
    			}
    		}*/
    		
    		for(Long l : arr) {
    			
    			//Decrease the count from After Table this is current element
				Long count = afterTable.get(l);
				count = count - 1;
				afterTable.put(l, count);
				
				long i = l%r; //Current Element
				long j = l/r; //Previous Element
				long k = l*r; //After Element
				
				long c1 = 0;
				
				long c3 = 0;
				
				/*if(i == 0 && previousTable.containsKey(j)) {
					c1 = previousTable.get(j);
				}
				
				if(afterTable.containsKey(k)) {
					c3 = afterTable.get(k);
				}
				
				numberOfTriplets += c1*c3;*/
				
				if(i == 0 && previousTable.containsKey(j) && afterTable.containsKey(k)) {
					numberOfTriplets += previousTable.get(j) * afterTable.get(k);
				}
				
				if(previousTable.containsKey(l)) {
					Long prevCount = previousTable.get(l);
					previousTable.put(l, prevCount+1L);
				}
				else 
				{
					previousTable.put(l, 1L);
				}
				
				
    		}
    		
    	}
    	
    	return numberOfTriplets;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Long> listOne = new ArrayList<Long>();
		listOne.add(Long.valueOf(1));listOne.add(Long.valueOf(2));listOne.add(Long.valueOf(2));listOne.add(Long.valueOf(4));
		
		System.out.println(countTriplets(listOne, 2));
		
		List<Long> listTwo = new ArrayList<Long>();
		listTwo.add(Long.valueOf(1));listTwo.add(Long.valueOf(4));listTwo.add(Long.valueOf(16));listTwo.add(Long.valueOf(64));
		
		System.out.println(countTriplets(listTwo, 4));
		
		List<Long> listThree = new ArrayList<Long>();
		listThree.add(Long.valueOf(1));listThree.add(Long.valueOf(3));listThree.add(Long.valueOf(9));listThree.add(Long.valueOf(9));listThree.add(Long.valueOf(27));listThree.add(Long.valueOf(81));
		
		System.out.println(countTriplets(listThree, 3));
		
		List<Long> listFour = new ArrayList<Long>();
		listFour.add(Long.valueOf(1));listFour.add(Long.valueOf(5));listFour.add(Long.valueOf(5));listFour.add(Long.valueOf(25));listFour.add(Long.valueOf(125));
		
		System.out.println(countTriplets(listFour, 5));
		
		List<Long> listFive = new ArrayList<Long>();
		for(int i=1;i<=100000;i++) {
			listFive.add(Long.valueOf(1237));
		}
		
		System.out.println(countTriplets(listFive, 1));
		
		
		List<Long> listSix = new ArrayList<Long>();
		listSix.add(Long.valueOf(1));listSix.add(Long.valueOf(2));listSix.add(Long.valueOf(1));listSix.add(Long.valueOf(2));listSix.add(Long.valueOf(4));
		
		System.out.println(countTriplets(listSix, 2));

	}

}
