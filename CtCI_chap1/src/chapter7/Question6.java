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
		if (e1.edgepattern == ~e2.edgepattern) { //bit����
			return true;
		} else {
			return false;
		}
	}
	
	//¦���� edge�� ���� 4*n*n -> 4*n�� �ɶ����� ���ư��� �˰��� �ʿ�...
	
}
