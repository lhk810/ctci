package chapter1;

public class StringRotation {

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		String s3 = "erbottletaw";
		
		StringRotation SR = new StringRotation();
		
		System.out.println(SR.isRotation(s1, s2));
		System.out.println(SR.isRotation(s1, s3));

	}
	
	public boolean isRotation(String input1, String input2) {
		
		if (input1.length() != input2.length()) {return false;}
		if (isSubstring(input1+input1, input2)) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean isSubstring(String input1, String input2) {
		
		int len1 = input1.length();
		int len2 = input2.length();
		
		int cnt = 0;
		
		for (int i=0; i<len1; i++) {
			if (input1.charAt(i) == input2.charAt(cnt)) {
				cnt ++;
			} else {
				cnt = 0;
			}
			
			if (cnt == len2) {
				return true;
			}
		}
		
		if (cnt == len2) {
			return true;
		} else {
			return false;
		}
		
	}
	

}
