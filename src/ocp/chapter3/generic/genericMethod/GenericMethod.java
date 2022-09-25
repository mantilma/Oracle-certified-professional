package ocp.chapter3.generic.genericMethod;

import ocp.chapter3.generic.genericClass.Cassa;

public class GenericMethod {
	//firma metodo: access modifier + static (ma può essere anche un metodo non statico)
	//+ tipo formale del generico + return type + nome metodo + parametri di input
	public static <T> void sink(String s) { }
	
	public static <T> String sink2(T t) { 
		return "";
	}
	
	public static <T> Cassa<T> sink3(T t) { 
		return new Cassa<T>();
	}
}
