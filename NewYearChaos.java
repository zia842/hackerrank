import java.util.HashMap;
import java.util.Map;

public class NewYearChaos {
	
	static void minimumBribes(int[] q) {
        
        int[] e = new int[q.length];
        int bribe = 0;
       /* Map<Integer,Integer> positionMap = new HashMap<Integer,Integer>();
        for(int i=0;i<e.length;i++) {
            e[i] = i+1;
            positionMap.put(e[i],i+1);
        }
        boolean flag = false;
        for(int i=0;i<q.length;i++){
            if(q[i] != e[i] && q[i] > e[i]){
                
                int expectedPos = positionMap.get(q[i]);
                if(expectedPos-(i+1) > 2)
                {
                    System.out.println("Too chaotic");
                    flag = true;
                    break;
                }
            }
        }
        if(!flag)
        {
            for(int i=0;i<q.length;i++)
            {
            	if(0 == i)
            		continue;
            	
            	if(q[i] != positionMap.get(i+1)) 
            	{
            		bribe = bribe + numberOfBribes(q, i);
            	}
            }
        	System.out.println(bribe);
        }*/
        
        for(int i=q.length-1;i>=0;i--) {
        	
        	if(q[i] != i+1) {
        		if(((i - 1) >= 0) && q[i - 1] == (i + 1)) {
        			
        			bribe = bribe + 1;
        			int t = q[i-1];
        			q[i-1] = q[i];
        			q[i] = t;
        		}
        		else if(((i - 2) >= 0) && q[i - 2] == (i + 1))
                {
        			bribe += 2;
                    q[i - 2] = q[i - 1];
                    q[i - 1] = q[i];
                    q[i] = i + 1;
                }
        		else
                {
        			System.out.println("Too chaotic");
                    return;
                }	
        		
        	}
        	
        }
        
       for(int i=0;i<q.length;i++) {
    	   System.out.println(q[i]);
       }

    }
	
	static int numberOfBribes(int[] q, int index) {
		int count = 0;
		for(int i=0;i<index;i++) {
			if(q[index] < q[i]) {
				count = count + 1;
			}
			
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*int[] q = new int[11];
		q[0] = 1;
		q[1] = 2;
		q[2] = 3;
		q[3] = 4;
		q[4] = 5;
		q[5] = 6;
		q[6] = 7;
		q[7] = 8;
		q[8] = 9;
		q[9] = 11;
		q[10] = 10;
		minimumBribes(q); */
		
		
		minimumBribes(ReadFile.arrayOfData());
		
		

	}

}
