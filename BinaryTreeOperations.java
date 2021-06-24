import java.util.Scanner;
import java.util.logging.Level;

class BinaryNode {
	BinaryNode left;
	BinaryNode right;
    int data;
    
    BinaryNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTreeOperations {

	
	public static void levelOrder(BinaryNode root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		levelOrder(root.left.left);
		levelOrder(root.right.right);

	}
	public static void preOrder(BinaryNode root) {
		
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

	}
	
	public static void postOrder(BinaryNode root) {
		
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
		
	}
	
	public static void inOrder(BinaryNode root) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
	
	public static void topView(BinaryNode root) {
		if(root == null) {
            return;
        }
        
		//topView(root.left);
		System.out.print(root.data + " ");
        topView(root.right);
       
	}
	
	public static int height(BinaryNode root) {
		int h = calcHeight(root) - 1;
		return h;
	}
	
	public static int calcHeight(BinaryNode root) {
		int left = 0;
		int right = 0;
		if(root != null) {
			left = calcHeight(root.left);
			right = calcHeight(root.right);
			//System.out.print(root.data + " ");
			
			if(left > right ) {
				return left + 1;
			}
			else {
				return right + 1;
			}
		}
		return 0;
		
	}
	
	

	public static BinaryNode insert(BinaryNode root, int data) {
		if(root == null) {
			return new BinaryNode(data);
		} else {
			BinaryNode cur;
			if(data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		BinaryNode root = null;
		while(t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		//int h = height(root);
		//System.out.println(h);
		//topView(root);
		levelOrder(root);
		
	}	

}
