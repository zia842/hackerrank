public class QuickSort {
	
	
	/**
	 * Reference https://www.youtube.com/watch?v=COk73cpQbFQ
	 * 7 2 1 6 8 5 3 4
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void quickSort(int []arr, int start, int end) 
	{
		if(start < end) 
		{
			int pIndex = partition(arr, start, end);
			quickSort(arr,start,pIndex-1);
			quickSort(arr,pIndex+1,end);
		}
	}
	
	public static int partition(int []arr, int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		for(int i=start;i<end;i++) 
		{
			if(arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex = pIndex + 1;
			}
		}
		int temp = arr[pIndex];
		arr[pIndex] = arr[end];
		arr[end] = temp;
		return pIndex;
	}
	
	public static int partitionRandomPivot(int []arr, int start, int end) {
		int random = getRandomNumber(start, end);
		int temp = arr[end];
		arr[end] = arr[random];
		arr[random] = temp;
		return partition(arr, start, end);
	}
	
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []arr = new int[8];
		arr[0] = 7;
		arr[1] = 2;
		arr[2] = 1;
		arr[3] = 6;
		arr[4] = 8;
		arr[5] = 5;
		arr[6] = 3;
		arr[7] = 4;
		quickSort(arr,0,arr.length-1);
		
		for(int i : arr) {
			System.out.println(i);
		}
		
		quickSort(arr,0,arr.length-1);
		System.out.println("Hello");
		for(int i : arr) {
			System.out.println(i);
		}

	}

}
