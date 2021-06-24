import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

public class MyDoubleLinkList {
	
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
    
    class Result {

        /*
         * Complete the 'sortedInsert' function below.
         *
         * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
         * The function accepts following parameters:
         *  1. INTEGER_DOUBLY_LINKED_LIST llist
         *  2. INTEGER data
         */

        /*
         * For your reference:
         *
         * DoublyLinkedListNode {
         *     int data;
         *     DoublyLinkedListNode next;
         *     DoublyLinkedListNode prev;
         * }
         *
         */

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

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

	private static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
		// TODO Auto-generated method stub
		
		DoublyLinkedListNode nodeToBeAdded = new DoublyLinkedListNode(data); //New Node
		DoublyLinkedList sortedList = new DoublyLinkedList();
		
		
		DoublyLinkedListNode n = head;
		sortedList.head = n;
		while(n!=null) {
			
			//Insert Node at Head
			if(n.prev == null && data < n.data) {
				nodeToBeAdded.next = n;
				n.prev = nodeToBeAdded;
				sortedList.head = nodeToBeAdded;
				break;
			}
			else if(n.prev!=null &&  n.prev.data <= data && n.data >= data) { //Insert Node in between 2 Nodes
				nodeToBeAdded.prev = n.prev;
				nodeToBeAdded.next = n;
				n.prev.next = nodeToBeAdded;
				break;
			}
			else if(n.prev!=null && n.next == null) { //Insert Node at the end
				n.next = nodeToBeAdded;
				nodeToBeAdded.prev = n;
				break;
			}
			n = n.next;
		}
		
		return sortedList.head;
		
	}

}
