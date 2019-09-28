package chapter10;

public class Question8 {

	public static void main(String[] args) {
		int[] array = new int[10];
		for (int i=0; i<8; i++) {
			array[i] = i;
		}
		array[8]=0;
		array[9]=1;
		
		Question8 q8 = new Question8();
		q8.printDuplicate(array);

	}
	
	public void printDuplicate(int[] array) {
		boolean[] idxOfInt = new boolean[32000]; //4kilobyte
		for (int i=0; i<array.length; i++) {
			if (!idxOfInt[array[i]]) {
				idxOfInt[array[i]] = true;
			} else {
				System.out.println(array[i]);
			}
		}
	}

}
