package chapter5;

public class Question4 {

	public static void main(String[] args) {
		Question4 q4 = new Question4();
		q4.findNumbers(12);

	}
	
	public void findNumbers(int n) {
		int nlnum;
		int nsnum;
		
		
		String input = Integer.toBinaryString(n);
		int count0 = 0;
		int count1 = 0;
		
		int num = n;
		while (num != 0) {
			if ((1&(num)) == 1) {
				count1++;
			} else {
				count0++;
			}
			num >>= 1;
		}
		//System.out.println(count0 + " " + count1);
		
		//find right-most 1
		int idx = 0;
		int countdown = count0;
		while (countdown > 0) {
			if ( (1&(n>>idx)) == 1) {
				break;
			}
			countdown --;
			idx++;
		}
		if (idx == count0) {
			if (count0 == 0) {
				nlnum = n<<1;
				nsnum = -1;
			} else {
				nlnum = n<<1;
				nsnum = n - (1<<idx) + 1;
			}
		} else {
			nlnum = n - (1<<idx) + (1<<count0);
			nsnum = n - (1<<idx) + 1;
			if ((n&1) == 1) {
				nsnum = -1;
			}
		}
		
		System.out.println("nlnum is : " + nlnum + " as " + Integer.toBinaryString(nlnum));
		System.out.println("nlnum is : " + nsnum + " as " + Integer.toBinaryString(nsnum));
	}

}
