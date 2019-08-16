package chapter5;

public class Question7 {

	public static void main(String[] args) {
		Question7 q7 = new Question7();
		int res = q7.swapBit(14);
		System.out.println("res : " + res);
		System.out.println(Integer.toBinaryString( res));

	}
	
	public int swapBit(int n) {
		int evenRemainder = n&0xaaaaaaaa;
		int oddRemainder = n&0x55555555;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(evenRemainder));
		System.out.println(Integer.toBinaryString(oddRemainder));
		return (evenRemainder>>>1 | oddRemainder <<1);
	}

}
