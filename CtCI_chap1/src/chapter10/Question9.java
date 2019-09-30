package chapter10;

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
		int[] res = q9.searchMatrix(array, 80);
		System.out.println("r : " + res[0] + ", c : " + res[1]);

	}
	
	public int[] searchMatrix(int[][] array, int target) {
		int[] res = new int[2];
		int r = rowSearch(array, target, 0, array.length-1);
		int c = columnSearch(array, target, r, 0, array[0].length-1);
		
		if (c == -1) {
			res[0] = -1;
			res[1] = -1;
			return res;
		} else {
			res[0] = r;
			res[1] = c;
			return res;
		}
		
	}
	
	private int rowSearch(int[][] array, int target, int low, int high) {
		int mid = (low + high);
		if (low < high) {
			return mid;
		}
		
		if (array[mid][0] == target) {
			return mid;
		} else if (array[mid][0] > target) {
			return rowSearch(array, target, mid+1, high);
		} else {
			return rowSearch(array, target, low, mid-1);
		}
		
	}
	
	private int columnSearch(int[][] array, int target, int r, int low, int high) {
		int mid = (low + high);
		if (low < high) {
			return -1;
		}
		
		if (array[r][mid] == target) {
			return mid;
		} else if (array[r][mid] > target) {
			return rowSearch(array, target, mid+1, high);
		} else {
			return rowSearch(array, target, low, mid-1);
		}
	}

}
