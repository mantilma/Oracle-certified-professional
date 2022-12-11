package ocp.chapter1.nestedClasses;

//this is an example of local inner class that is a class defined within a method
public class LocalOuter {
	private int length = 5;
	
	public void calculate() {
		int width = 20; //effectively final, oppure dichiararla direttamente final
		
		//non hanno un access modifier proprio come le variabili locali non avrebbe senso nascono e muorono nel metodo
		class LocalInner {
			public void multiply() {
				System.out.println(length * width); //notare che possono accedere alle proprietà globali della top level class anche se private, non a variabili locali interne 
				//al metodo a meno che questa non sia effictively final come in questo caso
			}
		}
		
		//width = 30; //questo non posso farlo perche sarebbe non più effectively final e mi andrà in errore quando la utiizzo all interno della classe LocalInner
		LocalInner inner = new LocalInner(); //creo una istanza della classe local
		inner.multiply();
	}
	
	public static void main(String[] args) {
		LocalOuter outer = new LocalOuter();
		outer.calculate();
	}
}