package chapter10;

public class Question5 {

	public static void main(String[] args) {
		String[] array = {"at","","","","ball","","","car","","","dad","",""};
		Question5 q5 = new Question5();
		System.out.println(q5.sparseSearch(array, "ball"));

	}
	
	public int sparseSearch(String[] array, String target) {
		return sparseSearch(array, target, 0, array.length-1);
	}
	
	private int sparseSearch(String[] array, String target, int low, int high) {
		int mid = (low + high)/2;
		
		if (array[mid].equals(target)) {
			return mid;
		}
		
		if (low > high) {
			return -1;
		}
		
		int search1=-1;
		int search2=-1;
		if (array[mid].isEmpty() || !array[mid].equals(target)) {
			search1 = sparseSearch(array, target, low, mid-1);
			search2 = sparseSearch(array, target, mid+1, high);
		}
		
		return Math.max(search1, search2);
		
	}

}
