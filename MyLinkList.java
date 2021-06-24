import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyLinkList {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
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
		 * Complete the 'insertNodeAtPosition' function below.
		 *
		 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST. The
		 * function accepts following parameters: 1. INTEGER_SINGLY_LINKED_LIST llist 2.
		 * INTEGER data 3. INTEGER position
		 */

		/*
		 * For your reference:
		 *
		 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
		 *
		 */

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter("C:\\Users\\ziaalkhair.mohammed\\Desktop\\output.txt"));

		SinglyLinkedList llist = new SinglyLinkedList();

		int llistCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < llistCount; i++) {
			int llistItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			llist.insertNode(llistItem);
		}

		int data = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int position = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

		printSinglyLinkedList(llist_head, " ", bufferedWriter);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

	private static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
		// TODO Auto-generated method stub
		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		int counter = 0;
		/*
		 * if (counter == position) { // Insert at Head SinglyLinkedListNode tempNode =
		 * head; head = node; head.next = tempNode; return head; }
		 */

		SinglyLinkedListNode n = head;
		SinglyLinkedList newHead = new SinglyLinkedList();
		while(n!=null) {
			if(counter == position) {
				/*
				 * SinglyLinkedListNode tempNode = n; n = node; n.next = tempNode; return n;
				 */
				SinglyLinkedListNode tempNode = n;
				node.next = tempNode;
				newHead.insertNode(node.data); //New Node
			}
			newHead.insertNode(n.data);
			n = n.next;
			counter++;
		}

		return newHead.head;
	}
	
}
