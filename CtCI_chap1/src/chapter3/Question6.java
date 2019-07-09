package chapter3;

import chapter3.Question6.AnimalsLinkedList.Node;

public class Question6 {

	public static void main(String[] args) {
		Question6 q6 = new Question6();
		AnimalShelter as = q6.new AnimalShelter();
		
		Dog d1 = q6.new Dog();
		Dog d2 = q6.new Dog();
		Cat c1 = q6.new Cat();
		Cat c2 = q6.new Cat();
		
		as.enqueue(c1);
		as.enqueue(c2);
		as.enqueue(d2);
		as.enqueue(d1);
		
		System.out.println(as.dequeueAny().getClass().getName());
		System.out.println(as.dequeueDog().getClass().getName());

	}
	
	public class AnimalShelter {
		HKQueue<Dog> dogqueue = new HKQueue<>();
		HKQueue<Cat> catqueue = new HKQueue<>();
		AnimalsLinkedList<Animals> list =  new AnimalsLinkedList<>();
		
		public void enqueue(Animals animal) {
			list.appendToTail(animal);
			if (animal instanceof Dog) {
				dogqueue.add((Dog)animal);
			} else {
				catqueue.add((Cat)animal); 
			}
		}
		
		public Animals dequeueAny() {
			
			Node node = list.deleteHead();
			
			if (node.animal instanceof Dog) {
				return dogqueue.remove();
			} else {
				return catqueue.remove();
			}
		}
		
		public Dog dequeueDog() {
			Dog dog = dogqueue.remove();
			list.deleteOne(dog);
			return dog;
		}
		
		public Cat dequeueCat() {
			Cat cat = catqueue.remove();
			list.deleteOne(cat);
			return cat;
		}
		
	}
	
	public class AnimalsLinkedList<Animals> {
		
		Node head = null;
		
		public void printLinkedList() {
			Node n = head;
			while (n != null) {
				System.out.println(n.data);
				n = n.next;
			}
		}
		
		public void deleteOne(Animals animal) {
			Node n = head;
			
			if (animal instanceof Dog) {
				if (head.data.equals("dog")) {
					head = n.next;
				} else  {
					while (!n.next.data.equals("dog")) {
						n = n.next;
					}
					n.next = n.next.next;
				}
				
			} else if (animal instanceof Cat) {
				if (head.data.equals("cat")) {
					head = n.next;
				} else  {
					while (!n.next.data.equals("cat")) {
						n = n.next;
					}
					n.next = n.next.next;
				}
				
			}
			
		}
		
		public Node deleteHead() {
			Node node = head;
			head = head.next;
			return node;
		}
		
		public void appendToTail(Animals animal) {
			Node end = new Node(animal);
			Node n = this.head;
			if (n == null) {
				this.head = end;
				return;
			}
			
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		public class Node {
			Node next = null;
			Animals animal;
			String data;
			
			public  Node(Animals animal) {
				if (animal instanceof Dog) {
					this.animal = animal;
					data = "dog";
				} else {
					this.animal = animal;
					data = "cat";
				}
			}
			
			public void  printNodedata() {
				System.out.println("Node contains : " + data);
			}
			
		}
	}
	
	public abstract class Animals {
		
	}
	
	public class Dog extends Animals {
		
	}
	
	public class Cat extends Animals {
		
	}

}
