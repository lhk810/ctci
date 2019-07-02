package chapter2;

import chapter2.HKLinkedList.Node;

public class Question2 {

	public static void main(String[] args) {
		HKLinkedList ll1 = new HKLinkedList();
		for (int i=0; i<8; i++) {
			ll1.appendToTail(i);
		}
		
		ll1.printLinkedList();
		
		System.out.println();
		Question2 q2 = new Question2();
		
		q2.kthtoLast(ll1, 8).printNodedata();
		System.out.println("print all");
		q2.kthtoLastList(ll1, 8).printLinkedList();
		System.out.println();
		q2.kthtoLast(ll1, 7).printNodedata();
		System.out.println("print all");
		q2.kthtoLastList(ll1, 7).printLinkedList();
		System.out.println();
		q2.kthtoLast(ll1, 3).printNodedata();
		System.out.println("print all");
		q2.kthtoLastList(ll1, 3).printLinkedList();
		System.out.println();
		q2.kthtoLast(ll1, 1).printNodedata();
		System.out.println("print all");
		q2.kthtoLastList(ll1, 1).printLinkedList();
		System.out.println();
		

	}
	
	public Node kthtoLast(HKLinkedList L, int k) {
		
		Node node = L.head;
		Node returnnode = L.head;
		int index = 0;
		
		/*
		if (L.head.next == null) {
			if (k == 0) {
				return node;
			} else {
				return null;
			}
		}
		*/
		
		while (node != null ) {
			node = node.next;
			index++;
		}
		
		//System.out.println("the length : " + index);
		
		
		for (int i=0; i<index-k; i++) {
			returnnode = returnnode.next;
		}
		
		return returnnode;
	}
	
public HKLinkedList kthtoLastList(HKLinkedList L, int k) {
		
		Node node = L.head;
		Node returnnode = L.head;
		HKLinkedList returnlist = new HKLinkedList();
		int index = 0;
		
		if (L.head.next == null) {
			if (k == 0) {
				return L;
			} else {
				return null;
			}
		}
		
		while (node != null ) {
			if (node == null) {
				return null;
			}
			node = node.next;
			index++;
		}
		
		//System.out.println("the length : " + index);
		
		for (int i=0; i<index-k; i++) {
			returnnode = returnnode.next;
		}
		//returnlist.appendToTail(returnnode.data);
		for (int i=index-k; i<index; i++) {
			returnlist.appendToTail(returnnode.data);
			returnnode = returnnode.next;
		}
		
		return returnlist;
	}

}
