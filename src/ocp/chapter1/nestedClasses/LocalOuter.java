package ocp.chapter1.nestedClasses;

//this is an example of local inner class that is a class defined within a method
public class LocalOuter {
	private int length = 5;
	
	public void calculate() {
		int width = 20; //effectively final, oppure dichiararla direttamente final
		
		//non hanno un access modifier proprio come le variabili locali non avrebbe senso nascono e muorono nel metodo
		class Inner {
			public void multiply() {
				System.out.println(length * width);
			}
		}
		
		Inner inner = new Inner();
		inner.multiply();
	}
	
	public static void main(String[] args) {
		LocalOuter outer = new LocalOuter();
		outer.calculate();
	}
}