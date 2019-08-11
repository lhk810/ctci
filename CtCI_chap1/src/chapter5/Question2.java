package chapter5;

public class Question2 {
	public static void main(String[] args) {
		Question2 q2 = new Question2();
		double input = 0;
		for (int i=1; i<=3; i++) {
			double num = 1;
			for (int j=1; j<=i; j++) {
				num /= 2;
			}
			input += num;
		}
		System.out.println(input);
		System.out.println(q2.toBinary(input));
	}
	
	public String toBinary(double input) {
		String res = ".";
		if (input >=1 || input <=0) {
			return "ERROR";
		}
		double divider = 1.0/2.0;
		while (res.length()<=32) {
			if (input - divider >=0) {
				res += "1";
			} else {
				res += "0";
			}
			input -= divider;
			divider /= 2.0;
			if (input == 0) {
				return res;
			}
		}
		return "ERROR";
	}
	
}
