package chapter10;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Question11 {

	public static void main(String[] args) {
		int[] array = new int[5];
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		array[3] = 3;
		array[4] = 4;
		
		Question11 q11 = new Question11();
		int[] res = q11.makePeakValley(array);
		for (int i=0; i<res.length; i++) {
			System.out.println(i + " : " + res[i]);
		}

	}
	
	public int[] makePeakValley(int[] array) {
		
		Arrays.sort(array); //NlogN...중복 엘리먼트 있으면 망함
		
		for (int i=1; i<array.length; i+=2) {
			int tmp = array[i];
			array[i] = array[i-1];
			array[i-1] = tmp;
		}
		
		return array;
	}

}
