package ocp.chapter1.accessModifiers.cat;

public class CatAdmirer {
	
	//stesso package quindi posso accedere a tutte le proprietà di BigCat tranne a quella privata
	public static void main (String[] args) {
		BigCat cat = new BigCat();
		System.out.println(cat.name);
		System.out.println(cat.hasFur);
		System.out.println(cat.hasPaws);
		//System.out.println(cat.id); id ha access modifiers private

	}
}
