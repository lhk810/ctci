package chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Question4 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		//set.add(4);
		
		Question4 q4 = new Question4();
		
		ArrayList<HashSet<Integer>> result = q4.findSubsets(set);
		
		q4.printResult(result);

	}
	
	public ArrayList<HashSet<Integer>> findSubsets(HashSet<Integer> set) {
		
		ArrayList<Integer> setToArrayList = new ArrayList<Integer>();
		
		Iterator<Integer> iter = set.iterator();
		
		while (iter.hasNext()) {
			setToArrayList.add(iter.next());
		}
		
		ArrayList<ArrayList<Integer>> wholeList = new ArrayList<ArrayList<Integer>>();
		wholeList.add(new ArrayList<Integer>());
		
		wholeList = makeSubsets(wholeList, setToArrayList, 0);
		
		ArrayList<HashSet<Integer>> result = new ArrayList<HashSet<Integer>>();
		
		for (int i=0; i<wholeList.size(); i++) {
			HashSet<Integer> newset = new HashSet<Integer>();
			for (int j=0; j<wholeList.get(i).size(); j++) {
				newset.add(wholeList.get(i).get(j));
			}
			result.add(newset);
		}
		
		return result;
	}
	
	public ArrayList<ArrayList<Integer>> makeSubsets(ArrayList<ArrayList<Integer>> wholeList, ArrayList<Integer> setToArrayList, int idx) {
		
		if (setToArrayList.size() == idx) {
			//∫Û∞≈√ﬂ∞°?
			return wholeList;
		}
		
		idx++;
		int size = wholeList.size();
		for (int i=0; i<size; i++) {
			ArrayList<Integer> copytarget = wholeList.get(i);
			ArrayList<Integer> newlist = new ArrayList<Integer>();
			for (int j=0;j<copytarget.size();j++) {
				newlist.add(copytarget.get(j));
			}
			newlist.add(setToArrayList.get(idx-1));
			wholeList.add(newlist);
		}
		
		return makeSubsets(wholeList, setToArrayList, idx);
		
	}
	
	public void printResult(ArrayList<HashSet<Integer>> result) {
		for (int i=0; i<result.size(); i++) {
			System.out.print("The set has : ");
			HashSet<Integer> set = result.get(i);
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				System.out.print(iter.next() + " ");
			}
			System.out.println();
		}
	}

}
