package ocp.chapter1.nestedClasses;

//this is an example of member inner class that is a class defined at the same level as instance (member,properties) variables
public class MemberOuter {
	private String greeting = "Hi";
	
	// dichiaro la member inner class e vediamo che è definita allo stesso livello dove dichiaro le proprietà costruttori e metodi
	// posso utilizzare qualsiasi access modifiers (private default protected or public
	class Inner { 
		private int repeat = 3;
		public void go() {
			for (int i = 0; i < repeat; i++)
				System.out.println(greeting);
		}
	}
	
	public void CallInner() {
		Inner inner = new Inner();
		inner.go();
	}
	
	public static void main (String[] args) {
		// Non si può fare perchè in un metodo statico non posso accedere ad inner class direttamente ma devo creare un oggetto memberOuter.
		// In sostanza vale la stessa regola che in una classe statica non posso accedere a proprietà o metodi non statici, ma eventualmente devo 
		// creare l'oggetto e poi usarli come faccio sotto
		//Inner inner1 = new Inner(); 
		
		MemberOuter outer = new MemberOuter();
		outer.CallInner();
		
		Inner inner = outer.new Inner();
		inner.go();
		
	}
}
