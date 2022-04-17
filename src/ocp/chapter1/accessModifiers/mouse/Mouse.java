package ocp.chapter1.accessModifiers.mouse;

import ocp.chapter1.accessModifiers.cat.BigCat;

public class Mouse {
	//altro package + non è una sottoclasse, posso accedere solo alle proprietà con access modifier public
	public static void main (String[] args) {
		BigCat cat = new BigCat();
		System.out.println(cat.name);
		//System.out.println(cat.hasFur);
		//System.out.println(cat.hasPaws);
		//System.out.println(cat.id); id ha access modifiers private

	}
}
