
public class Recursion {
	
	public static int numOfTimes = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(1);
		checkCondition();

	}
	
	public static void print(int num) {
		if(num <= numOfTimes) {
			System.out.println("Hello Number is " + num);
			num = num + 1;
			print(num);
		}
	}
	
	public static void checkCondition() {
		int i;
		for(i=0;i<5;) {
			
			if(i%2 == 0) {
				System.out.println("Yes " + i);
				i++;
			}
			else {
				System.out.println("No " + i);
			}
			
		}
	}

}
