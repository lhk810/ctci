package chapter11;

public class Question1 {

	public static void main(String[] args) {
		int a = 1; int b = 2;
		System.out.println("a : " + a + ", b : " + b);
		Question1 q1 = new Question1();
		q1.swapper(a, b);

	}
	
	public void swapper(int a, int b) {
		a += b;//a=a+b, b=b
		b = -(b - a);//a=a+b,b=
		a -=b;
		System.out.println("a : " + a + ", b : " + b);
	}

}
