package ocp.chapter1.nestedClasses;

public class Anonymous {
	private int number;
	
	//questa è una member inner class dichiarata come interfaccia. E' anche una functional interface perchè abbiamo un singolo metodo.
	@FunctionalInterface
	interface Math {
		public abstract void add (int a); //public abstract nelle interfacce by default
	}
	
	public void prova () {
		//qui posso creare la mia anonymous inner class, non avendo bisogno di andare a creare una classe che implementa l interfaccia 
		//ma con una singola linea  dove dichiaro e istanzio usando la parola new
		Math m = new Math() {

			@Override
			public void add(int a) {
				// TODO Auto-generated method stub 
				System.out.println("somma di due numeri anonymous inner class " + number); //può accedere alle proprietà della outer class
			}
			
		};
		
		//in sostanza è come se io avessi fatto una lambda expression
		Math function = (int a) -> System.out.println("Somma di due numeri lambda expression");
		
		m.add(5);
		function.add(5);
	}
	
	public static void main (String[] args) {
		new Anonymous().prova();
	}
	
}
