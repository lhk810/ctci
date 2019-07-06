package chapter1;

public class OneAway {

	public static void main(String[] args) {
		OneAway OA = new OneAway();
		
		System.out.println(OA.checkStrings("pale", "pale"));
		System.out.println(OA.checkStrings("ple", "pale"));
		System.out.println(OA.checkStrings("pale", "ple"));
		System.out.println(OA.checkStrings("pale", "bale"));
		System.out.println(OA.checkStrings("pale", "pe"));
		System.out.println(OA.checkStrings("thisis", "isish"));
		System.out.println(OA.checkStrings("thisis", "th"));

	}
	
	public boolean checkStrings(String input1, String input2) {
		
		if (input1.equals(input2)) {
			return true;
		}
		
		boolean res = false;
		
		input1 = input1.toLowerCase();
		input2 = input2.toLowerCase();
		
		if (input1.length() == input2.length()) {
			res =  this.isReplaced(input1, input2);
		} else if (input1.length() == input2.length()+1) {
			res = this.isDeletedOrInserted(input1, input2);
		} else if (input1.length() == input2.length()-1) {
			res = this.isDeletedOrInserted(input2, input1);
		}
		
		return res;
	}
	
	public boolean isReplaced(String input1, String input2) {
		
		char[] in1 = new char[input1.length()];
		char[] in2 = new char[input2.length()];
		
		in1 = input1.toCharArray();
		in2 = input2.toCharArray();
		
		int cnt = 0;
		
		for (int i=0;i<input1.length();i++) {
			if (in1[i]!=in2[i]) {
				cnt++;
			}
		}
		
		if (cnt == 1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean isDeletedOrInserted(String input1, String input2) {
		
		int idx1 = 0;
		int idx2 = 0;
		int cnt = 1;
		
		while (idx2<input2.length()) {
			if (input1.charAt(idx1) == input2.charAt(idx2)) {
				idx1++;
				idx2++;
			} else {
				idx1++;
				cnt--;
				if (cnt<0) {
					return false;
				}
			}
		}
		
		if (cnt>=0) {
			return true;
		} else {
			return false;
		}
		
		/*
		int[] check = new int[256];
		
		for (int i=0;i<input1.length();i++) {
			int val = input1.charAt(i);
			check[val]++;
		}
		
		for (int i=0;i<input2.length();i++) {
			int val = input2.charAt(i);
			check[val]--;
			if (check[val]<0) {
				return false;
			}
		}
		
		int cnt = 0;
		for (int i=0;i<check.length;i++) {
			cnt += check[i];
		}
		
		if (cnt==1) {
			return true;
		} else {
			return false;
		}
		*/
		
	}

}
