package chapter2;

import chapter2.HKLinkedList.Node;

public class Question3 {

	public static void main(String[] args) {
		HKLinkedList ll1 = new HKLinkedList();
		for (int i=0; i<8; i++) {
			ll1.appendToTail(i);
		}
		
		System.out.println("Original LinkedList is");
		ll1.printLinkedList();
		System.out.println();
		
		Node node1 = ll1.head;
		
		Question3 q3 = new Question3();
		
		node1.printNodedata();
		q3.deleteMiddleNode(node1, ll1);
		ll1.printLinkedList();
		System.out.println();
		
		for (int i=0; i<3; i++) {
			node1 = node1.next;
		}
		node1.printNodedata();
		q3.deleteMiddleNode(node1, ll1);
		ll1.printLinkedList();
		System.out.println();
		
		for (int i=0; i<4; i++) {
			node1 = node1.next;
		}
		node1.printNodedata();
		q3.deleteMiddleNode(node1, ll1);
		ll1.printLinkedList();
		System.out.println();
		
		
		

	}
	
	public void deleteMiddleNode(Node n, HKLinkedList l) {
		Node node = l.head;
		if (n.data == node.data && n.next == node.next) {
			return;
		}
		while (node.next != null) {
			if (n.data == node.next.data && n.next == node.next.next) {
				node.next = node.next.next;
				//node = node.next;
			} else {
				node = node.next;
			}
		}
	}

}
