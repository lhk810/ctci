package chapter4;

import java.util.ArrayList;
import java.util.HashMap;

public class Question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Project {
		private ArrayList<Project> children = new ArrayList<>();
		private HashMap<String, Project> map = new HashMap<>();
		private String name;
		private int dependencies = 0;
		
		public Project(String name) {
			this.name = name;
		}
		
	}

}
