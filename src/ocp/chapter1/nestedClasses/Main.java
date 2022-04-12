package ocp.chapter1.nestedClasses;

import ocp.chapter1.nestedClasses.MemberOuter.Inner;
import ocp.chapter1.nestedClasses.StaticNested.B;

public class Main {
	public static void main (String[] args) {
		MemberOuter outer = new MemberOuter();
		Inner inner = outer.new Inner();
		inner.go();
		
		MemberOuter.Inner inner2 = outer.new Inner();
		inner2.go();
		
		//utilizzo delle static nested class vedere la differenza che facendo l'import normale o anche statico posso utilizzare senza istanziare la classe
		//top level A più esterna MemberOuter
		B b1 = new B();
		
	}
}
