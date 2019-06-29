package chapter2;

import java.util.HashSet;

public class Question1 {

	public static void main(String[] args) {
		HKLinkedList ll1 = new HKLinkedList();
		for (int i=0; i<8; i++) {
			ll1.appendToTail(i%2);
		}

		ll1.printLinkedList();
		System.out.println("===========");
		Question1 Q1 = new Question1();
		Q1.removedupsnobuffer(ll1);
		ll1.printLinkedList();
		System.out.println("===========");
		
		HKLinkedList ll2 = new HKLinkedList();
		ll2.appendToTail(0);
		for (int i=0; i<6; i++) {
			ll2.appendToTail(i);
		}
		
		ll2.printLinkedList();
		System.out.println("===========");
		Q1.removedupsnobuffer(ll2);
		ll2.printLinkedList();
		System.out.println("===========");
		

	}
	
	public void removedups(HKLinkedList L) {
		if (L.head.next == null) {
			return;
		}
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
	
	public void removedupsnobuffer(HKLinkedList L) {
		if (L.head.next == null) {
			return;
		}
		HKLinkedList.Node i = L.head;
		HKLinkedList.Node j = L.head;
		while (i != null) {
			j = i;
			while (j.next != null) {
				if (i.data == j.next.data) {
					j.next = j.next.next;
				} else {
					j = j.next;
				}
			}
			//System.out.println("--debug--");
			//L.printLinkedList();
			//System.out.println("--debug--");
			i = i.next;
		}
		
	}

}
