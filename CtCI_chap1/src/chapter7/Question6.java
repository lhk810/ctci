package chapter7;

import java.util.ArrayList;

public class Question6 {

}

class Edge {
	int edgepattern;
}

class Piece {
	Edge left;
	Edge right;
	Edge top;
	Edge bottom;
}

class Puzzle {
	ArrayList<Piece> puzzlepieces = new ArrayList<>();
	int dim;
	
	public Puzzle(int n, Piece[] pieces) {
		this.dim = n;
		for (int i=0; i<pieces.length; i++) {
			puzzlepieces.add(pieces[i]);
		}
	}
	
	public boolean fitsWith(Edge e1, Edge e2) {
		if (e1.edgepattern == ~e2.edgepattern) { //bit연산
			return true;
		} else {
			return false;
		}
	}
	
	//짝없는 edge의 수가 4*n*n -> 4*n이 될때까지 돌아가는 알고리즘 필요...
	
}
