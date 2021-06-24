import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeConversion {
	
	
	/**
	 * 12:01:00PM -> 12:01:00
	 * 07:05:45PM -> 19:05:45
	 * 12:45:54PM -> 12:45:54
	 * 12:01:00AM -> 00:01:00
	 * 12:40:22AM -> 00:40:22
	 * 06:40:03AM -> 06:04:03
	 * @param s
	 * @return
	 */
	
	public static String timeConversion(String s) {
	    // Write your code here
	        String result = "";
	        if(s!=null && s!="" && s.length() > 0){
	        	int h = Integer.valueOf(s.substring(0,2))+12;
	        	
	        	if(s.contains("AM") && h < 24 || (s.startsWith("12") && s.contains("PM"))) {
	        		return s.substring(0,s.length()-2);
	        	}
	        	
            	String min = s.substring(3,5);
	            String secs = s.substring(6,8);
	            String hr = "";
	            
	            if(h>=24) {
	            	hr = "00";
	            }
	            else if (h<10){
	            	hr = "0" + Integer.toString(h);
	            }
	            else {
	            	hr = Integer.toString(h);
	            }
	            result = hr + ":"+ min + ":" + secs;
	        }
	        
	        return result;
	    }
	
	public static void main(String[] args) throws IOException {
		testTimeConversion();
		/*
		 * BufferedReader bufferedReader = new BufferedReader(new
		 * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
		 * BufferedWriter(new
		 * FileWriter("C:\\Users\\Desktop\\output.txt"));
		 * 
		 * String s = bufferedReader.readLine();
		 * 
		 * String result = TimeConversion.timeConversion(s);
		 * 
		 * bufferedWriter.write(result); bufferedWriter.newLine();
		 * 
		 * bufferedReader.close(); bufferedWriter.close();
		 */
    }
	
	public static void testTimeConversion() {
		
		String inputArr[] = {"12:01:00PM","07:05:45PM","12:45:54PM","12:01:00AM","12:40:22AM","06:40:03AM"};
		String expectedArr[] = {"12:01:00","19:05:45","12:45:54","00:01:00","00:40:22","06:40:03"};
		
		for(int i=0;i<inputArr.length;i++) {
			System.out.println(TimeConversion.timeConversion(inputArr[i]).equals(expectedArr[i]));
		}
		
	}
	
}
