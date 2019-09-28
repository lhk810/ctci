package chapter10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//1GB -> 10^9byte -> 4*10^9byte
	//4*10^9 non-negative integer -> 2^31 distict integer possible(~2*10^9) < 4*10^9
	public boolean[] findDistinct() {
		boolean[] idxOfInt = new boolean[Integer.MAX_VALUE+1];
		String filename = "filefile";
		Scanner scanner;
		try {
			scanner = new Scanner(new FileReader(filename));
			while (scanner.hasNext()) {
				int i = scanner.nextInt();
				idxOfInt[i] = true;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return idxOfInt;
	}

}
