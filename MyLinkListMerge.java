import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class MyLinkListMerge {

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

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
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

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			int index = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedList llist1 = new SinglyLinkedList();

			int llist1Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist1Count; i++) {
				int llist1Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist1.insertNode(llist1Item);
			}

			SinglyLinkedList llist2 = new SinglyLinkedList();

			int llist2Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist2Count; i++) {
				int llist2Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist2.insertNode(llist2Item);
			}

			SinglyLinkedListNode ptr1 = llist1.head;
			SinglyLinkedListNode ptr2 = llist2.head;

			for (int i = 0; i < llist1Count; i++) {
				if (i < index) {
					ptr1 = ptr1.next;
				}
			}

			for (int i = 0; i < llist2Count; i++) {
				if (i != llist2Count-1) {
					ptr2 = ptr2.next;
				}
			}

			ptr2.next = ptr1;

			int result = findMergeNode(llist1.head, llist2.head);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}

	private static int findMergeNode(SinglyLinkedListNode head, SinglyLinkedListNode head2) {
		// TODO Auto-generated method stub
		
		/*
		 * SinglyLinkedListNode nodeOne = head.next; while(nodeOne!=null) {
		 * SinglyLinkedListNode nodeTwo = head2.next; while(nodeTwo!=null) {
		 * if(nodeOne.data == nodeTwo.data) { return nodeOne.data; } nodeTwo =
		 * nodeTwo.next; } nodeOne = nodeOne.next; }
		 */
		
		/*
		 * SinglyLinkedListNode nodeTwo = head2.next; while(nodeTwo!=null) {
		 * SinglyLinkedListNode nodeOne = head.next; while(nodeOne!=null) {
		 * if(nodeOne.data == nodeTwo.data){ return nodeOne.data; } nodeOne =
		 * nodeOne.next; } nodeTwo = nodeTwo.next; }
		 */
		Stack<Integer> stackOne = new Stack<Integer>();
		Stack<Integer> stackTwo = new Stack<Integer>();
		SinglyLinkedListNode nodeOne = head.next;
		while(nodeOne!=null) {
			stackOne.push(nodeOne.data);
			nodeOne = nodeOne.next; 
		}
		
		SinglyLinkedListNode nodeTwo = head2.next;
		while(nodeTwo!=null) {
			stackTwo.push(nodeTwo.data);
			nodeTwo = nodeTwo.next; 
		}
		if(stackOne.isEmpty()) {
			stackOne.push(head.data);
		}
		int previous = 0;
		while(!stackOne.isEmpty() && !stackTwo.isEmpty()) {
			int eleOne = stackOne.pop();
			int eleTwo = stackTwo.pop();
			if(eleOne != eleTwo) {
				return previous;
			}
			previous = eleOne;
			
		}
		
		
		return previous;
	}

}
