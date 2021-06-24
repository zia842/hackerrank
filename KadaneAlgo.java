import java.util.TreeSet;

public class KadaneAlgo {
	
	public static int maxSubArray(int []arr) {
		int maxSum = 0;
		
		if(arr!=null && arr.length > 0) {
			maxSum = arr[0];
			int currSum = arr[0];;
			for(int i=1;i<arr.length;i++) {
				currSum = Math.max(currSum + arr[i], arr[i]);
				maxSum = Math.max(maxSum, currSum);
			}
		}
		
		return maxSum;
	}
	
	static long maximumSum(long[] a, long m) {
	        long maxSum=0;
	      
	        TreeSet<Long> prefix = new TreeSet<Long>();
	        long currSum=0;

	        for(int i=0;i<a.length;i++){
	            currSum=(currSum+a[i]%m)%m;
	            System.out.println("Current Sum is " + currSum);
	            maxSum=Math.max(maxSum, currSum);
	            
	            Long pr = prefix.higher(currSum);
	            if(pr != null){
	                maxSum= Math.max(maxSum, (currSum-pr+m)%m);
	                System.out.println("Maximum Sum is " + (currSum-pr+m)%m);
	            }
	            prefix.add(currSum);
	        }
	        
	        return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {2,-2,1,3};
		System.out.println(maxSubArray(arr));
		
		TreeSet<Integer> tree = new TreeSet<Integer>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
  
        System.out.println(tree.higher(3));
        
        
        long []arr1 = {1,2,3,4,5,6,7,-8,2,12,11};
        
        System.out.println("Modulous Max Sum " + maximumSum(arr1, 15));

	}

}
