package ocp.chapter3.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Interfacelist {
	
	//Da questa interfaccia abbiamo: ArrayList, LinkedList, Vector(vecchia implementazione array) e Stack(vecchia implementazione ArrayDequeue)
	public static void main (String[] args) {
		
		Collection<String> c = new ArrayList<>();
		//Metodi comuni interfaccia Collection<E>
		System.out.println("*** COLLECTION ***");
		System.out.println(c.add("prova1"));
		System.out.println(c.add("prova1")); //-> ammette duplicati quindi restituisce true con Set sarebbe stato false
		
		System.out.println(c.remove("prova1")); //-> restituisce true
		System.out.println(c.remove("prova2")); // -> restituisce false;
		System.out.println(c);
		
		c.add("prova2");
		System.out.println(c); 
		c.clear();
		System.out.println(c);
		
		System.out.println(c.isEmpty()); // restituisce true
		c.add("prova1");
		System.out.println(c.isEmpty()); //restituisce false
		
		System.out.println(c.size()); //restituisce 1
		
		//Metodi caratteristici interfaccia List
		System.out.println("*** LIST ***");
		
		//occhio al discorso che nelle linkedlist l'index è di tipo logico, io accedo agli elementi sempre scorrendo in o(n)
		//la lista. Per fare questi esempi avrai potuto usare chiaramente anche ArrayList. In questo caso l'accesso con indice
		//essendo gli array memorizzati in memoria in celle continue l'accesso è o(1)
		List<Integer> l = new LinkedList<>();
		l.add(1);
		l.add(2);
		l.add(1,3);
		System.out.println(l);
		
		System.out.println(l.get(2));
		System.out.println(l.indexOf(3));
		
		l.add(3);
		System.out.println(l);
		System.out.println(l.indexOf(3));
		System.out.println(l.lastIndexOf(3));
		
		System.out.println(l.remove(1));
		System.out.println(l);
		
		System.out.println(l.set(2, 4));
		System.out.println(l);
		
		//L'interfaccia Set non aggiunge nessun extra metodo da conoscere rispetto a quelli comuni delle collection.
		//Mi devo solo ricordare che non ammettono duplicati
		System.out.println("*** SET ***");
		Set<Integer> s = new HashSet<>(); //lhashset è un hashtable con singolo valore ovvero la chiave coincide anche con il valore
		System.out.println(s.add(66));
		System.out.println(s.add(10));
		System.out.println(s.add(10)); //non ammette duplicati -> restituisce false
		
		
		
	}
	
	
	

}
