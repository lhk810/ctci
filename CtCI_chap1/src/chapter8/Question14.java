package chapter8;

import java.util.ArrayList;

public class Question14 {

	public static void main(String[] args) {
		Question14 q14 = new Question14();
		q14.boolEval("l^1", false);

	}
	
	public int boolEval(String s, boolean res) {
		ArrayList<String> nums = new ArrayList<>();
		ArrayList<String> operators = new ArrayList<>();
		String num = "";
		String operator = "";
		for (int i=0; i<s.length(); i++) {
			if (i%2==0) {
				num += String.valueOf(s.charAt(i));
			} else {
				operator += String.valueOf(s.charAt(i));
			}
		}
		findPermutaion("", num, nums);
		findPermutaion("", operator, operators);
		return 0;
	}
	
	public void findPermutaion(String s, String remainder, ArrayList<String> list) {
		if (remainder.length() == 0) {
			list.add(s);
			System.out.println(s);
			return;
		} else {
			for (int i=0; i<remainder.length(); i++) {
				findPermutaion(s+String.valueOf(remainder.charAt(i)),  remainder.substring(0, i) + remainder.substring(i+1, remainder.length()), list);
			}
		}
		
	}
	
	public String assemble(String num, String operator) {
		String target = "";
		for (int i=0; i<operator.length(); i++) {
			target += String.valueOf(num.charAt(i));
			target += String.valueOf(operator.charAt(i));
		}
		target += target += String.valueOf(num.charAt(num.length()-1));
		return target;
	}
	
	public boolean evalString(String target) {
		
	}
	

}
