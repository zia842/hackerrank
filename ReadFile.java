import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

	public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
		
		
	    String fileName = "C:\\Users\\Desktop\\tc.txt";
	    String data = readFileAsString(fileName);
	    
	    String []arr = data.split(" ");  
	    int nums[] = new int[arr.length];
	    for(int i=0;i<arr.length;i++) {
	    	nums[i] = Integer.parseInt(arr[i]);
	    }
	    
	    System.out.println(nums);
	} 
	
	public static String readFileAsString(String fileName)throws Exception 
	  { 
	    String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get(fileName))); 
	    return data; 
	  } 
	
	
	public static int[] arrayOfData() {
		String fileName = "C:\\Users\\Desktop\\tc.txt";
	    String data;
		try 
		{
			data = readFileAsString(fileName);
			String []arr = data.split(" ");  
		    int nums[] = new int[arr.length];
		    for(int i=0;i<arr.length;i++) {
		    	nums[i] = Integer.parseInt(arr[i]);
		    }
		    
		    return nums;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return null;
		
	}


}
