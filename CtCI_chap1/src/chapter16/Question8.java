package chapter16;

import java.util.ArrayList;

public class Question8 {
	
	String[] first = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	String[] second = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	String[] third = {"", "Thousand", "Million", "Billion"};
	
	public static void main(String[] args) {
		Question8 q8 = new Question8();
		
		int input = 123123123;
		
		System.out.println(q8.numToEng(input));
	}
	
	public String numToEng(int n) {
		
		if (n == 0) {
			return "Zero";
		}
		
		String copyval = String.valueOf(n);
		int length = copyval.length();
		
		String res = "";
		
		//100,000,000,000
		if (length > 12) {
			res = "error : too big value";
			return res;
		}
		
		ArrayList<String> list = new ArrayList<>();
		
		int input = n;
		while (input>0) {
			int tmp = input%1000;
			String partres = dealWithThree(tmp);
			list.add(partres);
			input /= 1000;
		}
		
		for (int i=0; i<list.size(); i++) {
			if (i == 0) {
				res = list.get(i) + " " + third[i] + res;
			} else {
				if (list.get(i) != "") {
					res = list.get(i) + " " + third[i] + ", " + res;
				}
			}
			
		}
		
		res=res.trim();
		if (res.charAt(res.length()-1) == ',') {
			res = res.substring(0, res.length()-1);
		}
		return res.trim();
		
	}
	
	public String dealWithThree(int n) {
		
		if (n == 0) {
			return "";
		}
		
		String tmp = String.valueOf(n);
		String res = "";
		
		int firstone = n/100;
		if (firstone>0) {
			res += first[firstone] + " " + "Hundred";
		}

		//int lasttwo = Integer.parseInt(tmp.substring(1));
		int lasttwo = n%100;
		if (lasttwo == 0 && res != "") {
			return res;
		}
		if (lasttwo < 20) {
			res += " " + first[lasttwo];
		} else {
			if (lasttwo%10 != 0) {
				res += " " + second[lasttwo/10] + " " + first[lasttwo%10];
			} else {
				res += " " + second[lasttwo/10];
			}
			
		}


		
		return res;
	}

}
