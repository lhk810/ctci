package chapter2;

import java.util.Stack;

import chapter2.HKLinkedList.Node;

public class Question6 {

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
		
		Question6 q6 = new Question6();
		
		System.out.println(q6.isPalindrome(ll1));
		System.out.println(q6.isPalindrome(ll2));

	}
	
	public boolean isPalindrome(HKLinkedList ll) {
		
		Stack<Integer> stack = new Stack<Integer>();
		Node n = ll.head;
		int len = 0;
		
		while (n != null) {
			n = n.next;
			len++;
		}
		
		n = ll.head;
		
		for (int i=0; i<len/2; i++) {
			stack.add(n.data);
			n = n.next;
		}
		
		if (len%2 != 0) {
			n = n.next;
			for (int i = len/2 + 1; i<len; i++) {
				int d1 = stack.pop();
				int d2 = n.data;
				if (d1 == d2) {
					n = n.next;
				}
				else {
					return false;
				}
			}
		} else {
			for (int i = len/2; i<len; i++) {
				int d1 = stack.pop();
				int d2 = n.data;
				if (d1 == d2) {
					n = n.next;
				}
				else {
					return false;
				}
			}
		}
		
		
		
		return true;
	}

}
