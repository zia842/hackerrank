import java.util.Arrays;

public class MergeSort {
	
	public static long mergeSort(int []arr, int []sortedArr, int left, int right) {
		long inversionCount = 0;
		if(arr!=null && arr.length > 0 && right > left) {
			int middle = (left + right) / 2;
			inversionCount += mergeSort(arr,sortedArr,left,middle);
			inversionCount += mergeSort(arr,sortedArr,middle+1,right);
			inversionCount += merge(arr,sortedArr,left,middle,right);
		}
		return inversionCount;
	}
	
	public static long merge(int []arr, int sortedArr[], int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;
		long inversionCount = 0;
		
		while(i <= mid && j <= right) {
			if(arr[i] <= arr[j]) {
				sortedArr[k] = arr[i];
				i++;
			}
			else 
			{
				sortedArr[k] = arr[j];
				j++;
				inversionCount = inversionCount + (mid+1-i);
			}
			k++;
		}
		
		while(i <= mid) {
			sortedArr[k++] = arr[i++];
		}
		
		while(j <= right) {
			sortedArr[k++] = arr[j++];
		}
		
		for(int l=left;l<k;l++) {
			arr[l] = sortedArr[l];
		}
		
		return inversionCount;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,1,3,1,2};
		int []sortedArr = Arrays.copyOfRange(input, 0, input.length);
		System.out.println("Inversion Count "+mergeSort(input,sortedArr,0,input.length-1));
		for(int i : sortedArr) {
			System.out.println(i);
		}

	}

}
