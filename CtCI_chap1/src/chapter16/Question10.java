package chapter16;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Question10 {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		for (int i=0; i<1000; i++) {
			int a = (int)(Math.random()*101 + 1900);
			int b = (int)(Math.random()*101 + 1900);
			Person person = new Person(Math.min(a, b), Math.max(a, b));
			list.add(person);
		}
		
		Question10 q10 = new Question10();
		System.out.println(q10.maxAliveYear(list));

	}
	
public int maxAliveYear(ArrayList<Person> list) {
		
		int[] birthyear = new int[101];
		int[] deathyear = new int[101];
		
		
		for (int i=0; i<list.size(); i++) {
			birthyear[list.get(i).birth-1900]++;
			deathyear[list.get(i).death-1900]++;
		}
		
		int[] population = new int[101];
		
		population[0] = birthyear[0];
		int maxpop = 0;
		int maxyear = 0;
		for (int i=1; i<population.length; i++) {
			population[i] = population[i-1] + birthyear[i] - deathyear[i-1];
			System.out.println(i+1900 + " : " + population[i]);
			if (population[i] > maxpop) {
				maxpop = population[i];
				maxyear = i+1900;
			}
		}
		
		return maxyear;
		
	}
	

}

class Person {
	int birth;
	int death;
	public Person(int birth, int death) {
		this.birth = birth;
		this.death = death;
	}
}