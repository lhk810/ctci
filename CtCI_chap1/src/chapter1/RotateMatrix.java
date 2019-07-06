package chapter1;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] input1 = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[][] input2 = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		RotateMatrix RM = new RotateMatrix();
		RM.printresult(input1);
		System.out.println();
		int[][] res1 = RM.rotate(input1);
		RM.printresult(res1);
		System.out.println("=========================");
		RM.printresult(input2);
		System.out.println();
		int[][] res2 = RM.rotate(input2);
		RM.printresult(res2);
		

	}
	
	public int[][] rotate(int[][] input) {
		int len = input.length-1;
		for (int i=0; i<input.length/2; i++) {
			for (int j=0;j<len-2*i;j++) {
				int tmp = input[j+i][len-i];
				input[j+i][len-i] = input[i][j+i];
				input[i][j+i] = input[len-j-i][i];
				input[len-j-i][i] = input[len-i][len-j-i];
				input[len-i][len-j-i] = tmp;
			}
		}
		
		return input;
	}
	
	public void printresult(int[][] input) {
		for (int i=0; i<input.length; i++) {
			for (int j=0; j<input.length; j++) {
				System.out.print(input[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
