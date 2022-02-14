import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fibonacci implements Runnable{
	
	static List<Long> resultList = new ArrayList<Long>();
	
	
	public Fibonacci(int n) {
		this.n = n;
	}
	
	private int n;
	
	public void run() {
		
		//System.out.println("Fib for " + n + " is " + fib(n));
		long r = factorial(n);
		//resultList.add(r);
		System.out.println("Factorial for " + n + " is " + r);
	}
	
	
	
	public static long fib(int n) {
		long arr[] = new long[n+2];
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2;i<=n+1;i++) {
			arr[i] = arr[i-2] + arr[i-1];
			//System.out.println(arr[i]);
		}
		return arr[n+1];
	}
	
	public static long factorial(int n) {
		int r = 1;
		while(n > 0) {
			r*= n--;
		}
		Fibonacci.resultList.add((long) r);
		return r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//fib(5);
		//System.out.println(fib(5));
		ExecutorService ex = Executors.newFixedThreadPool(5);
		Fibonacci fib = null;
		for(int i=0;i<10;i++) {
			fib = new Fibonacci(i);
			ex.submit(fib);
			System.out.println(fib.resultList.size());
		}
		
		
		System.out.println(fib.resultList.size());
		

	}

}
