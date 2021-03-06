package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Question9 {

	public static void main(String[] args) {
		Question2 q2 = new Question2();
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 7;
		arr[4] = 11;
		//arr[5] = 13;
		//arr[6] = 15;
		//arr[7] = 18;
		//arr[8] = 22;
		HKTreeNode n = q2.makeTree(arr, 0, arr.length-1);
		HKTree tree = new HKTree();
		tree.root = n;
		tree.PrintTree(tree.root);
		
		Question9 q9 = new Question9();
		ArrayList<ArrayList<Integer>> list = q9.listofarray(tree.root);
		
		/*
		for (int i=0; i<list.size(); i++) {
			for (int j=0; j<list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
		*/
		ArrayList<LinkedList<Integer>> res = q9.allSequences(tree.root);
		for (int i=0; i<res.size(); i++) {
			for (int j=0; j<res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
	}
	
	public ArrayList<ArrayList<Integer>> listofarray(HKTreeNode root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sublist = new ArrayList<Integer>();
		sublist.add(root.data);
		
		makelist(root, list, sublist);
		
		return list;
		
		
	}
	
	public void makelist(HKTreeNode root, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> sublist) {
		
		/*
		if (root.left == null && root.right == null) {
			return;
		}
		*/
		
		/*
		if (root.right == null && root.left != null) {
			ArrayList<Integer> left_only = copylist(sublist);
			left_only.add(root.left.data);
			list.add(left_only);
			makelist(root.left, list, left_only);
		} else if (root.left == null && root.right != null) {
			ArrayList<Integer> right_only = copylist(sublist);
			right_only.add(root.right.data);
			list.add(right_only);
			makelist(root.right, list, right_only);
		} else {
			//add left subtree
			ArrayList<Integer> left_first = copylist(sublist);
			left_first.add(root.left.data);
			makelist(root.left, list, left_first);
			left_first.add(root.right.data);
			makelist(root.right, list, left_first);
			list.add(left_first);
			
			//add right subtree
			ArrayList<Integer> right_first = copylist(sublist);
			right_first.add(root.right.data);
			makelist(root.right, list, right_first);
			right_first.add(root.left.data);
			makelist(root.left, list, right_first);
			list.add(right_first);
		}
		*/
		if (root.left != null && root.right != null) {
			ArrayList<Integer> left_first = copylist(sublist);
			left_first.add(root.left.data);
			makelist(root.left, list, left_first);
			left_first.add(root.right.data);
			makelist(root.right, list, left_first);
			list.add(left_first);
			
			//add right subtree
			ArrayList<Integer> right_first = copylist(sublist);
			right_first.add(root.right.data);
			makelist(root.right, list, right_first);
			right_first.add(root.left.data);
			makelist(root.left, list, right_first);
			list.add(right_first);
		} else if (root.left == null && root.right != null) {
			sublist.add(root.right.data);
			makelist(root.right, list, sublist);
			//list.add(sublist);
		} else if (root.right == null && root.left != null) {
			sublist.add(root.left.data);
			makelist(root.right, list, sublist);
			//list.add(sublist);
		}
		
		
	}
	
	public ArrayList<Integer> copylist(ArrayList<Integer> sublist) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i=0; i<sublist.size(); i++) {
			res.add(sublist.get(i));
		}
		return res;
	}
	
	
	//solution below here
	ArrayList<LinkedList<Integer>> allSequences(HKTreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.data);
		
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;

		
	}
	
	public void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}


}
