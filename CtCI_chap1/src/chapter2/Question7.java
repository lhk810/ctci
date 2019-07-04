package chapter2;

import chapter2.HKLinkedList.Node;

public class Question7 {

	public static void main(String[] args) {
		HKLinkedList ll1 = new HKLinkedList();
		ll1.appendToTail(1);
		ll1.appendToTail(2);
		ll1.appendToTail(1);
		ll1.appendToTail(2);
		ll1.appendToTail(3);
		
		HKLinkedList ll2 = new HKLinkedList();
		ll2.appendToTail(1);
		ll2.appendToTail(2);
		ll2.appendToTail(2);
		ll2.appendToTail(1);
		
		Question7 q7 =  new Question7();
		System.out.println(q7.isintersected(ll1, ll2));
		
		HKLinkedList ll3 = new HKLinkedList();
		ll3.appendToTail(1);
		ll3.appendToTail(1);
		ll3.appendToTail(2);
		
		HKLinkedList ll4 = new HKLinkedList();
		ll4.appendToTail(0);
		ll4.appendToTail(1);
		ll4.head.next.next = ll3.head;
		
		System.out.println(q7.isintersected(ll3, ll4));

	}
	
	public boolean isintersected(HKLinkedList ll1, HKLinkedList ll2) {
		
		Node n1 = ll1.head;
		int len1 = 0;
		int len2 = 0;
		
		while (n1 != null) {
			n1 = n1.next;
			len1++;
		}
		
		Node n2 = ll2.head;
		
		while (n2 != null) {
			n2 = n2.next;
			len2++;
		}
		
		n1 = ll1.head;
		n2 = ll2.head;
		
		for (int i=1;i<len1-1;i++) {
			n1 = n1.next;
		}
		
		for (int i=1;i<len2-1;i++) {
			n2 = n2.next;
		}
		
		if (n1.next.equals(n2.next)) {
			return true;
		}
		
		
		return false;
	}

}
