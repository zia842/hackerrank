
public class RotateLeft {
	
	static int[] rotLeft(int[] a, int d) {
		for(int i=0;i<d;i++) {
			int ctr = 0;
			int temp = a[0];
			while(ctr < a.length-1) {
				a[ctr] = a[ctr+1];
				ctr = ctr+1;
			}
			a[a.length-1] = temp;	
		}
		return a;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = new int[5];
		for(int i=0;i<a.length;i++) {
			a[i] = i+1;
		}
		
		rotLeft(a,4);

	}

}
