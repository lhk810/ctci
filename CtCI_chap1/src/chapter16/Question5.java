package chapter16;

public class Question5 {

	public static void main(String[] args) {
		Question5 q5 = new Question5();
		int n = 100;

		System.out.println(q5.calczeros(n));

	}
	
	
	public int calczeros(int n) {
		int res = n;
		int cnt = 0;
		while (res>=5) {
			res /= 5;
			cnt ++;
		}
		int pow = 0;
		//System.out.println(cnt);
		for (int i=cnt; i>1; i--) {
			res = n;
			double target = Math.pow(5,i);
			//System.out.println(target);
			while (res>=target) {
				res /= target;
			}
			pow += res;
			//System.out.println(pow);
		}
		
		return n/5 + pow; //2<5이므로 5에 대해서만 계산
		
	}

}
