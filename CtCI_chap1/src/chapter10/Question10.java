package chapter10;

import java.util.HashMap;

public class Question10 {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Question10 q10 = new Question10();
		q10.insertMap(5, map);
		q10.insertMap(1, map);
		q10.insertMap(4, map);
		q10.insertMap(4, map);
		q10.insertMap(5, map);
		q10.insertMap(9, map);
		q10.insertMap(7, map);
		q10.insertMap(13, map);
		q10.insertMap(3, map);
		
		System.out.println(q10.findRank(5, map));

	}
	
	public void insertMap(int n, HashMap<Integer, Integer> map) {
		if (map.containsKey(n)) {
			int val = map.get(n);
			map.put(n, val+1);
		} else {
			map.put(n, 1);
		}
	}
	
	public int findRank(int n, HashMap<Integer, Integer> map) {
		if (map.containsKey(n)) {
			int res = map.get(n) - 1;
			for (int key : map.keySet()) {
				if (key < n) {
					res += map.get(key);
				}
			}
			return res;
		} else {
			return -1;
		}
	}

}
