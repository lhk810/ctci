package chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import chapter3.HKStack;

public class Question7 {

	public static void main(String[] args) {
		String[] projects = new String[6];
		projects[0] = "a";
		projects[1] = "b";
		projects[2] = "c";
		projects[3] = "d";
		projects[4] = "e";
		projects[5] = "f";
		String[][] dependencies = new String[5][2];
		dependencies[0][0] = "a";
		dependencies[0][1] = "d";
		dependencies[1][0] = "f";
		dependencies[1][1] = "b";
		dependencies[2][0] = "b";
		dependencies[2][1] = "d";
		dependencies[3][0] = "f";
		dependencies[3][1] = "a";
		dependencies[4][0] = "d";
		dependencies[4][1] = "c";
		Question7 q7 = new Question7();
		HKStack<Project> stack = q7.findBuildOrder(projects, dependencies);
		Project project = stack.peek();
		while (!stack.isEmpty()) {
			project = stack.pop();
			System.out.println(project.getName());
		}

	}
	
	public class Project {
		private ArrayList<Project> children = new ArrayList<>();
		private HashMap<String, Project> map = new HashMap<>();
		private String name;
		
		public Project(String name) {
			this.name = name;
		}
		
		private State state = State.BLACK;
		
		public void setState(State st) {
			state = st;
		}
		
		public State getState() {
			return state;
		}
		
		public ArrayList<Project> getChildren() {
			return children;
		}
		
		public String getName() {
			return name;
		}
		
		public void addNeighbor(Project node) {
			if (!map.containsKey(node.getName())) {
				children.add(node);
				map.put(node.name, node);
			}
		}
		
	}
	
	public enum State {COMPLETE, PARTIAL, BLACK};
	
	public HKStack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
	
	public HKStack<Project> orderProjects(ArrayList<Project> projects) {
		HKStack<Project> stack = new HKStack<>();
		for (Project project : projects) {
			if (project.getState() == State.BLACK) {
				if (!DFS(project,stack)) {
					return null;
				}
			}
		}
		return stack;
	}
	
	public boolean DFS(Project project, HKStack<Project> stack) {
		
		if (project.getState() == State.PARTIAL) {
			return false;
		}
		
		if (project.getState() == State.BLACK) {
			project.setState(State.PARTIAL);
			ArrayList<Project> children = project.getChildren();
			for (Project child : children) {
				if (!DFS(child, stack)) {
					return false;
				}
			}
			project.setState(State.COMPLETE);
			stack.push(project);
		}
		
		return true;
	}
	
	public class Graph {
		private ArrayList<Project> nodes = new ArrayList<>();
		private HashMap<String, Project> map = new HashMap<>();
		
		public Project getOrCreateNode(String name) {
			if (!map.containsKey(name)) {
				Project node = new Project(name);
				nodes.add(node);
				map.put(name, node);
			}
			
			return map.get(name);
		}
		
		public void addEdge(String statName, String endName) {
			Project start = getOrCreateNode(statName);
			Project end = getOrCreateNode(endName);
			start.addNeighbor(end);
		}
		
		public ArrayList<Project> getNodes() {
			return nodes;
		}
	}
	
	public Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}
		
		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}
		
		return graph;
	}
}
