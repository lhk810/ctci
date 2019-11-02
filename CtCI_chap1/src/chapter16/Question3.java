package chapter16;

public class Question3 {

	public static void main(String[] args) {
		Point p1 = new Point(10.0, 0.0);
		Point p2 = new Point(0.0, 10.0);
		Point p3 = new Point(0.0, 0.0);
		Point p4 = new Point(10.0, 10.0);
		Line l1 = new Line(p1, p2);
		Line l2 = new Line(p3, p4);
		
		Question3 q3 = new Question3();
		Point intersection = q3.findIntersection(l1, l2);
		System.out.println("x : "+intersection.x);
		System.out.println("y : "+intersection.y);

	}
	
	public Point findIntersection(Line l1, Line l2) {
		double slope1 = ( (l1.end.y - l1.start.y)/(l1.end.x - l1.start.x) );
		double slope2 = ( (l2.end.y - l2.start.y)/(l2.end.x - l2.start.x) );
		
		if (slope1 != slope2) {
			//assume l1 & l2 have infinite length
			double l1OnY = l1.start.y - slope1*l1.start.x;
			double l2OnY = l2.start.y - slope2*l2.start.x;
			double x = (l1OnY - l2OnY)/(slope2 - slope1);
			double y = slope1*x + l1OnY;
			Point intersection = new Point(x, y);
			if (isInLine(intersection, l1) && isInLine(intersection, l2)) {
				return intersection;
			} else {
				System.out.print("there is no intersection that result will be : ");
				return null;
			}
		} else {
			double length1 = Math.sqrt( (l1.start.x - l1.end.x)*(l1.start.x - l1.end.x) + (l1.start.y - l1.end.y)*(l1.start.y - l1.end.y));
			double length2 = Math.sqrt( (l2.start.x - l2.end.x)*(l2.start.x - l2.end.x) + (l2.start.y - l2.end.y)*(l2.start.y - l2.end.y));
			if (length1 > length2) {
				if (isInLine(l2.start, l1) || isInLine(l2.end, l1)) {
					System.out.print("there is infinite intersection that result will be : ");
					return null;
				} else {
					System.out.print("there is no intersection that result will be : ");
					return null;
				}
			} else {
				if (isInLine(l1.start, l2) || isInLine(l1.end, l2)) {
					System.out.print("there is infinite intersection that result will be : ");
					return null;
				} else {
					System.out.print("there is no intersection that result will be : ");
					return null;
				}
			}
		}
		
	}
	
	public boolean isInLine(Point p, Line line) {
		double slope0 = Math.abs( (line.end.y - line.start.y)/(line.end.x - line.start.x) );
		double slope = Math.abs( (p.y - line.start.y)/(p.x - line.start.x) );
		
		if (slope0 != slope) {
			return false;
		} else {
			double bigX = (line.end.x>=line.start.x) ? line.end.x:line.start.x;
			double smallX = (line.end.x<line.start.x) ? line.end.x:line.start.x;
			double bigY = (line.end.y>=line.start.y) ? line.end.y:line.start.y;
			double smallY = (line.end.y<line.start.y) ? line.end.y:line.start.y;
			if (p.x <= bigX && p.x >= smallX && p.y <= bigY && p.y >= smallY) {
				return true;
			} else {
				return false;
			}
			
		}
		
	}

}

class Line {
	Point start;
	Point end;
	
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
}

class Point {
	double x;
	double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
}
