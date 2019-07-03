package chapter2;

import chapter2.HKLinkedList.Node;

public class Question4 {

	public static void main(String[] args) {
		HKLinkedList ll1 = new HKLinkedList();
		ll1.appendToTail(5);
		ll1.appendToTail(1);
		ll1.appendToTail(2);
		ll1.appendToTail(7);
		ll1.appendToTail(4);
		
		Question4 q4 = new Question4();
		
		q4.partition(ll1, 5).printLinkedList();

	}
	
	public HKLinkedList partition(HKLinkedList input, int partition) {
		
		HKLinkedList left = new HKLinkedList();
		HKLinkedList right = new HKLinkedList();
		
		Node node = input.head;
		
		while (node != null) {
			if (node.data < partition) {
				left.appendToTail(node.data);
			} else {
				right.appendToTail(node.data);
			}
			node = node.next;
		}
		
		node = left.head;
		while (node.next != null) {
			node = node.next;
		}
		
		node.next = right.head;
		
		return left;
	}

}
