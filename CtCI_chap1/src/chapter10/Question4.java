package chapter10;

public class Question4 {

	public static void main(String[] args) {
		ListyHK listy = new ListyHK(5);
		listy.add(2);
		listy.add(4);
		listy.add(6);
		listy.add(8);
		listy.add(10);
		
		Question4 q4 = new Question4();
		System.out.println(q4.searchListy(listy, 6));

	}
	
	public int searchListy(ListyHK listy, int target) {
		int high = 0;
		while (listy.elementAt(high) != -1 && listy.elementAt(high) < target) {
			if (high == 0) {
				high = 1;
			} else {
				high *= 2;
			}
		}
		if (high == 0 ) {
			if (listy.elementAt(high) == target) {
				return high;
			} else {
				return listy.elementAt(high);
			}
		}
		return searchListy(listy, 0, high, target);
	}
	
	private int searchListy(ListyHK listy, int low, int high, int target) {
		int mid = (low + high) / 2;
		if (low > high) {
			return -1;
		}
		if (listy.elementAt(mid)==target) {
			return mid;
		}
		
		if (target < listy.elementAt(mid)) {
			return searchListy(listy, low, mid-1, target);
		} else {
			return searchListy(listy, mid+1, high, target);
		}
		
	}

}

class ListyHK {
	private int[] arr;
	
	public int elementAt(int i) {
		if (i>=arr.length || i<0) {
			return -1;
		}
		return arr[i];
	}
	
	public void add(int x) {
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = x;
				return;
			}
		}
		return;
	}
	
	public ListyHK(int size) {
		arr = new int[size];
	}
	
	public void printListy() {
		for (int i=0; i<arr.length; i++) {
			System.out.println(i + " : " + arr[i]);
		}
	}
	
}