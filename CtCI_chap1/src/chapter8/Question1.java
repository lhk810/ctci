package chapter8;

public class Question1 {

	public static void main(String[] args) {
		Question1 q1 = new Question1();
		System.out.println(q1.countStep(4));

	}
	
	public int countStep(int remainder) {
		return countStep(remainder, 1, 0) + countStep(remainder, 2, 0) + countStep(remainder, 3, 0);
	}
	
	public int countStep(int remainder, int step, int count) {
		int current = remainder - step;
		if (current == 0) {
			return ++count;
		} else if (current < 0) {
			return count;
		} else {
			return countStep(current, 1, 0) + countStep(current, 2, 0) + countStep(current, 3, 0);
		}
	}

}
