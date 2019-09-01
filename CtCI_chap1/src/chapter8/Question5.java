package chapter8;

public class Question5 {

	public static void main(String[] args) {
		int a = 2;
		int b = 32;
		Question5 q5 = new Question5(); 
		System.out.println(q5.multiply(a, b));

	}
	
	public int multiply(int a, int b) {
		int[] saveRes;
		if (b > a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		saveRes = new int[Integer.toBinaryString(a).length()];
		saveRes[0] = a; 
		saveRes = fillRes(a, b, saveRes, 0);
		
		int res = 0;
		for (int i=0; i<Integer.toBinaryString(b).length(); i++) {
			if (((b>>i)&1) == 1) {
				res += saveRes[i];
			}
		}
		
		return res;
		
	}
	
	public int[] fillRes(int big, int small, int[] saveRes, int idx) {
		if (saveRes[Integer.toBinaryString(big).length()-1] != 0) {
			return saveRes;
		}
		
		idx++;
		saveRes[idx] = saveRes[idx-1] + saveRes[idx-1];
		return fillRes(big, small, saveRes, idx);
	}

}
