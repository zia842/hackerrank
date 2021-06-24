import java.util.HashMap;

public class MinimumSwap {
	
	
	/**
	 * This method sorts and identifies minimum number of swaps required to sort an Array
	 * Numbers can be Consecutive  or Non Consecutive  
	 * In each iteration/pass identifies smallest number and places it in correct position Ascending Order
	 * Time Complexity is o(n^2)
	 * @param arr
	 * @return
	 */
	static int minimumSwaps(int[] arr) {
		
		int swap = 0;
		int minloc,temp = 0;
		
		for(int i=0;i<arr.length;i++) {
			
			minloc = i;
			temp= i;
			
			for(int j=i;j<arr.length;j++) {
				if(arr[j] < arr[minloc]) {
					minloc = j;
				}
			}
			
			if(minloc != i) {
				temp = arr[i];
				arr[i] = arr[minloc];
				arr[minloc] = temp;
				swap++;
			}
			
		}
		return swap;
    }
	
	/**
	 * This method identifies minimum number of swaps required to sort an Array 
	 * Numbers should be Consecutive. For Non-Consecutive, Duplicates method may fail
	 * @param arr
	 * @return
	 */
	//TODO: Sort the Array also
	static int minimumSwaps3(int[] arr) {
		int swap = 0;
		boolean isVisited[] = new boolean[arr.length]; //Initialize an array boolean to verify if index has been visited or not
		
		for(int index=0;index<arr.length;index++) {
			
			if(!isVisited[index]) {
				
				isVisited[index] = true;
				
				if(arr[index] == index+1) { //Problem Statement Consecutive Numbers in case of Non-Consecutive, Duplicates the position of index will not be same
					continue;
				}
				else 
				{
					int positionIndex = arr[index]; //Element Value is Index of another element e.g  4 3 1 2
													//Array Index									 1 2 3 4
					
					while(!isVisited[positionIndex-1]) {
						isVisited[positionIndex-1] = true;
						positionIndex = arr[positionIndex-1];
						swap++;
					}
					
				}
				
			}
			
		}
		return swap;
	}
	
	/**
	 * This method identifies minimum number of swaps required to sort an Array 
	 * Numbers should be Consecutive. For Non-Consecutive, Duplicates method may fail
	 * This method is same as minimumSwaps3 but comparatively simple it uses HashMap to identify Index and Element Value
	 * @param arr
	 * @return
	 */
	
	static int minimumSwaps2(int[] arr) {
		
		int swap = 0;
		boolean isVisited[] = new boolean[arr.length+1];
		
		HashMap<Integer,Integer> nodeMap = new HashMap<Integer,Integer>();
		
		for(int i=1;i<isVisited.length;i++) {
			nodeMap.put(i, arr[i-1]);
		}
		
		for(int k=1;k<=nodeMap.size();k++) {
			int nextNode;
			if(isVisited[k] == false) {
				
				isVisited[k] = true;
				
				if(k == nodeMap.get(k)) {
					continue;
				}
				else {
					
					int c = nodeMap.get(k);
					while(!isVisited[c]) {
						isVisited[c] = true;
						nextNode = nodeMap.get(c);
						c = nextNode;
						swap++;
					}
					
				}
			}
			
		}
		
		return swap;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] q = new int[7];
		q[0] = 7;
		q[1] = 1;
		q[2] = 3;
		q[3] = 2;
		q[4] = 4;
		q[5] = 5;
		q[6] = 6;
		//q[7] = 4;
		System.out.println("Minimum Swap Count is " + minimumSwaps3(q));

	}

}
