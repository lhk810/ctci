package chapter16;

public class Question2 {

	public static void main(String[] args) {
		String word = "boy";
		String[] book = new String[3];
		book[0] = "I am 19 years old guy. Some may call me boy";
		book[1] = "Boy";
		book[2] = "I don't know him.";
		Question2 q2 = new Question2();
		System.out.println(q2.findFrequency(word, book));

	}
	
	public int findFrequency(String word, String[] book) {
		int res = 0;
		word = word.toLowerCase();
		for (int i=0; i<book.length; i++) {
			String[] array = book[i].split(" ");
			for (int j=0; j<array.length; j++) {
				String target = array[j].trim().toLowerCase();
				if (target.equals(word)) {
					res++;
				}
			}
		}
		return res;
	}

}
