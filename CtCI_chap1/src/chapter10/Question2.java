package chapter10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question2 {

	public static void main(String[] args) {
		String[] array = new String[5];
		
		array[0] = "aba";
		array[1] = "aab";
		array[2] = "abc";
		array[3] = "bcd";
		array[4] = "cba";
		
		Question2 q2 = new Question2();
		array = q2.sortByAnagram(array);
		
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}

	}
	
	public String[] sortByAnagram(String[] array) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (int i=0; i<array.length; i++) {
			ArrayList<String> list;
			if (map.containsKey(sortString(array[i]))) {
				list = map.get(sortString(array[i]));
				list.add(array[i]);
				
			} else {
				list = new ArrayList<>();
				list.add(array[i]);
				
			}
			map.put(sortString(array[i]), list);
			//map.put(sortString(array[i]), i);
		}
		
		String[] res = new String[array.length];
		int idx = 0;
		for (String key : map.keySet()) {
			for (int i=0; i<map.get(key).size(); i++) {
				res[idx] = map.get(key).get(i);
				idx++;
			}
		}
		
		return res;
		
	}
	
	public String sortString(String input) {
		char[] charArray = input.toCharArray();
		char[] helper = new char[charArray.length];
		mergeSort(charArray, helper, 0, charArray.length-1);
		
		return String.copyValueOf(charArray);
	}
	
	private void mergeSort(char[] charArray, char[] helper, int low, int high) {
		if (low<high) {
			int middle = (low + high)/2;
			mergeSort(charArray, helper, low, middle);
			mergeSort(charArray, helper, middle+1, high);
			merge(charArray,helper,low,middle,high);
		}
	}
	
	private void merge(char[] charArray, char[] helper, int low, int middle, int high) {
		for (int i=low; i<=high; i++) {
			helper[i] = charArray[i];
		}
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				charArray[current] = helper[helperLeft];
				helperLeft++;
			} else {
				charArray[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		int remaining = middle-helperLeft;
		for (int i=0; i<= remaining; i++) {
			charArray[current+i] = helper[helperLeft+i];
		}
		
	}

}
