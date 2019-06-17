package chap1;

public class StringCompression {

	public static void main(String[] args) {
		StringCompression SC = new StringCompression();
		String ex1 = "aaaaaaaabcdefg";
		String ex2 = "aaaabbbccccccdefgggggg";
		String ex3 = "aaaaaaaaa";
		System.out.println(SC.compress(ex1));
		System.out.println(SC.compress(ex2));
		System.out.println(SC.compress(ex3));

	}
	
	public String compress(String input) {
		char[] res = new char[input.length()];
		char tmp = ' ';
		int cnt = 1;
		int idx = 0;
		
		for (int i=0; i<input.length()-1; i++) {
			tmp = input.charAt(i);
			if (idx + 2> input.length()) {
				System.out.println("input length : " + input.length());
				return input;
			}
			if (input.charAt(i)!=input.charAt(i+1) ) {
				res[idx] = tmp;
				//System.out.println(res[idx]);
				idx++;
				res[idx] = Character.forDigit(cnt, 10);
				//System.out.println(res[idx]);
				idx++;
				cnt = 1;
			} else {
				cnt++;
			}
			
		}
		if (idx + 2 > input.length()) {
			System.out.println("input length : " + input.length());
			return input;
		}
		res[idx] = tmp;
		idx++;
		res[idx] = Character.forDigit(cnt, 10);
		
		System.out.println("res length : " + String.copyValueOf(res).trim().length());
		System.out.println("input length : " + input.length());
		return String.copyValueOf(res);
	}

}
