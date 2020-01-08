package chapter16;

import java.util.ArrayList;

public class Question13 {

	public static void main(String[] args) {
		Point13 p0 = new Point13(0, 0);
		Point13 p1 = new Point13(2, 0);
		Point13 p2 = new Point13(0, 2);
		Point13 p3 = new Point13(2, 2);
		Square13 s0 = new Square13(p0, p1, p2, p3);
		
		Point13 p4 = new Point13(0, 0);
		Point13 p5 = new Point13(-1, 0);
		Point13 p6 = new Point13(0, -1);
		Point13 p7 = new Point13(-1, -1);
		Square13 s1 = new Square13(p4, p5, p6, p7);
		
		Question13 q13 = new Question13();
		Line13 l = q13.intersect(s0, s1);
		l.defLine();

	}
	
	public Point13 Middle(Square13 s) {
		double x = (s.p0.x + s.p1.x + s.p2.x + s.p3.x)/4.0;
		double y = (s.p0.y + s.p1.y + s.p2.y + s.p3.y)/4.0;
		Point13 mid = new Point13(x, y);
		
		return mid;
	}
	
	public Line13 intersect(Square13 s0, Square13 s1) {
		Point13 mid0 = Middle(s0);
		Point13 mid1 = Middle(s1);
		return new Line13(mid0, mid1);
	}

}

class Square13 {
	Point13 p0;
	Point13 p1;
	Point13 p2;
	Point13 p3;
	Square13(Point13 p0, Point13 p1, Point13 p2, Point13 p3) {
		this.p0 = p0;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
}

class Point13 {
	double x;
	double y;
	Point13(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Line13 {
	Point13 p0;
	Point13 p1;
	Line13(Point13 p0, Point13 p1) {
		this.p0 = p0;
		this.p1 = p1;
	}
	public void defLine() {
		//y=ax+b
		if (p0.x == p1.x) {
			System.out.println("x=" + p0.x);
			return;
		}
		if (p0.y == p1.y) {
			System.out.println("y=" + p0.y);
			return;
		}
		double a = (p0.y-p1.y) / (p0.x - p1.x);
		double b = p0.y - a*p0.x;
		System.out.println("y=" + a +"x" + "+" + b);
	}
}