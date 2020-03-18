package ocp.chapter1.nestedClasses;

public class Anonymous {
	//questa è una member inner class dichiarata come interfaccia
	interface Math {
		public abstract void add ();
	}
	
	public void prova () {
		Math m = new Math() {

			@Override
			public void add() {
				// TODO Auto-generated method stub
				System.out.println("somma di due numeri");
			}
			
		};
		
		m.add();
	}
	
	public static void main (String[] args) {
		new Anonymous().prova();
	}
	
}
