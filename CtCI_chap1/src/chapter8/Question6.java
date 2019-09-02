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
	
	//n-1만큼을 보조기둥에 옮겨둔다
	//n크기의 원반을 마지막으로 옮긴다
	//1번을 보조 기둥으로 n-1만큼을 다시 위 과정 반복한다

}
