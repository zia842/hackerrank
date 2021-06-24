import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwapNodes {
	
	/*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
    	int rootNode[][] = new int[indexes.length+1][2];
    	rootNode[0][0] = 1;
    	rootNode[0][1] = 1;
    	
    	int resultNode[][] = new int[indexes.length+1][2];
    	resultNode[0][0] = 1;
    	resultNode[0][1] = 1;
		
		List<Integer> resultList = new ArrayList<Integer>();
		
		
		
		for(int i=0;i<indexes.length;i++) {
			rootNode[i+1][0] = indexes[i][0];
			rootNode[i+1][1] = indexes[i][1];
		}
		
		//printChildParent(rootNode);
		//printParentChild(indexes);
		
		//System.out.println("End");
    	
		nodeData(rootNode, 0, 0, resultList);
		
		
		int row = 0;
		int col = 0;
		for(int i=0;i<resultList.size();i++) {
			resultNode[row][col] = resultList.get(i);
			if(col == 1) {
				row++;
				col = 0;
				continue;
			}
			col++;
		}
    	
		
    	
    	return resultNode;

    }
    
    
    public static void printParentChild(int[][] indexes) {
    	for(int i=0;i<indexes.length;i++) {
    		System.out.println("Parent is " + indexes[i][0] + " " + indexes[i][1]);
    		
    		int leftChild  =  ((2*i) + 1);
    		int rightChild =  ((2*i) + 2);
    		if(leftChild < indexes.length) {
    			System.out.println("Left Child is " + indexes[leftChild][0] + " " + indexes[leftChild][1]);
    		}
    		if(rightChild < indexes.length) {
    			System.out.println("Right Child is " + indexes[rightChild][0] + " " + indexes[rightChild][1]);
    		}
    	}
    }
    
    public static void printChildParent(int[][] indexes) {
    	for(int i=0;i<indexes.length;i++) {
    		int parent = (i)/2;
    		System.out.println("Child is " + indexes[i][0] + " " + indexes[i][1] + " Parent is " + parent);
    	}
    }
    
    
    public static void createTree(int[][] indexes) {
    	
    }
    
    /**
     * In-order Traversal
     * Left, Parent/Root, Right
     * @param indexes
     * @param rowNumber
     * @param childPosition
     * @param resultList
     */
    public static void nodeData(int[][] indexes, int rowNumber, int childPosition, List<Integer> resultList) {
    	
    	if(rowNumber < 0) {
    		return;
    	}
    	
    	int node = indexes[rowNumber][childPosition];
    
    	if(node < 0) {
    		return;
    	}
    	
    	
    	System.out.println(node);
    	nodeData(indexes,node,0,resultList); //Left Child
    	
    	resultList.add(Integer.valueOf(node)); //Parent/Root Node
    	nodeData(indexes,node,1,resultList); //Right Child
    }
    
   
    
   
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Desktop\\output.txt"));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }

}
