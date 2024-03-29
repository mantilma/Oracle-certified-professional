package ocp.chapter1.nestedClasses;

public class Anonymous {
	private int number;
	
	//questa è una member inner class dichiarata come interfaccia. E' anche una functional interface perchè abbiamo un singolo metodo.
	@FunctionalInterface
	interface Math {
		public abstract void add (int a); //public abstract nelle interfacce by default
	}
	
	public void prova () {
		//qui posso creare la mia anonymous inner class (che ricordiamo è un sottoinsieme delle local inner class) 
		//non avendo bisogno di andare a creare una classe che implementa l interfaccia 
		//ma con una singola linea  dove dichiaro e istanzio usando la parola new
		final int width = 5;		
		Math m = new Math() {
			@Override
			public void add(int a) {
				// TODO Auto-generated method stub 
				System.out.println("somma di due numeri anonymous inner class " + number); //può accedere alle proprietà della outer class
				System.out.println("somma di due numeri anonymous inner class " + width); //come le local possono accedere a variabili local final o effectively
			}
			
		};
	
		m.add(5);
		
		//in sostanza è come se io avessi fatto una lambda expression che vedremo più avanti nel corso nella programmazione funzionale in java
		Math function = (int a) -> System.out.println("Somma di due numeri lambda expression");
		function.add(5);
	}
	
	public static void main (String[] args) {
		new Anonymous().prova();
	}
	
}
