import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SwapNodesUsingList {

	/*
	 * Complete the 'swapNodes' function below.
	 *
	 * The function is expected to return a 2D_INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. 2D_INTEGER_ARRAY indexes
	 *  2. INTEGER_ARRAY queries
	 */

	/*
	 * public static List<List<Integer>> swapNodes(List<List<Integer>> indexes,
	 * List<Integer> queries) { // Write your code here
	 * 
	 * List<List<Integer>> resultList = new ArrayList<>(); List<Integer> resList =
	 * new ArrayList<Integer>();
	 * 
	 * List<Integer> rootNode = new ArrayList<Integer>(); rootNode.add(1);
	 * rootNode.add(1);
	 * 
	 * indexes.add(0, rootNode);
	 * 
	 * 
	 * int numberOfNodes = calculateNumberOfNodes(indexes); int height =
	 * calclulateHeight(numberOfNodes);
	 * 
	 * Integer[][] indexArr = indexes.stream().map(u -> u.toArray(new
	 * Integer[0])).toArray(Integer[][]::new);
	 * 
	 * nodeData(indexes, 0, 0, resList); //nodeData(indexArr, 0, 0, resList);
	 * 
	 * return resultList;
	 * 
	 * }
	 */
	
	public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
		List<List<Integer>> resultList = new ArrayList<>(); 
		List<Integer> rootNode = new ArrayList<Integer>(); rootNode.add(1);rootNode.add(1);
		indexes.add(0, rootNode);
		List<Integer> oneDimensionalList =  new ArrayList<Integer>();
		
		levelOrder(indexes, 0, 0, oneDimensionalList);
		return resultList;
	}
	
	public static int calculateNumberOfNodes(List<List<Integer>> indexes) {
		int numberOfNodes = 0;
		/*
		 * ArrayList<List<Integer>> col = indexes.stream() .map(i -> i.stream()
		 * .filter(t -> t > 0) .collect(Collectors.toList()))
		 * .collect(Collectors.toCollection(ArrayList<List<Integer>>::new));
		 */
		
		for(int i=1;i<indexes.size();i++) {
			for(int j=0;j<=1;j++) {
				if(indexes.get(i).get(j) > 0) {
					numberOfNodes++;
				}
			}
		}
		
		return numberOfNodes + 1; //Add Root
	}
	
	public static int calclulateHeight(int numberOfNodes) {
		//Log 2(n+1)
		return calcLog(2, numberOfNodes+1);
	}
	
	/**
	 * Keep dividing the number / base as long as it is > 1 and increment counter when result is 1 
	 * @param base
	 * @param n
	 * @return
	 */
	
	public static int calcLog(int base, int n) {
		int result = 1;
		if(base > n) {
			return 0;
		}
		
		int ctr = 0;
		result = n;
		while(result > 1) {
			result = result / base;
			ctr++;
		}
		
		return ctr;
	}
	
	public static void nodeData(Integer[][] indexes, int rowNumber, int childPosition, List<Integer> resultList) {
    	
    	if(rowNumber < 0) {
    		return;
    	}
    	
    	int node = indexes[rowNumber][childPosition];
    	if(node < 0) {
    		return;
    	}
    	
    	nodeData(indexes,node,0,resultList); //Left Child
    	//System.out.println(node);
    	resultList.add(Integer.valueOf(node)); //Parent/Root Node
    	nodeData(indexes,node,1,resultList); //Right Child
    }

	public static void nodeData(List<List<Integer>> indexes, int rowNumber, int childPosition, List<Integer> resultList) {

		if(rowNumber < 0) {
			return;
		}

		//int node = indexes[rowNumber][childPosition];
		int node  = indexes.get(rowNumber).get(childPosition);
		if(node < 0) {
			return;
		}

		nodeData(indexes,node,0,resultList); //Left Child
		System.out.println(node);
		resultList.add(Integer.valueOf(node)); //Parent/Root Node
		nodeData(indexes,node,1,resultList); //Right Child
	}
	
	public static void levelOrder(List<List<Integer>> indexes, int rowNumber, int childPosition, List<Integer> resultList) {
		if(rowNumber < 0) {
			return;
		}
		
		int node  = indexes.get(rowNumber).get(childPosition);
		if(node < 0) {
			return;
		}
		System.out.println(node); //Parent
		
		nodeData(indexes,node,0,resultList); //Left Child
		
		nodeData(indexes,node,1,resultList); //Right Child
	}




	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> indexes = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] indexesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			List<Integer> indexesRowItems = new ArrayList<>();

			for (int j = 0; j < 2; j++) {
				int indexesItem = Integer.parseInt(indexesRowTempItems[j]);
				indexesRowItems.add(indexesItem);
			}

			indexes.add(indexesRowItems);
		}

		int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> queries = new ArrayList<>();

		for (int i = 0; i < queriesCount; i++) {
			int queriesItem = Integer.parseInt(bufferedReader.readLine().trim());
			queries.add(queriesItem);
		}

		List<List<Integer>> result = swapNodes(indexes, queries);

		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				bufferedWriter.write(String.valueOf(result.get(i).get(j)));

				if (j != result.get(i).size() - 1) {
					bufferedWriter.write(" ");
				}
			}

			if (i != result.size() - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

}
