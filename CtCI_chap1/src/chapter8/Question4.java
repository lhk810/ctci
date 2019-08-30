package chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<HashSet<Integer>> findSubsets(HashSet<Integer> set, ArrayList<HashSet<Integer>> al, int from, int to) {
		if (!al.contains(set)) {
			al.add(set);
		}
		
		HashSet<Integer> newset = new HashSet<>();
		
		
		int target = (from + to)/2; //set은 순서가 유지되지 않는다. 어떻게하냐 이거
		
		
		
	}

}
