package chapter3;

import java.util.EmptyStackException;

public class Question2 {
	public static void main(String[] args) {
		Question2 q2 =  new Question2();
		MinStack stack = q2.new MinStack();
		
		stack.push(3);
		stack.push(2);
		stack.push(0);
		
		stack.printStack();
		System.out.println();
		System.out.println(stack.min);
		stack.pop();
		System.out.println();
		System.out.println(stack.min);
		
	}
	
	public class MinStack {
		private class StackNode {
			private int data;
			private StackNode next;
			
			public StackNode(int data) {
				this.data = data;
			}
		}
		
		private StackNode top;
		private int min = Integer.MAX_VALUE;
		private int min_prev = Integer.MAX_VALUE;
		
		public int min() {
			if (top==null) throw new EmptyStackException();
			return min;
		}
		
		public int pop() {
			if (top==null) throw new EmptyStackException();
			int item = top.data;
			if (top.data == min) {
				min = min_prev;
			}
			top = top.next;
			return item;
		}
		
		public void push(int item) {
			StackNode t = new StackNode(item);
			t.next = top;
			top = t;
			if (t.data < min) {
				min_prev = min;
				min = t.data;
			}
		}
		
		public int peek() {
			if (top == null) throw new EmptyStackException();
			return top.data;
		}
		
		public boolean isEmpty() {
			return top == null;
		}
		
		public void printStack() {
			StackNode node = top;
			while (node != null) {
				System.out.println(node.data);
				node = node.next;
			}
		}
	}
}
