package chapter4;

import java.util.ArrayList;

public class HKGraph {
	ArrayList<HKNode> adjacent = new ArrayList<>();
	
	public void addNode(HKNode n) {
		adjacent.add(n);
	}
	
	public void connectNode(HKNode n1, HKNode n2) {
		if (adjacent.contains(n1) && !n1.children.contains(n2)) {
			n1.children.add(n2);
		} else {
			System.out.println("check conditions");
		}
	}
	
	public void printGraph() {
		for (int i=0; i<adjacent.size(); i++) {
			System.out.println(adjacent.get(i).name + " has children nodes : " );
			for (int j=0; j<adjacent.get(i).children.size(); j++) {
				System.out.println(adjacent.get(i).children.get(j).name);
			}
		}
	}
}
