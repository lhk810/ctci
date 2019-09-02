package chapter8;

import java.util.Stack;

public class Question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Stack<Integer> towerOfHanoi(int num) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Stack<Integer> stack3 = new Stack<>();
		
		for (int i=num; i>0; i--) {
			stack1.add(i);
		}
		
		
		
		return stack3;
	}	
	

}
