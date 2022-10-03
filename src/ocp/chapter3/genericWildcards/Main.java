package ocp.chapter3.genericWildcards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main (String[] args) {
		List<Animal> list = new ArrayList<>();
		Animal a = new Animal();
		Dog d = new Dog();
		Cat c = new Cat();
		
		//posso aggiungere ad un Arraylist di Animal oggetti come Dog e Cat
		list.add(a);
		list.add(d);
		list.add(c);

		System.out.println(list); // e fin qui è tutto chiaro!
		
		//Ora però giochiamo con i puntatori ai riferimenti. Proviamo a fare dei downcasting e upcasting
		//Io posso fare:
		Animal[] animals = new Animal[1];
		Dog[] dogs = new Dog[1];
		animals[0] = d; //posso assegnare sia cani...
		animals[0] = c; //...sia gatti... ma questo come prima nelle liste
		//dogs = animals; //qui ho un errore di compilazione perche non posso assegnare un puntatore dog ad un array di Animal
		animals = dogs; //nell upcasting, cambio il puntatore animals facendolo puntare ad un array di cani, non ho errore di compilazione.
		// però a run time se io aggiungo ad animals dei gatti ho errore a run time perche in memoria ho comunque un array di dog.
		//animals[0] = new Cat(); //COMPILA!!! Ma avrò runtime exception ArrayStoreException! A runtime java mi protegge, xche è in grado di farlo!

		//nelle liste invece non posso assegnare una referenza di Collection di Animal ad una referenza di Collection di Dog e viceversa. 
		List<Animal> listAnimal = new ArrayList<>();
		List<Dog>	listDog = new ArrayList<>();
		//listDog = listAnimal; //questo downcasting chiaramente mi da compilation error questo vale anche per gli array, o latri oggetti, non posso 
		//scrivere dogs = animals;
		
		//listAnimal = listDog; //ma la differenza è qui con gli array. qui avrò subito compilation error
		//se non avessi questo errore in fase di compilazione java mi permetterebbe di fare questo:
		//listAnimal.add(c);

		 /* nel secondo caso "listAnimal = listDog" se listAnimal punta alla listDog corriamo il pericolo di inserire in list dog oggetti che non siano 
		 * dog ma anche animal e cat.
		 * A runtime, causa type erasure, java non se ne accorge come fa negli array (nell'esempio fatto prima), perchè nella collection list il metodo 
		 * ad esempio add inserisce object, 
		 * ed è per questo che previene tutto ciò dando un errore di compilazione!	
		 */

		/*
		 * proprio per questo nascono le generics wildcard con relativi bounds
		 */
		processElements(listAnimal);
		processElements(listDog);

		processElements2(listAnimal);
		processElements2(listDog);

		insertElements(listAnimal);
		insertElements(new ArrayList<Object>());
		

	}

	/*
	 * The processElements() method can now be called with any generic List as parameter. 
	 * For instance a List<Animal>, a List<Dog>, List<Cat>, a List<String> etc.
	 * Since then you do not know what type the List is typed to, you can only read from the collection, 
	 * and you can only treat the objects read as being Object instances. Here is an example: 
	 */
	public static void processElements(List<?> elements){
		for(Object o : elements){
			System.out.println(o);
		}
	}

	/*
	 *  List<? extends Animal> means a List of objects that are instances of the class Animal, or subclasses of Animal (e.g. Dog and Cat).

	When you know that the instances in the collection are of instances of Animal or subclasses of Animal, it is safe to read the instances of the collection 
	and cast them to Animal instances. 
	The processElements() method still cannot insert elements into the list, because you don't know if the list passed as parameter is typed to the 
	class Animal, Dog or Cat. here is an example:
	 */

	public static void processElements2(List<? extends Animal> elements){
		for(Animal a : elements){
			a.getValue();
		}
	}

	/*
	 *  List<? super Animal> means that the list is typed to either the Animal class, or a superclass of Animal.

	When you know that the list is typed to either Animal, or a superclass of Animal, it is safe to insert instances of 
	Animal or subclasses of Animal (e.g. Dog or Cat) into the list. But i cannot add an instance of Object!! Here is an example: 
	 */

	public static void insertElements(List<? super Animal> list){
		list.add(new Animal());
		list.add(new Dog());
		list.add(new Cat());
		list.remove(1);
		//list.add(new Object()); //occhi che questo NON POSSO FARLO COMPILATION ERROR
	}


}
