
public class BinarySearch {
	
	
	public static int binarySearch(int []arr, int key) {
		int index = -1; //If Key not found will work for -ve numbers also
		
		if(arr!=null && arr.length > 0) {
			
			int low = 0;
			int high = arr.length-1;
			
			while(low <= high) {
				
				int mid = (high + low)/2;
				
				if(key == arr[mid]) { //Key found 
					//return mid;
					index = mid;
					break;
				}
				else if(key < arr[mid]) { // Search Key Left Side of Array
					high = mid - 1;
				}
				else  //Search Key Right Side of Array
				{
					low = mid + 1;
				}
				
			}
			
			System.out.println("Low is " + low);
			System.out.println("High is " + high);
			
		}
		
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []arr = {1,2,3,5,6,8,50,54,65,99,100};
		int key = 8;
		//int index = binarySearch(arr,key);
		//System.out.println("Key is "+ key + " Index is " + index);
		
		for(int i=1;i<=100;i++) {
			int index = binarySearch(arr,i);
			System.out.println("Key is "+ i + " Index is " + index);
		}
		
		
		
	}

}
