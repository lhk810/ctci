package chapter2;

import chapter2.HKLinkedList.Node;

public class Question5 {

	public static void main(String[] args) {
		HKLinkedList ll1 = new HKLinkedList();
		HKLinkedList ll2 = new HKLinkedList();
		
		ll1.appendToTail(7);
		ll1.appendToTail(1);
		ll1.appendToTail(6);
		
		ll2.appendToTail(5);
		ll2.appendToTail(9);
		ll2.appendToTail(2);
		
		Question5 q5 = new Question5();
		
		q5.sumList(ll1, ll2).printLinkedList();
		
		System.out.println();
		
		HKLinkedList ll3 = new HKLinkedList();
		HKLinkedList ll4 = new HKLinkedList();
		
		ll3.appendToTail(6);
		ll3.appendToTail(1);
		ll3.appendToTail(7);
		
		ll4.appendToTail(2);
		ll4.appendToTail(9);
		ll4.appendToTail(5);
		
		q5.sumListRev(ll3, ll4).printLinkedList();

	}
	
	public HKLinkedList sumList(HKLinkedList ll1, HKLinkedList ll2) {
		
		Node n1 = ll1.head;
		Node n2 = ll2.head;
		
		HKLinkedList res = new HKLinkedList();
		
		int next = 0;
		while (n1 != null || n2 != null) {
			int data1 = 0;
			int data2 = 0;
			
			int remainder = 0;
			
			if (n1 != null) { 
				data1 = n1.data;
				n1 = n1.next;
			}
			if (n2 != null) {
				data2 = n2.data;
				n2 = n2.next;
			}
			
			remainder = (data1 + data2 + next)%10;
			
			res.appendToTail(remainder);
			
			next = (data1 + data2 + next)/10;
			//System.out.println("next : "+ next);
			
		}
		
		if (next == 1) {
			res.appendToTail(next);
		}
		
		return res;
	}
	
	public HKLinkedList sumListRev(HKLinkedList ll1, HKLinkedList ll2) {
		HKLinkedList res = new HKLinkedList();
		
		int n1 = getNumber(ll1);
		int n2 = getNumber(ll2);
		
		res = numtolist(n1+n2);
		
		
		/*
		int len1 = 0;
		int len2 = 0;
		
		Node n1 = ll1.head;
		Node n2 = ll2.head;
		
		while (n1 != null) {
			len1++;
			n1 = n1.next;
		}
		
		while (n2 != null) {
			len2++;
			n2 = n2.next;
		}
		
		n1 = ll1.head;
		n2 = ll2.head;
		
		while (n1 != null || n2 != null) {
			int data1 = 0;
			int data2 = 0;
			
			if (n1 != null) { 
				data1 = n1.data;
				n1 = n1.next;
			}
			if (n2 != null) {
				data2 = n2.data;
				n2 = n2.next;
			}
			
		}
		*/
		
		
		return res;
	}
	
	public int getNumber(HKLinkedList ll) {
		Node n = ll.head;
		int len = 0;
		int res = 0;
		
		while (n!=null) {
			len++;
			n = n.next;
		}
		
		n = ll.head;
		
		while (len>0) {
			int digit = 1;
			for (int i=1;i<len;i++) {
				digit *= 10;
			}
			res += n.data*digit;
			n = n.next;
			len--;
		}
		
		//System.out.println(res);
		
		return res;
	}
	
	public HKLinkedList numtolist(int n) {
		HKLinkedList res = new HKLinkedList();
		
		int finder = n;
		int len = 0;
		while (finder != 0) {
			finder /= 10;
			len++;
		}
		
		while (len > 0) {
			int digit = 1;
			for (int i=1;i<len;i++) {
				digit *= 10;
			}
			int data = n/digit;
			res.appendToTail(data);
			n -= data*digit;
			len--;
		}
		
		return res;
	}
	

}
