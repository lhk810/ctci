package chapter16;

import java.util.Arrays;

public class Question6 {

	public static void main(String[] args) {
		Question6 q6 = new Question6();
		int[] a = {11,2,1,15};
		int[] b = {4, 19, 12, 235, 127, 23};
		
		System.out.println(q6.minDiff(a, b));

	}
	
	//첨엔 O(mn) 밖에 생각못했음
	public int minDiff(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		
		int i = 0;
		int j = 0;
		
		int res = Integer.MAX_VALUE;
		
		while (i<a.length && j<b.length) {
			res = Math.min(res, Math.abs(a[i]-b[j]));
			if (a[i] > b[j]) {
				j++;
			} else {
				i++;
			}
		}
		
		
		return res;
	}

}
