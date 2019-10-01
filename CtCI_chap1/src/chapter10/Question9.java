package chapter10;

import java.util.ArrayList;
import java.util.HashMap;

//다시 하기
public class Question9 {

	public static void main(String[] args) {
		int[][] array = new int[4][4];
		array[0][0] = 15;
		array[1][0] = 20;
		array[2][0] = 30;
		array[3][0] = 40;
		array[0][1] = 20;
		array[1][1] = 35;
		array[2][1] = 55;
		array[3][1] = 80;
		array[0][2] = 40;
		array[1][2] = 80;
		array[2][2] = 95;
		array[3][2] = 100;
		array[0][3] = 85;
		array[1][3] = 95;
		array[2][3] = 105;
		array[3][3] = 120;
		
		Question9 q9 = new Question9();
		HashMap<Integer, Integer> map = q9.searchMatrix(array, 95);
		for (int key : map.keySet()) {
			System.out.println("r: " + key + ", c: " + map.get(key));
		}
		

	}
	
	public HashMap<Integer, Integer> searchMatrix(int[][] array, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		search(array, target, map);
		
		return map;
	}
	
	private void search(int[][] array, int target, HashMap<Integer, Integer> map) {
		for (int i=0; i<array.length; i++) {
			columnSearch(array, target, i, 0, array[i].length-1, map);
		}
	}
	
	private void columnSearch(int[][] array, int target, int r, int low, int high, HashMap<Integer, Integer> map) {
		int mid = (low + high)/2;
		if (low > high) {
			return;
		}
		
		if (array[r][mid] == target) {
			map.put(r, mid);
			return;
		} else if (array[r][mid] < target) {
			columnSearch(array, target, r, mid+1, high, map);
		} else {
			columnSearch(array, target, r, low, mid-1, map);
		}
	}

}
