package chapter2;

import java.util.HashSet;

import chapter2.HKLinkedList.Node;

public class Question8 {

	public static void main(String[] args) {
		HKLinkedList ll = new HKLinkedList();
		
		for (int i=0; i<10; i++) {
			ll.appendToTail(i);
		}
		
		Node begin = ll.head;
		for (int i=0; i<3; i++) {
			begin = begin.next;
		}
		
		Node n = ll.head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = begin;
		
		Question8 q8 = new Question8();
		
		q8.loopdetection1(ll).printNodedata();
		
		
		HKLinkedList ll2 = new HKLinkedList();
		for (int i=0; i<10; i++) {
			ll2.appendToTail(i);
		}
		System.out.println(q8.loopdetection1(ll2));
		

	}
	
	public Node loopdetection1(HKLinkedList ll) {
		HashSet<Node> set = new HashSet<HKLinkedList.Node>();
		Node n = ll.head;
		while (n != null) {
			if (set.contains(n)) {
				return n;
			} else {
				set.add(n);
				n = n.next;
			}
		}
		
		return null;
		
	}

}
