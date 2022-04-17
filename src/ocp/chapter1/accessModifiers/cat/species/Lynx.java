package ocp.chapter1.accessModifiers.cat.species;

import ocp.chapter1.accessModifiers.cat.BigCat;

public class Lynx extends BigCat{
	//siamo al di fuori del package e ho una sottoclasse quindi in teoria può accedere ai protected e public...
	//ma attenzione se io dichiaro un riferimento BigCat posso accedere solo al public. Per accedere al protected deve essere un riferimento Lynx
	//perchè soltanto in questo caso è visto come sottoclasse!
	public static void main (String[] args) {
		BigCat cat = new BigCat();
		System.out.println(cat.name);
		//System.out.println(cat.hasFur); //non ho accesso
		//System.out.println(cat.hasPaws); //non ho accesso
		//System.out.println(cat.id); //non ho accesso
		
		BigCat cat1 = new Lynx();
		System.out.println(cat1.name);
		//System.out.println(cat1.hasFur); //non ho accesso
		//System.out.println(cat1.hasPaws); //non ho accesso
		//System.out.println(cat1.id); //non ho accesso
		
		Lynx cat2 = new Lynx();
		System.out.println(cat2.name);
		System.out.println(cat2.hasFur);
		//System.out.println(cat2.hasPaws); //non ho accesso
		//System.out.println(cat2.id); //non ho accesso
		
		cat2.prova();

	}
	
	public void prova() {
		BigCat cat1 = new BigCat();
		BigCat cat2 = new Lynx();
		Lynx cat3 = new Lynx();
		
		//System.out.println(cat1.hasFur); //come prima non ho accesso
		//System.out.println(cat2.hasFur); //come prima non ho accesso
		System.out.println(cat3.hasFur);
		
		this.hasFur = false; //però posso fare questo ma non fa riferimento a cat1 cat2 o cat3 ma all'oggetto che chiamerà questo metodo
		System.out.println(this.hasFur);
	}
}
