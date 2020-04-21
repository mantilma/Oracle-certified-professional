package ocp.chapter3.genericWildcards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main (String[] args) {
		ArrayList<Animal> list = new ArrayList<>();
		Animal a = new Animal();
		Dog d = new Dog();
		
		//posso aggiungere ad un Arraylist di Animal oggetti come Dog e Cat
		list.add(a);
		list.add(d);

		System.out.println(list);
		
		// a differenza di quello che accade con gli array. Ad esempio io non ho errore se:
		Animal[] animals = new Animal [1];
		Dog[] dogs = new Dog[1];
		animals = dogs;
		// però a run time se io aggiungo ad animals dei gatti ho errore a run time perche in memoria ho comunque un array di dog.
		//animals[0] = new Cat(); //COMPILA!!! Ma avrò runtime exception ArrayStoreException! A runtime java mi protegge.

		//quello che non posso fare è assegnare una referenza di Collection di Animal ad una referenza di Collection di Dog e viceversa. Non funziona come con gli array!
		ArrayList<Animal> listAnimal = new ArrayList<>();
		ArrayList<Dog>	listDog = new ArrayList<>();
		//listDog = listAnimal; //compilation error questo vale anche per gli array non posso scrivere dogs = animals;
		//add(listAnimal); //compilation error

		/*
		 * in questo visto che listAnimal può contenere oggetti sia di Animal sia di Dog che di Cat quando vogliamo estrarre elementi da listDog rischieremmo
		 * di tirare fuori anche oggetti che non sono cani rompendo il contratto. 
		 * Ma poi questo vale in maniera analoga anche per gli array -> non posso fare riprendendo l'esempio di prima: dogs = animals //compile error 
		 listDog = listAnimal; //compilation error
		 add(listAnimal);

		 * nel secondo caso se listAnimal punta alla listDog corriamo il pericolo di inserire in list dog oggetti che non siano dog ma anche animal e cat.
		 * A runtime, causa type erasure, java non se ne accorge come ad esempio negli array (nell'esempio fatto prima) ed è per questo che previene tutto ciò 
		 * dando un errore di compilazione:		
		 listAnimal = listDog;
		 add2(listDog); //analogo alla linea sopra. Provo a passare al metodo add2 una lista di dog ma questo vuole una lista di animal
		 */

		/*
		 * proprio per questo nascono le wildcard
		 */
		processElements(listAnimal);
		processElements(listDog);

		processElements2(listAnimal);
		processElements2(listDog);

		insertElements(listAnimal);
		insertElements(new ArrayList<Object>());

	}

	public static void add (ArrayList<Dog> list) {
		list.add(new Dog());
	}

	public static void add2 (ArrayList<Animal> list) {
		list.add(new Cat());
	}

	/*
	 * The processElements() method can now be called with any generic List as parameter. 
	 * For instance a List<Animal>, a List<Dog>, List<Cat>, a List<String> etc.
	 * Since the you do not know what type the List is typed to, you can only read from the collection, 
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
		//list.add(new Object()); //occhi che questo NON POSSO FARLO COMPILATION ERROR
	}


}
