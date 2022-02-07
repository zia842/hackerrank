import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class DiagonalDifference {
	
	 /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
    	// Write your code here
    	int difference = 0;
    	int leftDiagonal = 0;
    	int rightDiagonal = 0;
    	
    	if(arr!=null && arr.size() > 0) {
    		
    		int m = arr.size(); //Rows
    		int n = arr.get(0).size(); //Column Size
    		
    		//Square Matrix will have same number of Rows & Columns
    		int j = arr.get(0).size() - 1;
    		for(int i=0;i<m;i++) {
    			leftDiagonal += arr.get(i).get(i); //Same Row, Same Column
    			rightDiagonal += arr.get(i).get(j);
    			j = j-1;
    		}
    		//Difference
    		difference = Math.abs(leftDiagonal - rightDiagonal);
    	}
    	return difference;

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
	
	

}
