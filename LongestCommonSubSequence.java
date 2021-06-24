
public class LongestCommonSubSequence {
	
	
	public static long commonSubSequence(char[] X, char [] Y, int m, int n) {
		long maxCommonSubSequence = Long.MIN_VALUE;
		int dpTable [][] = new int [m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i== 0 || j == 0) {
					dpTable[i][j] = 0;
				}
				else if(X[i-1] == Y[j-1])
				{
					dpTable[i][j] = dpTable[i-1][j-1] + 1;
				}
				else 
				{
					dpTable[i][j] = Math.max(dpTable[i-1][j],dpTable[i][j-1]);
				}
				
				if(dpTable[i][j] > maxCommonSubSequence) {
					maxCommonSubSequence = dpTable[i][j];
				}
			}
		}	
		return maxCommonSubSequence;
	}
	
	
	public static long commonSubSequence(String a, String b) {
		long maxCommonSubSequence = 0;
		
		if(a!=null && b!=null && a.length() > 0 && b.length() > 0) {
			
			int dpTable[][] = new int[a.length()+1][b.length()+1];
			
			maxCommonSubSequence = Long.MIN_VALUE;
			
			for(int i=0;i<=a.length();i++) {
				for(int j=0;j<=b.length();j++) {
					
					if(i== 0 || j == 0) {
						dpTable[i][j] = 0;
					}
					else if (a.charAt(i-1) == b.charAt(j-1))  //If character matches
					{ 
						dpTable[i][j] = dpTable[i-1][j-1] + 1;
					}
					else  //Character does not match
					{
						dpTable[i][j] = Math.max(dpTable[i-1][j],dpTable[i][j-1]);
					}
					
					if(dpTable[i][j] > maxCommonSubSequence) {
						maxCommonSubSequence = dpTable[i][j];
					}
				}
			}
		}
		
		//TODO:In case either of the string is empty check the correctness of logic probably use the available string length
		
		return maxCommonSubSequence;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = {"JAVAAID","JAVAID"};
		System.out.println(commonSubSequence(arr[0].toCharArray(),arr[1].toCharArray(),arr[0].length(),arr[1].length()));
		System.out.println(commonSubSequence(arr[0],arr[1]));
		
		String arr1[] = {"ABCD","ABDC"};
		System.out.println(commonSubSequence(arr1[0].toCharArray(),arr1[1].toCharArray(),arr1[0].length(),arr1[1].length()));
		System.out.println(commonSubSequence(arr1[0],arr1[1]));

	}

}
