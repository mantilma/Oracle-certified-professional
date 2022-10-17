package ocp.chapter3.generic.genericMethod;

import ocp.chapter3.generic.genericClass.*;

public class GenericMethod <R> {
	//firma metodo: access modifier + static (ma può essere anche un metodo non statico)
	//+ tipo formale del generico aggiuntivo (non ci va R in questo caso perchè gia specificato a livello della classe 
	//+ return type + nome metodo + parametri di input
	public static <T> void sink(String s) { }
	
	public static <T> String sink2(T t) { 
		return "";
	}
	
	public static <T> Cassa<T> sink3(T t) { 
		return new Cassa<T>();
	}
	
	public <T extends Animal> void sink4(T t, R r) { 
		//r.getName(); // r può utilizzare solo i metodi di Object
		t.getName(); // t invece può utilizzare i metodi anche di Animal
		
	}

}
