package chapter5;

public class Question1 {

	public static void main(String[] args) {
		Question1 q1 = new Question1();
		
		int N = Integer.parseInt("10000000000", 2);
		int M = Integer.parseInt("10011", 2);
		
		System.out.println(Integer.toBinaryString(q1.insertion(N, M, 2, 6)));

	}
	
	public int insertion(int N, int M, int i, int j) {
		String NN = Integer.toBinaryString(N);
		String res = "";
		for (int k=0;k<NN.length();k++) {
			if (k>=i && k<=j) {
				res += "0";
			} else {
				res += NN.charAt(k);
			}
		}
		
		N = Integer.parseInt(res, 2);
		
		return N|(M<<i);
		
	}

}
