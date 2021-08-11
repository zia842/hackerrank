
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder s = new StringBuilder("abc");
		
		for(int i=s.length()-1;i>=0;i--) {
			
			s.deleteCharAt(i);
		}
		System.out.println("Hello"+s.toString());
	}

}
