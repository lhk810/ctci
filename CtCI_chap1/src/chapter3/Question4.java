package chapter3;

import java.util.NoSuchElementException;

public class Question4 {

	public static void main(String[] args) {
		Question4 q4 = new Question4();
		MyQueue<Integer> queue = q4.new MyQueue<Integer>();
		
		for (int i=0; i<5; i++) {
			queue.add(i);
		}
		
		System.out.println(queue.remove());
		queue.add(0);
		System.out.println(queue.remove());
		queue.add(1);
		System.out.println(queue.peek());

	}
	
	public class MyQueue<T> {
		HKStack<T> stackin = new HKStack<T>();
		HKStack<T> stackout = new HKStack<T>();
		
		public void add(T item) {
			stackin.push(item);
		}
		
		public T remove() {
			if (stackout.isEmpty()) {
				if (stackin.isEmpty()) {throw new NoSuchElementException();}
				else {
					while (!stackin.isEmpty()) {
						stackout.push(stackin.pop());
					}
					return stackout.pop();
				}
			} else {
				return stackout.pop();
			}
			
		}
		
		public T peek() {
			if (stackout.isEmpty()) {
				if (stackin.isEmpty()) {throw new NoSuchElementException();}
				else {
					while (!stackin.isEmpty()) {
						stackout.push(stackin.pop());
					}
					return stackout.peek();
				}
			} else {
				return stackout.peek();
			}
		}
		
		public boolean isEmpty() {
			return stackout == null && stackin == null;
		}
	}

}
