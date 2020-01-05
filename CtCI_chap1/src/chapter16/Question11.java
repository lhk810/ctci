package chapter16;

import java.util.HashSet;
import java.util.Iterator;

public class Question11 {

	public static void main(String[] args) {
		Question11 q11 = new Question11();
		
		HashSet<Integer> length = q11.getAllLength(5, 1, 2);
		Iterator<Integer> iter = length.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}
	
	public HashSet<Integer> getAllLength(int k, int shorter, int longer) {
		HashSet<Integer> length = new HashSet<Integer>();
		
		for (int i=0; i<=k; i++) {
			int leng = i*shorter + (k-i)*longer;
			length.add(leng);
		}
		
		return length;
	}
	

}
