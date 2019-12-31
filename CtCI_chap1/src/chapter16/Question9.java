package chapter16;

public class Question9 {

	public static void main(String[] args) {
		Question9 q9 = new Question9();
		
		System.out.println(q9.add(10, 1));
		System.out.println(q9.subtract(2, 3));
		System.out.println(q9.multiply(2, 3));
		System.out.println(q9.divde(11, 3));

	}
	
	public int add(int a, int b) {
		return a+b;
	}
	
	private int negative(int n) {
		int res = 0;
		for (int i=0; i<n; i++) {
			res = add(res, -1);
		}
		return res;
	}
	
	public int subtract(int a, int b) {
		return a+negative(b);
	}
	
	public int multiply(int a, int b) {
		int res = 0;
		if (b==0) {
			return res;
		}
		/*
		for (int i=0; i<b; i++) {
			res = add(res, a);
		}
		*/
		int cnt = 0;
		while (cnt < b) {
			res = add(res, a);
			cnt++;
		}
		return res;
	}
	
	public int divde(int a, int b) {
		if (b==0) {
			throw new ArithmeticException("error");
		}
		int res = 0;
		if (a<b) {
			return 0;
		} else { 
			while (a>=b) {
				a = subtract(a,b);
				res = add(res,1);
			}
		}
		return res;
	}

}
