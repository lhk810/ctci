package chapter8;

public class Question1 {

	public static void main(String[] args) {
		Question1 q1 = new Question1();
		System.out.println(q1.countStep(5));

	}
	
	public int countStep(int remainder) {
		return countStep(remainder, 1) + countStep(remainder, 2) + countStep(remainder, 3);
	}
	
	public int countStep(int remainder, int step) {
		int current = remainder - step;
		if (current == 0) {
			return 1;
		} else if (current < 0) {
			return 0;
		} else {
			return countStep(current, 1) + countStep(current, 2) + countStep(current, 3);
		}
	}
	
	//dynamic programming도 생각할 수 있어야 함

}
