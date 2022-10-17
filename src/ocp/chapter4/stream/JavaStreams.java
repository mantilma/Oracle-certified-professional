package ocp.chapter4.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.IntPredicate;
import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
		
		//Ora con gli stream e le lambda function il mio codice è molto più compatto, più pulito, con meno possibilità di errori. Functional programming.
		List<Person> female2 = 
				people.stream() //apro lo stream
				.filter(p -> p.gender.equals(Gender.FEMALE))
				.collect(Collectors.toList()); //ritorna una collection list casuale può essere arryalist o altro
		
		female2.forEach(System.out::println);
		
		//TERMINAL OPERATION: count, max, min, findAny, findFirst, allMatch, anyMatch, noneMatch
		//	Count
		System.out.println("Count: " + people.stream().count());
		//	Max
		Comparator<Person> c = (p1, p2) -> p1.age - p2.age;
		System.out.println("Max: " + people.stream().max(c));
		//	Min
		System.out.println("Min: " + people.stream().min(c));
		//	FindAny
		System.out.println("FindAny: " + people.stream().findAny());
		//	AllMatch
		System.out.println("AllMatch: " + people.stream().allMatch(p -> p.age > 5));
		// ForEach
		List<Person> copia = new ArrayList<>();
		//copia = new ArrayList<>(); qeusto non posso farlo perche copia deve essere final o effectively final per essere vista all interno della anonymous inner class 
		people.stream().forEach(new Consumer<Person>()  {

			@Override
			public void accept(Person t) {
				// TODO Auto-generated method stub
				copia.add(t);			
	
			}
			
		});
		//con lambda expression
		people.stream().forEach(s -> copia.add(s));
		//con il method reference
		people.stream().forEach(copia::add);
		System.out.println(copia);
		
		//	Reduce
		//questo utilizzo del reduce è un po forzato. In genere se io ho uno stream<String> il reduce mi produce un risultato di tipo String.
		//qui invece sfrutto reduce del terzo tipo ovvero U reduce (U identity, BiFunction<U,? super T, U> accumulator, BinaryOperator<U> combiner)
		//per produrre un unica stringa che tutte le concat dei nomi delle persone del flusso iniziale stream<person>
		BiFunction<String, Person, String> bf = (String s,Person p) -> s += p.name;
		BinaryOperator<String> bo= (s1, c1) -> s1 + c1; //questa è utlizzata soltanto nello stream parallelo per combinare i risultati
		String word = people.stream().reduce("", (String s,Person p) -> s += p.name, bo);
		System.out.println(word);
		//	Collect
		HashSet<Person> tree = people.stream().collect(() -> new HashSet<>(), (t, p) -> t.add(p), (t1, t2) -> t1.addAll(t2));
		tree = people.stream().collect(HashSet::new, HashSet::add, HashSet::addAll); //stesso di prima ma con method reference
		System.out.println("Collect operation: " + tree);
		
		//INTERMEDIATE OPERATION: map
		//MAP: utilizzo l'esempio del reduce di prima per far vedere come map lavora trasformando uno stream<T> in un altro stream<R>. Questa è una forma più pulita
		//dell'esempio precedente fatto con solo reduce.
		String word1 = people.stream().map(p -> p.name).reduce("", (s1,s2) -> s1 + s2);
		System.out.println(word1);

		//PRIMITIVE STREAM
		IntStream intStream = IntStream.of(11, 22, 33, 44, 55);
		
		
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
