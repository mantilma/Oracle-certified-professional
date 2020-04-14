package ocp.chapter1.instanceOf;

public class Main {
	public static void main(String[] args) {
		Animal animal = new Dog();
		boolean b1 = animal instanceof Dog; // true
		boolean b2 = animal instanceof Animal; // true
		boolean b3 = animal instanceof Cat; // false
		boolean b4 = animal instanceof Object; // true
		animal = null;
		boolean b5 = animal instanceof Object; // false
		
		Dog d = new Dog();
		//boolean b6 = d instanceof Cat; // non compila perchè la referenza dog mai potrà puntare ad un cat
		boolean b7 = d instanceof Animal; // true
		
	}
}
