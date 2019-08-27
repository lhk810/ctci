package chapter8;

public class Question2 {

	public static void main(String[] args) {
		int[][] grid = new int[3][3];
		
		Question2 q2 = new Question2();
		System.out.println(q2.findpath(grid, 0, 0));

	}
	
	//grid[r][c] : grid
	//grid[r][c] != 0 : cannot pass
	//grid[r][c] == 0 : can pass
	//grid[0][0] : top left corner
	public int findpath(int[][] grid, int r, int c) {
		int dir = checkdirection(grid, r, c);
		//System.out.println("dir is : " + dir);
		if (dir == 0) {
			return 1;
		} else if (dir == 1) {
			return findpath(grid, r, c+1);
		} else if (dir == 2) {
			return findpath(grid, r+1, c);
		} else {
			return findpath(grid, r+1, c) + findpath(grid, r, c+1);
		}
	}
	
	public int checkdirection(int[][] grid, int r, int c) {
		int x_len = grid[0].length-1;
		int y_len = grid.length-1;
		int res = 0;
		if (r == y_len) {
			if (c == x_len || grid[r][c+1] != 0) {
				res += 0;
			} else {
				res += 1;
			}
		} else {
			if (grid[r+1][c] != 0) {
				res += 0;
			} else {
				res += 2;
			}
			if (c == x_len || grid[r][c+1] != 0) {
				res += 0;
			} else {
				res += 1;
			}
		}
		return res;
	}

}
