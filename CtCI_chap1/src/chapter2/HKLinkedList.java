package chapter2;

public class HKLinkedList {
	
	Node head = null;
	
	public void printLinkedList() {
		Node n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public Node deleteNode(Node head, int d) {
		Node n = head;
		
		if (n.data == d) {
			return head.next;
		}
		
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		
		return head;
		
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this.head;
		if (n == null) {
			this.head = end;
			return;
		}
		
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public class Node {
		Node next = null;
		int data;
		
		public  Node(int d) {
			data = d;
		}
		
	}
}
