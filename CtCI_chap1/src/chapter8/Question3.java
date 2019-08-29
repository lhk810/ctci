package chapter8;

import java.util.Arrays;

public class Question3 {

	public static void main(String[] args) {
		int[] arr1 = new int[5];
		arr1[0] = 0;
		arr1[1] = 3;
		arr1[2] = 5;
		arr1[3] = 6;
		arr1[4] = 7;
		
		int[] arr2 = new int[6];
		arr2[0] = -1;
		arr2[1] = 0;
		arr2[2] = 1;
		arr2[3] = 2;
		arr2[4] = 4;
		arr2[5] = 6;
		
		Question3 q3 = new Question3();
		System.out.println(q3.findMagicIndex(arr1,0,arr1.length));
		System.out.println(q3.findMagicIndex(arr2,0,arr2.length));

	}
	
	public int findMagicIndex(int[] arr, int from, int to) {
		int target = (from + to)/2;
		if (target == from || target == to) {
			if (arr[target] == target) {
				return target;
			} else {
				return -1;
			}
		}
		if (arr[target] == target) {
			return target;
		} else if (arr[target] > target) {
			return findMagicIndex(arr, from, target);
		} else {
			return findMagicIndex(arr, target, to);
		}
		
		
	}
	
	//followup?

}
