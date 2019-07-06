package chapter1;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] input1 = { {0,1,2} , {1,1,1}, {1,1,0} , {0,1,1}};
		int[][] input2 = { {0,0,0}, {1,1,1}, {1,1,1}};
		int[][] input3 = { {1,1,1}, {1,1,1}, {1,1,1}};
		
		ZeroMatrix ZM = new ZeroMatrix();
		ZM.printres(input1);
		System.out.println();
		ZM.printres(ZM.makeZero(input1));
		System.out.println();
		ZM.printres(input2);
		System.out.println();
		ZM.printres(ZM.makeZero(input2));
		System.out.println();
		ZM.printres(input3);
		System.out.println();
		ZM.printres(ZM.makeZero(input3));

	}
	
	public int[][] makeZero(int[][] input) {
		
		int m = input.length;
		int n = input[0].length;
		
		int[] row = new int[m];
		int[] column = new int[n];
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (input[i][j]==0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}
		
		for (int i=0; i<m; i++) {
			if (row[i]==1) {
				for (int j=0; j<n; j++) {
					input[i][j] = 0;
				}
			}
		}
		
		for (int j=0; j<n; j++) {
			if (column[j]==1) {
				for (int i=0; i<m; i++) {
					input[i][j] = 0;
				}
			}
		}
		
		
		return input;
	}
	
	public void printres(int[][] input) {
		for (int i=0; i<input.length; i++) {
			for (int j=0; j<input[0].length; j++) {
				System.out.print(input[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
