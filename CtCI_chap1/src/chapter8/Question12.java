package chapter8;

import java.util.ArrayList;

public class Question12 {

	public static void main(String[] args) {
		Question12 q12 = new Question12();
		ArrayList<int[][]> res = q12.eightQueens();
		q12.printBoard(res.get(0));
		System.out.println();
		System.out.println(res.size());

	}

	public ArrayList<int[][]> eightQueens() {
		ArrayList<int[][]> list = new ArrayList<int[][]>();
		int[][] board = new int[8][8];
		
		addQueen(0, board, list);
		
		return list;
	}
	
	public boolean checkSpot(int r, int c, int[][] board) {
		if (board[r][c] == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addQueen(int r, int[][] board, ArrayList<int[][]> list) {
		for (int j=0;j<board.length;j++) {
			if (checkSpot(r, j, board)) {
				addQueen(r, j, board, list);
			}
		}
	}
	
	public void addQueen(int r, int c, int[][] board, ArrayList<int[][]> list) {
		
		int [][] newboard = new int[8][8];
		for (int i=0; i<board.length; i++) {
			for (int j=0;j<board.length;j++) {
				newboard[i][j] = board[i][j];
			}
		}
		newboard[r][c] = 2;
		fillBoard(r, c, newboard);
		
		if (r==board.length-1) {
			list.add(newboard);
			return;
		}
		
		addQueen(r+1, newboard, list);
	}
	
	public void fillBoard(int r, int c, int[][] board) {
		for (int i=0; i<board.length; i++) {
			if (board[r][i] == 0) {
				board[r][i] = 1;
			}
		}
		for (int j=0; j<board.length; j++) {
			if (board[j][c] == 0) {
				board[j][c] = 1;
			}
		}
		//up-left
		int r1 = r;
		int c1 = c;
		while (r1>0 && c1>0) {
			r1--;
			c1--;
			if (board[r1][c1] == 0) {
				board[r1][c1] = 1;
			}
		}
		//up-right
		r1 = r;
		c1 = c;
		while (r1>0 && c1<board.length-1) {
			r1--;
			c1++;
			if (board[r1][c1] == 0) {
				board[r1][c1] = 1;
			}
		}
		//down-left
		r1=r;
		c1=c;
		while (r1<board.length-1 && c1>0) {
			r1++;
			c1--;
			if (board[r1][c1] == 0) {
				board[r1][c1] = 1;
			}
		}
		//down-right
		r1=r;
		c1=c;
		while (r1<board.length-1 && c1<board.length-1) {
			r1++;
			c1++;
			if (board[r1][c1] == 0) {
				board[r1][c1] = 1;
			}
		}
	}
	
	public void printBoard(int[][] board) {
		for (int r=0; r<board.length; r++) {
			for (int c=0; c<board.length; c++) {
				System.out.print(board[r][c]+" ");
			}
			System.out.println();
		} 
	}

}
