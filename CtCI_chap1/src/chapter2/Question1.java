package chapter2;

import java.util.HashSet;

public class Question1 {

	public static void main(String[] args) {
		HKLinkedList ll1 = new HKLinkedList();
		for (int i=0; i<7; i++) {
			ll1.appendToTail(i%2);
		}

		ll1.printLinkedList();
		System.out.println("===========");
		Question1 Q1 = new Question1();
		Q1.removedups(ll1);
		ll1.printLinkedList();
		System.out.println("===========");
		
		HKLinkedList ll2 = new HKLinkedList();
		ll2.appendToTail(0);
		for (int i=0; i<6; i++) {
			ll2.appendToTail(i);
		}
		
		ll2.printLinkedList();
		System.out.println("===========");
		Q1.removedups(ll2);
		ll2.printLinkedList();
		System.out.println("===========");

	}
	
	public void removedups(HKLinkedList L) {
		HashSet<Integer> set = new HashSet<Integer>();
		HKLinkedList.Node n = L.head;
		set.add(n.data);
		while (n.next != null) {
			if (set.contains(n.next.data)) {
				n.next = n.next.next;
			} else {
				set.add(n.data);
				n = n.next;
			}
		}
	}

}
