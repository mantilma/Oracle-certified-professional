package ocp.chapter1.nestedClasses;

//Le static nested class sono uguali alle member ma soltanto sono dichiarate statiche. Questo comporta a differenza delle member non statiche che:
//- posso dichiarare delle proprietà o metodi statici;
//- nn posso accedere alle proprietà della top level class perchè il solito discorso che essendo statiche non posso accedere a proprietà o metodi esterni non statici
//- se io istanzio un oggetto della classe della classe static all'interno della toplevel class io posso accedere anche ai suoi membri (proprietà e metodi)
//anche privati, cosa che non posso fare se istanzio un oggetto della classe static al di fuori della toplevel
//- la cosa più caratteristica è che dopo aver fatto l'import tradizionale o statico istanziare un oggetto della classe static direttamente non serve fare
//le member ovvero A a1 = new A() A.B b1 = a1.new B() ma bensi posso  fare direttamente B b1 = new B();
// PS ricordiamo sempre che una classe top level non può MAI essere statica!

public class StaticNested {
	static class B {
		private int price = 6;
		private static int size = 7;
		public static int getSize() {
			return size;
		}
	}
	
	public static void main (String[] args) {
		B b1 = new B(); //nn serve istanziare la classe più esterna top level A in questo caso StaticNested a differenza del caso delle memberOuter
		System.out.println(b1.price); //anche se privato posso accedervi all'interno della top class
		
		System.out.println(B.getSize());
	}
}
