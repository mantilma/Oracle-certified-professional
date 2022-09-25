package ocp.chapter3.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class CustomCollection {
	
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
		System.out.println(s.add(66)); //non ammette duplicati -> restituisce false
		System.out.println(s.add(8)); 
		System.out.println(s.add(90)); 
		System.out.println(s); //con hashSet non è garantito ordinamento! cosa che invece avremmo potuto avere se avessi utilizzato TreeSet
		
		//Per l'esame mi devo ricordare che i TreeSet e soltanto loro implementano interfaccia NavigableSet
		NavigableSet<Integer> ns = new TreeSet<>();
		for (int i =1; i <=20; i++) ns.add(i);
		System.out.println(ns.lower(10)); //restiutisce il primo elemento < 10 altrimenti null -> quindi 9
		System.out.println(ns.higher(10)); //restituisce il primo elemento > 10 altrimenti null -> quindi 11
		System.out.println(ns.higher(20)); // -> null
		System.out.println(ns.floor(10)); //restituisce il primo elemento <= 10 altrimenti null -> quindi 10
		System.out.println(ns.floor(200)); // -> quindi 20
		System.out.println(ns.floor(0)); //quindi null
		System.out.println(ns.ceiling(10)); //restituisce il primo elemento >= 10 altrimenti null -> quindi 10
		System.out.println(ns.ceiling(21)); //-> null
		System.out.println(ns.ceiling(20)); //-> 20
		
		
		System.out.println("*** QUEUE ***");
		//metodi specifici per utilizzo di ArrayDeque come queue (policy FIFO inserimento ed estrazione parti opposto della struttura dati)
		Queue<Integer> queue = new ArrayDeque<>();
		System.out.println("queue");
		System.out.println(queue.add(1)); // inserisce in coda e ritorna true, errore throws excepiton
		System.out.println(queue.offer(2)); // come add, ma restituisce falso se fallisce nessuna eccezione
		System.out.println(queue);
		System.out.println(queue.element()); //restituisce cima della coda ma non cancella, se vuota exception
		System.out.println(queue.remove()); //rimuove e restituisce elemento in cima, se vuota exception
		System.out.println(queue.poll()); //rimuove e restituisce elemento in cima, se vuota nessuna eccezione
		System.out.println(queue);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		
		
		//metodi specifici per utilizzo di ArrayDeque come stack (policy LIFO inserimento ed estrazione lati opposti)
		System.out.println("stack");
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(1); //nn restituisce nulla
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.push(3);
		
		//metodi per entrambi solo peek restituisce elemento in cima ma non lo cancella, null se coda vuota
		System.out.println("peek queue");
		System.out.println(queue.peek());
		System.out.println("peek stack");
		System.out.println(stack.peek());
		
		
		System.out.println("*** MAP ***");
		Map<String,String> map = new HashMap<>();
		System.out.println(map.put("koala", "bamboo"));
		map.put("lion", "meat");
		map.put("giraffe", "leaf");
		System.out.println(map);
		System.out.println(map.get("giraffe"));
		System.out.println(map.remove("giraffe"));
		System.out.println(map);
		for (String key: map.keySet()) System.out.print(key + " ");
		
		
		
	}
	
	
	

}
