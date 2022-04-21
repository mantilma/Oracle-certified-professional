package ocp.chapter1.virtualMethods;

public class Main {
	public static void main (String[] args) {
		Animal a = new Cow();
		a.feed();
		System.out.println(a.name); //se accedo direttamente stampa animal
		a.getName(); //invocando il getname di cow mi stampa cow!
	}
}
