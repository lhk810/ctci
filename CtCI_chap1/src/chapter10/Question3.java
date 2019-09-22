package chapter10;

public class Question3 {

	public static void main(String[] args) {
		int arr[] =  {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		Question3 q3 = new Question3();
		System.out.println(q3.searchArray(arr, 5));
		int arr2[] = {2, 2, 2, 3, 4, 2};
		System.out.println(q3.searchArray(arr2, 3));

	}
	
	public int searchArray(int[] array, int target) {
		
		return searchArray(array, 0, array.length-1, target);
	}
	
	private int searchArray(int[] array, int low, int high, int target) {
		int mid = (low + high)/2;
		
		if (low > high) {
			return -1;
		}
		
		if (array[mid] == target) {
			return mid;
		}
		
		if (array[mid] > array[low]) {
			if (target < array[mid]) {
				return searchArray(array, low, mid-1, target);
			} else {
				return searchArray(array, mid+1, high, target);
			}
		} else {
			if (target > array[mid]) {
				return searchArray(array, mid+1, high, target);
			} else {
				return searchArray(array, low, mid-1, target);
			}
		}
		
	}

}
