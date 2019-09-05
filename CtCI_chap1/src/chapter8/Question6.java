package chapter8;

import java.util.Stack;

public class Question6 {

	public static void main(String[] args) {
		Question6 q6 = new Question6();
		Stack<Integer> result = q6.towerOfHanoi(4);
		q6.printTower(result);
	}
	
	public Stack<Integer> towerOfHanoi(int num) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Stack<Integer> stack3 = new Stack<>();
		
		for (int i=num; i>0; i--) {
			stack1.add(i);
		}
		
		moveTower(stack1, stack2, stack3, num);
		
		return stack3;
	}	
	
	public void moveTower(Stack<Integer> from, Stack<Integer> middle, Stack<Integer> to, int num) {
		if (num == 1) {
			to.add(from.pop());
			return;
		} else {
			moveTower(from, to, middle, num-1);
			to.add(from.pop());
			moveTower(middle, from, to, num-1);
		}
		
	}
	
	public void printTower(Stack<Integer> stack) {
		if (stack.size() == 0) {
			System.out.println("stack is already empty");
		}
		
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
	}

}
