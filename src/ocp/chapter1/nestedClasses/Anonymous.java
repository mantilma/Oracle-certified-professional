package ocp.chapter1.nestedClasses;

public class Anonymous {
	private int number;
	
	//questa è una member inner class dichiarata come interfaccia. E' anche una functional interface perchè abbiamo un singolo metodo.
	interface Math {
		public abstract void add ();
	}
	
	public void prova () {
		Math m = new Math() {

			@Override
			public void add() {
				// TODO Auto-generated method stub 
				System.out.println("somma di due numeri anonymous inner class " + number); //può accedere alle proprietà della outer class
			}
			
		};
		
		//sfrutto math come lambda expression
		Math function = () -> System.out.println("Somma di due numeri lambda expression");
		
		m.add();
		function.add();
	}
	
	public static void main (String[] args) {
		new Anonymous().prova();
	}
	
}
