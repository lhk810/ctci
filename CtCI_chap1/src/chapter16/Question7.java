package chapter16;

public class Question7 {

	public static void main(String[] args) {
		
		Question7 q7 = new Question7();
		
		int a = 11;
		int b = 5;
		
		System.out.println(q7.getMax(a, b));

	}

	/*
	 * (|a-b|/(a-b))*(a-b) + (a+b) = ?
	 * a<b : 2b
	 * a>b : 2a
	 * a==b Ã³¸® ¿ä¸Á
	 */
	
	public int getMax(int a, int b) {
		return ( (Math.abs(a-b)/(a-b))*(a-b) + (a+b) ) / 2;
	}
	
}
