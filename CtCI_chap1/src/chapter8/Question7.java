package chapter8;

import java.util.ArrayList;

public class Question7 {

	public static void main(String[] args) {
		Question7 q7 = new Question7();
		ArrayList<String> res = q7.findPermutation("abcd");
		q7.printRes(res);

	}
	
	public ArrayList<String> findPermutation(String input) {
		ArrayList<String> result = new ArrayList<String>();
		
		computePermutation("", input, result);
		
		return result;
	}
	
	public void computePermutation(String input, String remainder, ArrayList<String> result) {
		if (remainder.length() == 0) {
			result.add(input);
			return;
		} else {
			for (int i=0; i<remainder.length(); i++) {
				computePermutation(input+String.valueOf(remainder.charAt(i)), remainder.substring(0, i) + remainder.substring(i+1, remainder.length()), result);
			}
		}
	}
	
	public void printRes(ArrayList<String> input) {
		for (int i=0; i<input.size(); i++) {
			System.out.println(input.get(i));
		}
	}

}
