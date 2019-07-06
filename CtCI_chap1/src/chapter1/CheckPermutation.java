package chapter1;

import java.util.Arrays;

public class CheckPermutation {

	public static void main(String[] args) {
		CheckPermutation CP = new CheckPermutation();
		String ex1 = "asdfABCD";
		String ex2 = "asdfABCD";
		String ex3 = "qwetasdfg";
		
		System.out.println(CP.checkPermutation1(ex1, ex2));
		System.out.println(CP.checkPermutation1(ex1, ex3));
		System.out.println(CP.checkPermutation2(ex1, ex2));
		System.out.println(CP.checkPermutation2(ex1, ex3));

	}
	
	public boolean checkPermutation1(String input1, String input2) {
		
		char[] tmp1 = input1.toCharArray();
		char[] tmp2 = input2.toCharArray();
		
		Arrays.sort(tmp1);
		Arrays.sort(tmp2);
		
		if (Arrays.equals(tmp1, tmp2)) {
			return true;
		}
		
		return false;
	}
	
	public boolean checkPermutation2(String input1, String input2) {
		int[] check = new int[256];
		
		if (input1.length() != input2.length()) {
			return false;
		}
		
		for (int i=0; i<input1.length(); i++) {
			int val = input1.charAt(i);
			check[val]++;
		}
		
		for (int i=0; i<input2.length(); i++) {
			int val = input2.charAt(i);
			check[val]--;
			if (check[val]<0) {
				return false;
			}
		}
		
		return true;
	}

}
