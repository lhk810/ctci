package chapter1;

public class URLify {

	public static void main(String[] args) {


		URLify url = new URLify();
		String input1 = "Mr John Smith   ";
		int length1 = 13;
		String input2 = "This is Sparta!  ";
		int length2 = 15;
		
		System.out.println(url.urlify(input1, length1));
		System.out.println(url.urlify(input2, length2));

	}
	
	public String urlify(String input, int length) {
		String tmp = input.trim();
		//System.out.println("trimed : " + tmp);
		
		int cnt = 0;
		for (int i=0;i<tmp.length();i++) {
			if (tmp.charAt(i) == ' ') {
				cnt++;
			}
		}
		
		length += cnt*2;
		
		//System.out.println("cnt : "+ cnt);
		
		char[] array = new char[length];
		
		int j = 0;
		for (int i=0;i<tmp.length();i++) {
			if (tmp.charAt(i) != ' ') {
				array[j] = tmp.charAt(i);
				j++;
			} else {
				array[j] = '%';
				j++;
				array[j] = '2';
				j++;
				array[j] = '0';
				j++;
			}
		}
		
		
		return String.copyValueOf(array);
	}

}
