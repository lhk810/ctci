package chapter4;

import chapter3.HKQueue;

public class Question1 {

	public static void main(String[] args) {
		HKGraph g1 = new HKGraph();
		HKNode n1 = new HKNode("node1");
		HKNode n2 = new HKNode("node2");
		HKNode n3 = new HKNode("node3");
		HKNode n4 = new HKNode("node4");
		HKNode n5 = new HKNode("node5");
		
		g1.addNode(n1);
		g1.addNode(n2);
		g1.addNode(n3);
		g1.addNode(n4);
		g1.addNode(n5);
		//g1.printGraph();
		
		g1.connectNode(n1, n2);
		g1.connectNode(n1, n3);
		g1.connectNode(n2, n3);
		g1.connectNode(n3, n2);
		g1.connectNode(n3, n4);
		g1.connectNode(n4, n5);
		
		g1.printGraph();
		
		Question1 q1 = new Question1();
		
		System.out.println(q1.BFS(g1, n5, n4));
	}
	
	public boolean BFS(HKGraph g, HKNode n1, HKNode n2) {
		if (n1 == n2) return true;
		
		for (HKNode n : g.adjacent) {
			n.state = State.Unvisited;
		}
		
		if (g.adjacent.contains(n1) && g.adjacent.contains(n2)) {
			int startindex = g.adjacent.indexOf(n1);
			HKQueue<HKNode> queue = new HKQueue<>();
			HKNode startNode = g.adjacent.get(startindex);
			startNode.state = State.Visiting;
			queue.add(startNode);
			while (!queue.isEmpty()) {
				HKNode r = queue.remove();
				r.state = State.Visited;
				if (r != null) {
					for (HKNode node : r.children) {
						if (node.state == State.Unvisited) {
							node.state = State.Visiting;
							if (node == n2) {
								return true;
							}
							node.state = State.Visiting;
							queue.add(node);
						}
					}
				}
				r.state = State.Visited;
			}
			
		} else {
			return false;
		}
		
		return false;
	}

}
