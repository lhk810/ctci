package chap3;

import java.util.EmptyStackException;

public class Question1 {

	public static void main(String[] args) {
		Question1 q1 = new Question1();
		Question1.SingleArrayStack mystack = q1. new SingleArrayStack();
		
		mystack.initialize(30);
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<5; j++) {
				mystack.push(i, j);
			}
		}
		
		mystack.printStack(2);
		mystack.pop(2);
		System.out.println();
		mystack.printStack(2);
		System.out.println();
		mystack.push(2, 10);
		mystack.printStack(2);
		
		

	}
	
	public class SingleArrayStack {
		int[] arraystack;
		int stacksize;
		int size1; int size2; int size3;
		int division;
		
		public void initialize(int n) {
			stacksize = n;
			arraystack = new int[stacksize];
			
			division = stacksize/3;
			size1 = size2 = size3 = 0;
			
		}
		
		public int pop(int stacknum) {
			if (stacknum == 1) {
				if (size1 == 0) {
					throw new EmptyStackException();
				} else {
					size1--;
					int data = arraystack[size1];
					return data;
				}
			} else if (stacknum == 2) {
				if (size2 == 0) {
					throw new EmptyStackException();
				} else {
					size2--;
					int data = arraystack[division + size2];
					return data;
				}
			} else {
				if (size3 == 0) {
					throw new EmptyStackException();
				} else {
					size3--;
					int data = arraystack[division*2 + size3];
					return data;
				}
			}
		
		}
		
		public void push(int stacknum, int data) {
			if (stacknum == 1) {
				if (size1 >= division) {
					System.out.println("stack is full");
				} else {
					arraystack[size1] = data;
					size1++;
				}
			} else if (stacknum == 2) {
				if (size2 >= division) {
					System.out.println("stack is full");
				} else {
					arraystack[division+size2] = data;
					size2++;
				}
			} else {
				if (size3 >= division) {
					System.out.println("stack is full");
				} else {
					arraystack[division*2+size3] = data;
					size3++;
				}
			}
		}
		
		public int peek(int stacknum) {
			if (stacknum == 1) {
				if (size1 == 0) {
					throw new EmptyStackException();
				} else {
					return arraystack[size1-1];
				}
			} else if (stacknum == 2) {
				if (size2 == 0) {
					throw new EmptyStackException();
				} else {
					return arraystack[division + size2-1];
				}
			} else {
				if (size3 == 0) {
					throw new EmptyStackException();
				} else {
					return arraystack[division*2 + size3-1];
				}
			}
		}
		
		public boolean isEmpty(int stacknum) {
			if (stacknum == 1) {
				if (size1 == 0) {
					return true;
				} else {
					return false;
				}
			} else if (stacknum == 2) {
				if (size2 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				if (size3 == 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		public void printStack(int stacknum) {
			if (stacknum == 1) {
				for (int i=0; i<size1; i++) {
					System.out.println(arraystack[i]);
				}
			} else if (stacknum == 2) {
				for (int i=division; i<division+size2; i++) {
					System.out.println(arraystack[i]);
				}
			} else {
				for (int i=division*2; i<division*2+size3; i++) {
					System.out.println(arraystack[i]);
				}
			}
		}
		
	}

}
