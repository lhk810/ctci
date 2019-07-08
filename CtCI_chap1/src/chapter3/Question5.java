package chapter3;

public class Question5 {

	public static void main(String[] args) {
		HKStack<Integer> stack = new HKStack<>();
		stack.push(3);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.printStack();
		System.out.println();
		
		Question5 q5 = new Question5();
		q5.sort(stack).printStack();;

	}
	
	public HKStack<Integer> sort(HKStack<Integer> stackin) {
		HKStack<Integer> newstack = new HKStack<>();
		
		while (!stackin.isEmpty()) {
			int tmp = stackin.pop();
			while (!newstack.isEmpty() && newstack.peek()>tmp) {
				stackin.push(newstack.pop());
			}
			newstack.push(tmp);
		}
		
		while (!newstack.isEmpty()) {
			stackin.push(newstack.pop());
		}
		
		
		return stackin;
	}

}
