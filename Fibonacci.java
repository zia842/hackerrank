
public class Fibonacci {
	
	public static long fib(int n) {
		long arr[] = new long[n+2];
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2;i<=n+1;i++) {
			arr[i] = arr[i-2] + arr[i-1];
			System.out.println(arr[i]);
		}
		return arr[n+1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fib(5);
		//System.out.println(fib(5));

	}

}
