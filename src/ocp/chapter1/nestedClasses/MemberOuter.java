package ocp.chapter1.nestedClasses;

//this is an example of member inner class that is a class defined at the same level as instance (member,properties) variables
public class MemberOuter {
	private String greeting = "Hi";
	
	// dichiaro la member inner class e vediamo che è definita allo stesso livello dove dichiaro le proprietà costruttori e metodi
	// posso utilizzare qualsiasi access modifiers (private default protected or public
	private class Inner { 
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
		MemberOuter outer = new MemberOuter();
		outer.CallInner();
		
		//Inner inner = new Inner(); Non si può fare
		Inner inner = outer.new Inner();
		inner.go();
		
	}
}
