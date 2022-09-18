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
		//boolean b6 = d instanceof Cat; // non compila perchè la referenza dog mai potrà puntare ad un cat. instance of lavora solo in "verticale" in una gerarchia
		boolean b7 = d instanceof Animal; // true
		boolean b8 = d instanceof Dog; // off course true!
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b7);
		System.out.println(b8);
		
	}
}
