package chap1;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PalinedromePermutation {

	public static void main(String[] args) {
		String input1 = "taco cat";
		String input2 = "asd";
		String input3 = "abbba";
		String input4 = "zzzxx";
		String input5 = "zzzxxx";
		
		PalinedromePermutation PP = new PalinedromePermutation();
		
		System.out.println(PP.isPermutation(input1));
		System.out.println(PP.isPermutation(input2));
		System.out.println(PP.isPermutation(input3));
		System.out.println(PP.isPermutation(input4));
		System.out.println(PP.isPermutation(input5));

	}
	
	public boolean isPermutation(String input) {
		
		HashMap<Character,Integer> count = new HashMap();
		
		for (int i=0;i<input.length();i++) {
			if (input.charAt(i) != ' ') {
				if (count.containsKey(input.charAt(i))) {
					count.put(input.charAt(i), count.get(input.charAt(i))+1);
				} else {
					count.put(input.charAt(i), 1);
				}
			} else {
				continue;
			}
		}
		
		Set<Character> keyset = count.keySet();
		//System.out.println(keyset);
		
		int cnt_odd = 0;
		//int cnt_even = 0;
		Iterator<Character> it = keyset.iterator();

		while (it.hasNext()) {
			int val = count.get(it.next());
			if (val%2!=0) {
				cnt_odd++;
			}
		}
		
		if (cnt_odd>=2) {
			return false;
		} else {
			return true;
		}
		
		
	}

}
