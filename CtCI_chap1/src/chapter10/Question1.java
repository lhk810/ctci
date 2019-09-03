package chapter10;

public class Question1 {

	public static void main(String[] args) {

		int[] a = new int[8];
		int[] b = new int[3];
		for (int i=0;i<3;i++) {
			a[i] = 2*i+1;
			b[i] = 2*(i+1);
		}
		
		Question1 q1 = new Question1();
		int[] res = q1.mergeArrays(a, b, 2);
		for (int i=0; i<res.length; i++) {
			System.out.println(i + " : " + res[i]);
		}

	}
	
	public int[] mergeArrays(int[] a, int[] b, int buffersize) {
		int[] res = new int[a.length];
		int len = a.length - buffersize;
		int idx1 = 0;
		int idx2 = 0;
		while (idx1+idx2<len-1) {
			if (a[idx1] < b[idx2]) {
				res[idx1+idx2] = a[idx1];
				idx1++;
			} else {
				res[idx1+idx2] = b[idx2];
				idx2++;
			}
		}
		if (idx1 < a.length - buffersize - b.length) {
			res[idx1 + idx2] = a[idx1];
		} else {
			res[idx1 + idx2] = b[idx2];
		}
				
		return res;
	}
	

}
