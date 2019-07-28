package chapter4;

import java.util.HashMap;

public class Question12 {
	public static void main(String[] args) {
		HKTree tree = new HKTree();
		tree.root = new HKTreeNode(1);
		tree.root.setLeft(new HKTreeNode(1));
		tree.root.setRight(new HKTreeNode(1));
		tree.root.right.setLeft(new HKTreeNode(1));
		tree.root.right.setRight(new HKTreeNode(1));
		tree.PrintTree(tree.root);
		
		Question12 q12 = new Question12();
		System.out.println(q12.findPath(tree.root, 2));
		
	}
	
	public int findPathFail(HKTreeNode n, int current, int target, int res) {
		if (n == null) {
			return 0;
		} else {
			res = 0;
			if (current + n.data == target) {
				res++;
				//res += findPath(n.left, n.data, target, res);
				//res += findPath(n.right, n.data, target, res);
			}
			res += findPathFail(n.left, current+n.data, target, res);
			res += findPathFail(n.right, current+n.data, target, res);
		}
		return res;
	}
	
	public int findPath(HKTreeNode root, int target) {
		return findPath(root, target, 0, new HashMap<Integer, Integer>());
	}
	
	public int findPath(HKTreeNode n, int target, int current, HashMap<Integer, Integer> path) {
		if (n == null) {
			return 0;
		}
		
		current += n.data;
		int cur = current - target;
		int total = path.getOrDefault(cur, 0);
		
		if (current == target) {
			total++;
		}
		
		incrementHashTable(path, current, 1);
		total += findPath(n.left, target, current, path);
		total += findPath(n.right, target, current, path);
		incrementHashTable(path, current, -1);
		
		return total;
		
	}
	
	public void incrementHashTable(HashMap<Integer, Integer> map, int key, int delta) {
		int newCount = map.getOrDefault(key, 0) + delta;
		if (newCount == 0) {
			map.remove(key);
		} else {
			map.put(key, newCount);
		}
	}
	
	

}
