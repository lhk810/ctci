package chapter4;

import java.util.ArrayList;

public class HKNode {
	public String name;
	public ArrayList<HKNode> children = new ArrayList<>();
	State state;
	
	public HKNode(String name) {
		this.name = name;
	}
}
