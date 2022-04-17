package ocp.chapter1.accessModifiers.cat;

public class BigCat {
	public String name = "cat";
	protected boolean hasFur = true;
	boolean hasPaws = true;
	private int id;
	
	//qui posso accedere a tutto
	//main è un metodo statico quindi ricordarsi la regola dei metodi statici che non possono accedere alle proprietà della classe non statiche!
	public static void main (String[] args) {
		BigCat cat = new BigCat();
		System.out.println(cat.name);
		System.out.println(cat.hasFur);
		System.out.println(cat.hasPaws);
		System.out.println(cat.id);

	}
}
