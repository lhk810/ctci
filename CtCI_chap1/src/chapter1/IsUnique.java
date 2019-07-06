package chapter1;

public class IsUnique {

	public static void main(String[] args) {
		IsUnique IU = new IsUnique();
		System.out.println(IU.isUniqueSol("asd1234zxcqwasde"));

	}

	public boolean isUnique(String input) {
		for (int i=0;i<input.length();i++) {
			for (int j=0;j<i;j++) {
				if (input.charAt(i)==input.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isUniqueSol(String input) {
		int[] check = new int[256];
		for (int i=0;i<input.length();i++) {
			int tmp = input.charAt(i);
			if (check[tmp]==1) {
				return false;
			}
			check[tmp]=1;
		}
		return true;
	}
	
}
