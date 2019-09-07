package chapter8;

public class Question10 {

	public static void main(String[] args) {
		Question10 q10 = new Question10();
		String[][] screen = new String[6][4];
		for (int i=0;i<screen.length;i++) {
			for (int j=0;j<screen[0].length;j++) {
				screen[i][j] = "yellow";
			}
		}
		q10.paintFill(screen, screen[0].length/2, screen.length/2, "red");
		q10.printScreen(screen);
	}
	
	
	public void paintFill(String[][] screen, int x, int y, String color) {
		if (x >= screen[0].length || y >=screen.length || x<0 || y<0) {
			return;
		}
		
		if (screen[y][x] != color) {
			screen[y][x] = color;
			paintFill(screen, x-1, y, color);
			paintFill(screen, x+1, y, color);
			paintFill(screen, x, y-1, color);
			paintFill(screen, x, y+1, color);
		}
		
		return;
	}
	
	public void printScreen(String[][] screen) {
		for (int y=0; y<screen.length; y++) {
			for (int x=0; x<screen[0].length; x++) {
				System.out.print(screen[y][x]+" ");
			}
			System.out.println();
		}
	}

}
