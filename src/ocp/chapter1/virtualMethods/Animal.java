package ocp.chapter1.virtualMethods;

public abstract class Animal {
	String name = "Animal";
	public abstract void feed();
	public void getName() {
		System.out.println(name);
	}
}
