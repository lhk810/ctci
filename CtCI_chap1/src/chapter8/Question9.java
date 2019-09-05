package chapter8;

import java.util.ArrayList;

public class Question9 {

	public static void main(String[] args) {
		Question9 q9 = new Question9();
		ArrayList<String> res = q9.makeParen(3);
		q9.printRes(res);

	}
	
	public ArrayList<String> makeParen(int n) {
		ArrayList<String> res = new ArrayList<String>();
		
		computeParen(res, n, n, "");
		
		return res;
	}
	
	public void computeParen(ArrayList<String> list, int opens, int closes, String res) {
		if (opens == closes) {
			if (opens == 0) {
				list.add(res);
				return;
			} else {
				computeParen(list, opens-1, closes, res+"(");
			}
		} else if (opens < closes){
			if (opens > 0) {
				computeParen(list, opens-1, closes, res+"(");
				computeParen(list, opens, closes-1, res+")");
			} else {
				computeParen(list, opens, closes-1, res+")");
			}
		}
	}

	public void printRes(ArrayList<String> input) {
		for (int i=0; i<input.size(); i++) {
			System.out.println(input.get(i));
		}
	}
}
