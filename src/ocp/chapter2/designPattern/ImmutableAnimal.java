package ocp.chapter2.designPattern;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public final class ImmutableAnimal { // 1 prevent methods from being overriden e pertanto non do la possibilità a nessuna sottoclasse di implementare metodi che vadano a modificare l immutabilità
	
	private final String species; // 2 mark all of the instance variables private and final
	private final int age;
	private final List<String> favoriteFoods;
	
	// 3 Use a constructor to set all properties of the object and never define setter methods for all properties.
	public ImmutableAnimal (String species, int age, List<String> favoriteFoods) {
		this.species = species;
		this.age = age;
		if(favoriteFoods == null) {
			throw new RuntimeException("favoriteFoods is required");
		}
		this.favoriteFoods = new ArrayList<String>(favoriteFoods); //qui fare attenzione perchè se io avessi scritto this.favoriteFoods = favoriteFooods io avrei fatto puntare allo stesso oggetto
		//e avrei permesso al chiamante di avere accesso ad un oggetto che può modificare!!!
	}

	public String getSpecies() {
		return species;
	}

	public int getAge() {
		return age;
	}

	/*
	 * Questo non è consentito perchè esternamente io posso chiamare i metodi di
	 * List favoriteFoods e di fatto modificarla Nelle list infatti il discorso
	 * dell'immutabilità creata con private final nella proprietà/attributo/campo e nel set all'interno delo costruttore mi permette
	 * di non consintere il cambio della referenza dell'oggetto, ma se io permetto questo get qualcuno può sempre invocare dei metodi
	 * come ad esempio add che cambino la lista!!!
	 */

	/*public List<String> getFavoriteFoods() {
		return favoriteFoods;
	}*/
	
	//posso però restituire un singolo elemento della lista
	public String getFavoriteFood(int index) {
		return this.favoriteFoods.get(index);
	}
	
	/*
	 * Se abbiamo bisogno di un metodo che modifichi una o più proprietà l'idea è quella di creare un nuovo
	 * oggetto ImmutableAnimal, copiare in esso gli elementi presenti più aggiungere la modifica necessaria, e restituirlo. Ese:
	 */
	public ImmutableAnimal addAge() {
		List<String> favoriteFoods = new ArrayList<String>();
		for (String s : this.favoriteFoods) {
			favoriteFoods.add(s);
		}
		ImmutableAnimal animal = new ImmutableAnimal(this.species, this.age + 1, favoriteFoods);
		return animal;
	}
	
	public static void main (String[] args) {
		ImmutableAnimal lion = new ImmutableAnimal("lion", 1, Arrays.asList("meat","more meat"));
		lion.addAge();
		System.out.println(lion.getAge());
		lion = lion.addAge();
		System.out.println(lion.getAge());
		
	}
	
	
}
