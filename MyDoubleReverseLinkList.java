import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyDoubleReverseLinkList {
	
	static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter("C:\\Users\\ziaalkhair.mohammed\\Desktop\\output.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

	private static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
		
		DoublyLinkedList reverseList = new DoublyLinkedList();
		DoublyLinkedListNode n = head;
		while(n!=null) {
			if(n.next == null) {
				//Get Last Node
				break;
			}
			n = n.next;
		}
		
		//This works
		/*
		 * while(n!=null) { reverseList.insertNode(n.data); n = n.prev; }
		 */
		
		//Using Recursion
		reverseTraversal(n, reverseList);
		
		
		return reverseList!=null ? reverseList.head : null;
	}
	
	public static void reverseTraversal(DoublyLinkedListNode n, DoublyLinkedList reverseList) {
		if(n == null) {
			return;
		}
		reverseList.insertNode(n.data);
		reverseTraversal(n.prev, reverseList);
	}

}
