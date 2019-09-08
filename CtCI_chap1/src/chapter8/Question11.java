package chapter8;

public class Question11 {

	public static void main(String[] args) {
		Question11 q11 = new Question11();
		System.out.println(q11.coins(25));

	}
	
	public int coins(int remainder) {
		if (remainder >= 25) {
			return coins(remainder, 25) + coins(remainder,10) + coins(remainder, 5) + coins(remainder, 1);
		} else if (remainder >= 10 && remainder < 25) {
			return coins(remainder,10) + coins(remainder, 5) + coins(remainder, 1);
		} else if (remainder >=5 && remainder < 10) {
			return coins(remainder, 5) + coins(remainder, 1);
		} else if (remainder >=1 && remainder <5) {
			return coins(remainder, 1);
		} else {
			return 0;
		}
		
	}
	
	public int coins(int remainder, int coin) {
		remainder-=coin;
		if (remainder < 0) {
			return 0;
		} else if (remainder == 0) {
			return 1;
		} else {
			if (coin == 25) {
				return coins(remainder, 25) + coins(remainder,10) + coins(remainder, 5) + coins(remainder, 1);
			} else if (coin == 10) {
				return coins(remainder,10) + coins(remainder, 5) + coins(remainder, 1);
			} else if (coin == 5) {
				return coins(remainder, 5) + coins(remainder, 1);
			} else {
				return coins(remainder, 1);
			}
		}
	}

}
