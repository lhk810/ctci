package chapter5;

public class Question3 {

	public static void main(String[] args) {
		Question3 q3 = new Question3();
		int input = Integer.parseInt("10011110111110011", 2);
		System.out.println(q3.findLength(input));

	}
	
	public int findLength(int n) {
		String input = Integer.toBinaryString(n);
		
		int pastlength = 0;
		int currentlength = 0;
		int maxlength = 1;
		int idx = 0;
		for (int i=0;i<input.length()-1;i++) {
			if (input.charAt(i)=='1') {
				currentlength++;
			} else {
				i++;
				pastlength = currentlength;
				currentlength = 0;
				if (input.charAt(i)=='1') {
					currentlength++;
				} else {
					pastlength = 0;
				}
			}
			idx = i;
			maxlength = Math.max(pastlength+currentlength+1, maxlength);
		}
		
		if (idx != input.length()-1) {
			idx++;
			if (input.charAt(idx)=='1') {
				currentlength++;
			} else {
				
			}
		}
		
		return Math.max(maxlength,  Math.max(pastlength+currentlength+1, maxlength));
	}

}
