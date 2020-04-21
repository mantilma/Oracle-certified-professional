package ocp.chapter4.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams {

	public static void main(String[] args) {
		List<Person> people = getPeople();
		
		//Con l'approccio imperativo io per poter filtrare all'interno della mia collection ad esempio le sole donne dovevo scrivere qualcosa del genere:
		List<Person> female = new ArrayList<>();
		for (Person person: people) {
			if (person.gender.equals(Gender.FEMALE)) 
				female.add(person);
		}
		female.forEach(System.out::println);
		
		//Ora con gli stream e le lambda function il mio codice è molto più compatto, più pulito, con meno possibilità di errori.
		List<Person> female2 = 
				people.stream() //apro lo stream
				.filter(p -> p.gender.equals(Gender.FEMALE))
				.collect(Collectors.toList());
		
		female2.forEach(System.out::println);
		
	}
	
	private static List<Person> getPeople() {
		return List.of(
				new Person("Marco Rossi", 10, Gender.MALE),
				new Person("Mirella Rossi", 19, Gender.FEMALE),
				new Person("Silvia Castellani", 50, Gender.FEMALE),
				new Person("ALberto Nosotti", 35, Gender.MALE),
				new Person("Elena Verdi", 80, Gender.FEMALE),
				new Person("Stefano Bossetti", 72, Gender.MALE),
				new Person("Vincenzo Scala", 26, Gender.MALE)
				);		
	}

	
}

class Person {
	public String name;
	public int age;
	public Gender gender;
	
	public Person(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
}

enum Gender {
	MALE, FEMALE;
}
