package chapter8;

import java.util.ArrayList;

public class Question14_fuckyou {

	public static void main(String[] args) {
		Question14_fuckyou q14 = new Question14_fuckyou();
		System.out.println(q14.parseString("1^0|0|1", true));

	}
	
	//////////////////////////////////////////////////////////////
	
	public int parseString(String s, boolean res) {
		int count = 0;
		if (s.length() == 1) {
			char bool;
			if (res == true) {
				bool = '1';
			} else {
				bool = '0';
			}
			if (s.charAt(0) == bool) {
				return 1;
			} else {
				return 0;
			}
		} else {
			count += parseString(s.substring(0,1),res);
			for (int i = 3; i<s.length(); i+=2) {
				String s1 = s.substring(0, i);
				String s2 = s.substring(i, s.length());
				count += parseString(s1, res) + parseString(evalString(s1)+s2, res);
			}
		}
		return count;
	}
	
	public String evalString(String target) {
		if (target.length()==1) {
			return target;
		}
		
		boolean res;
		if (target.charAt(0) == 0) {
			res = false;
		} else {
			res = true;
		}
		
		for (int i=1; i<target.length(); i+=2) {
			boolean tmp;
			if (target.charAt(i+1) == 0) {
				tmp = false;
			} else {
				tmp = true;
			}
			if (target.charAt(i) == '&') {
				res = res&tmp;
			} else if (target.charAt(i) == '|') {
				res = res|tmp;
			} else {
				res = res^tmp;
			}
		}
		
		if (res == true) {
			return "1";
		} else {
			return "0";
		}
	}
	

}
