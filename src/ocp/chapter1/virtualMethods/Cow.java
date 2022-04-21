package ocp.chapter1.virtualMethods;

public class Cow extends Animal {
	String name = "Cow";
	@Override
	public void feed() {
		// TODO Auto-generated method stub
		System.out.println("feed Cow");
		System.out.println(name); //stampa cow
	}
	
	public void getName() {
		System.out.println(name);
	}
	
}
