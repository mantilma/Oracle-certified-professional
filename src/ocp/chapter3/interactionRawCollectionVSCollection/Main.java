package ocp.chapter3.interactionRawCollectionVSCollection;

import java.util.ArrayList;
import java.util.List;

import ocp.chapter3.genericWildcards.Cat;
import ocp.chapter3.genericWildcards.Dog;

public class Main {

	public static void main(String[] args) {
		//INTERAZIONE TRA LEGACY CODE (RAW COLLECTION) e COLLECTION CON GENERICS pag 114 libro OCP
		List<Cat> cats = new ArrayList<>(); //Ho un oggetto arraylist di Cat quindi collection con generics
		List cat = cats; //Ho un puntatore (riferimento) che può puntare all 'oggetto arraylist di Cat
		cat.add(new Dog()); //posso aggiungere qualunque oggetto anche un CANE!!!
		//Cat c2 = cats.get(0); //avro classcast exception
		
		//AL CONTRARIO
		List cats2 = new ArrayList(); // Ho un oggetto arraylist di una RAW COLLECTION quindi object generici
		List<Dog> dogs = cats2; //faccio puntare riferimento generics la RAW COLLECTION
		cats2.add(new Cat()); //inserisco un cat
		Dog d = dogs.get(0); //avrò class cast exception perchè mi aspettavo un dog 
		
	}

}
