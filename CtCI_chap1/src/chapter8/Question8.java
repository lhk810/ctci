package chapter8;

import java.util.ArrayList;
import java.util.HashMap;

public class Question8 {

	public static void main(String[] args) {
		Question8 q8 = new Question8();
		ArrayList<String> res = q8.findPermutation("aab");
		q8.printRes(res);

	}
	
	public ArrayList<String> findPermutation(String input) {
		ArrayList<String> result = new ArrayList<String>();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i=0; i<input.length(); i++) {
			if (map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i), map.get(input.charAt(i))+1);
			} else {
				map.put(input.charAt(i), 1);
			}
			
		}
		
		computePermutation(map, "", result);
		
		return result;
	}
	
	public void computePermutation(HashMap<Character, Integer> map, String res, ArrayList<String> result) {
		if (checkMap(map)) {
			result.add(res);
			return;
		}
		
		for (char key : map.keySet()) {
			if (map.get(key) != 0) {
				map.put(key, map.get(key)-1);
				computePermutation(map, res + Character.valueOf(key), result);
				map.put(key, map.get(key)+1);
			}
		}
		
		
	}
	
	public boolean checkMap(HashMap<Character, Integer> map) {
		for (char key : map.keySet()) {
			if (map.get(key) !=0 ) {
				return false;
			}
		}
		return true;
	}
	
	public void printRes(ArrayList<String> input) {
		for (int i=0; i<input.size(); i++) {
			System.out.println(input.get(i));
		}
	}

}
