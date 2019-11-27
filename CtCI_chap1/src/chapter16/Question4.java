package chapter16;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Question4 {

	public static void main(String[] args) {
		Question4 q4 = new Question4();
		
		Stack<Position> boardinfo = new Stack<Position>();
		boardinfo.add(new Position(0, 2, Player.Player1));
		boardinfo.add(new Position(0, 1, Player.Player2));
		boardinfo.add(new Position(1, 1, Player.Player1));
		boardinfo.add(new Position(2, 1, Player.Player2));
		boardinfo.add(new Position(1, 0, Player.Player1));
		
		q4.tictacwin(boardinfo);

	}
	
	public void tictacwin(Stack<Position> boardinfo) {
		//어떤 플레이어가 어떤 위치에 뒀는지를 저장하는 stack
		//경기 종료 후에 두는 수는 없음
		//경우의 수는 가장 마지막에 둔 플레이어가 승자 or 무승부 뿐
		if (boardinfo.size() < 5) {
			System.out.println("경기가 더 진행되어야 합니다");
			return;
		}
		Position lastpos = boardinfo.pop();
		boardinfo.pop(); //마지막 이전 수는 다른 플레이어 것이므로 버림
		Position prepos = boardinfo.pop();
		boardinfo.pop(); //같은 이유로 버림
		Position preprepos = boardinfo.pop();
		if (decide(lastpos, prepos, preprepos)) {
			System.out.println(lastpos.player + "이 승리");
		} else {
			System.out.println("무승부");
		}
		
	}
	
	public boolean decide(Position p0, Position p1, Position p2) {
		//x-check
		if (p0.x == p1.x && p1.x == p2.x) {
			return true;
		}
		//y-check
		if (p0.y == p1.y && p1.y == p2.y) {
			return true;
		}
		//diagonal check
		int[] arrx = new int[3];
		int[] arry = new int[3];
		arrx[0] = p0.x;
		arrx[1] = p1.x;
		arrx[2] = p2.x;
		arry[0] = p0.y;
		arry[1] = p1.y;
		arry[2] = p2.y;
		Arrays.sort(arrx);
		Arrays.sort(arry);
		boolean res = true;
		for (int i=0; i<3; i++) {
			if (arrx[i] != arry[i]) {
				res = false;
			}
		}
		if (res) {
			return res;
		}
		res = true;
		for (int i=0; i<3; i++) {
			if (arrx[i] != arry[3-i-1]) {
				res = false;
			}
		}
		if (res) {
			return res;
		}
		
		return res;
	}

}

class Position {
	/*
	 *  00 01 02
	 *  10 11 12
	 *  20 21 22
	 */
	int x;
	int y;
	Player player;
	
	public Position(int x, int y, Player player) {
		this.x = x;
		this.y = y;
		this.player = player;
	}
}

enum Player {
	Player1,
	Player2
}