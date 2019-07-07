package chapter3;

import java.util.ArrayList;
import java.util.EmptyStackException;


public class Question3 {

	public static void main(String[] args) {
		Question3 q3 = new Question3();
		SetofStacks<Integer> stacks = q3.new SetofStacks<Integer>();
		stacks.setThreshold(3);
		for (int i=0; i<9; i++) {
			stacks.push(i);
		}
		for (int i=0; i<stacks.stacks.size(); i++) {
			stacks.stacks.get(i).printStack();
		}
		System.out.println("the last component is : " + stacks.pop());
		System.out.println();
		for (int i=0; i<stacks.stacks.size(); i++) {
			stacks.stacks.get(i).printStack();
		}
		
		System.out.println("the last component of first stack is : " + stacks.popat(0));
		

	}
	
	public class SetofStacks<T> {
		private int threshold;
		public void setThreshold(int input) {
			this.threshold = input;
		}
		
		ArrayList<SingleStack> stacks = new ArrayList<SingleStack>();
		
		public T pop() {
			if (!stacks.isEmpty()) {
				T item = (T) stacks.get(stacks.size()-1).pop();
				return item;
			} else {
				throw new EmptyStackException();
			}
		}
		
		public void push(T item){
			if (stacks.size()==0) {
				stacks.add(new SingleStack<T>());
				stacks.get(stacks.size()-1).push(item);
			} else {
				if (!stacks.get(stacks.size()-1).isFull()) {
					stacks.get(stacks.size()-1).push(item);
				} else {
					stacks.add(new SingleStack<T>());
					stacks.get(stacks.size()-1).push(item);
				}
			}
		}
		
		public T popat(int num) {
			return (T) stacks.get(num).pop();
		}
		
		public class SingleStack<T> {
			private class StackNode<T> {
				private T data;
				private StackNode<T> next;
				
				public StackNode(T data) {
					this.data = data;
				}
			}
			
			private int count = 0;
			
			private StackNode<T> top;
			
			public T pop() {
				if (top==null) throw new EmptyStackException();
				T item = top.data;
				top = top.next;
				count--;
				return item;
			}
			
			public void push(T item) {
				StackNode<T> t = new StackNode<T>(item);
				if (count < threshold) {
					t.next = top;
					top = t;
					count++;
				} else {
					System.out.println("The stack is full");
				}
			}
			
			public T peek() {
				if (top == null) throw new EmptyStackException();
				return top.data;
			}
			
			public boolean isEmpty() {
				return top == null;
			}
			
			public boolean isFull() {
				return count == threshold;
			}
			
			public void printStack() {
				StackNode<T> node = top;
				while (node != null) {
					System.out.println(node.data);
					node = node.next;
				}
			}
		}
		
		
		
	}

}

