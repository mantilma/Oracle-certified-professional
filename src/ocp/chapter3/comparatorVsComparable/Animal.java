package ocp.chapter3.comparatorVsComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Animal implements Comparable<Animal>{
	
	private int id;
	private int weight;
	
	@Override
	public int compareTo(Animal a) {		
		return this.id - a.id;
	}
	
	@Override
	public String toString() {
		return "Animal [id=" + id + ", weight=" + weight + "]";
	}

	//compareTo generally must be consistent with equals in other words if and only if  x.equals(y) is true whenever x.compareTo(y) equals 0
	@Override
	public boolean equals (Object obj) {
		if (! (obj instanceof Animal)) return false;
		Animal animal = (Animal) obj;
		return this.id == animal.id;
	}
	
	@Override
	public int hashCode () {
		return this.id;
		
	}
	
	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		
		a1.id = 5;
		a2.id = 6;
		a1.weight = 60;
		a2.weight = 50;
		
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(a2);
		animals.add(a1);
		
		Collections.sort(animals); //qui utilizza il comparable implementato prima, se non avessi implementato l interfaccia avrei avuto errore di compilazione!!!
		System.out.println(animals);
		
		//oppure posso creare un treeset di animal
		Set<Animal> animalSet = new TreeSet<>();
		animalSet.add(a1);
		animalSet.add(a2);
		System.out.println("TRESET -> " + animalSet); // se non avessi implementato Comparable avrei avuto errore a run time nel primo Add!!!
		
		
		//supponiamo che io voglia non utilizzare l'ordinamento per id imposto dalla classe con l'implementazione dell'interfaccia comparable
		//posso utilizzare interfaccia funzionale comparator
		
		//implementazione con anonymous inner class
		Comparator<Animal> c = new Comparator<Animal>() {

			@Override
			public int compare(Animal o1, Animal o2) {
				
				return o1.weight - o2.weight;
			}
			
		};
		
		//stessa implementazione con lambda expression
		Comparator<Animal> c2 = (o1,o2) -> o1.weight - o2.weight;
		
		Collections.sort(animals, c);
		System.out.println(animals);
		
		Collections.sort(animals, c2);
		System.out.println(animals);
		
		//e se volessi ordinare per id ed anche per peso?
		Comparator<Animal> c3 = new Comparator<Animal>() {

			@Override
			public int compare(Animal o1, Animal o2) {
				
				int result = o1.id - o2.id;
				if (result!=0) return result;
				return o1.weight - o2.weight;
			}
			
		};
		
		Animal a3 = new Animal();
		a3.id = 6;
		a3.weight = 70;
		animals.add(a3);
		
		Collections.sort(animals, c3);
		System.out.println(animals);
		
		//con espressione lambda
		Comparator<Animal> c5 = (o1, o2) -> {
			int result = o1.id - o2.id;
			if (result!=0) return result;
			return o1.weight - o2.weight;
		};
		
		Collections.sort(animals, c5);
		System.out.println(animals);
		
		//per fare la stessa cosa di c3 possiamo utilizzare alcuni default interface method che a partire da java 8 l'interfaccia comparator ci mette a disposizione
		Comparator<Animal> c4 = new Comparator<Animal>() {

			@Override
			public int compare(Animal o1, Animal o2) {
				Comparator<Animal> c = Comparator.comparingInt(a -> a.id);
				c = c.thenComparingInt(a -> a.weight);
				return c.compare(o2, o1); //ho invertito l'ordine
			}
			
		};
		
		Collections.sort(animals, c4);
		System.out.println(animals);
				
		
		//per utilizzare il comparator anziche il comparable all interno di un treeSet glielo passo al costruttore
		Set<Animal> treeSet = new TreeSet<Animal>(c4);
		treeSet.add(a1);
		treeSet.add(a2);
		System.out.println("TREESET ORDINATO PER PESO" + treeSet); //qui ho equal che ragiona per id, e hashcode memorizza per id quindi due oggetti uguali 
		//vengono memorizzati nella stessa locazione di memoria. quindi ok! legge equals = true -> hashcode = true
		//quello che si rompe è il fatto che se equals = true il comparator non è 0. Ma diciamo che per il comparator questa incosinstenza è ammessa, mentre nel 
		//comparable devo essere stringente!!!
		
	}
	
}
