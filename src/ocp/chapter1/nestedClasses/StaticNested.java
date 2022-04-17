package ocp.chapter1.nestedClasses;

//Le static nested class sono uguali alle member ma soltanto statiche
public class StaticNested {
	static class B {
		private int price = 6;
	}
	
	public static void main (String[] args) {
		B b1 = new B(); //nn serve istanziare la classe più esterna top level A in questo caso StaticNested a differenza del caso delle memberOuter
		System.out.println(b1.price); //anche se privato posso accedervi all'interno della top class
	}
}
