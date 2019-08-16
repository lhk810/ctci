package chapter5;

public class Question6 {

	public static void main(String[] args) {
		int a = 1;
		int b = 5;
		Question6 q6 = new Question6();
		System.out.println(q6.convertCount(a, b));

	}
	
	public int convertCount(int a, int b) {
		int c = a^b;
		int count = 0;
		while (c!=0) {
			if ((c&1) == 1) {
				count++;
			}
			c>>=1;
		}
		return count;
	}

}
