package ocp.chapter4.esercizi;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		// DOMANDA 1
		Stream<String> stream = Stream.iterate("", (s) -> s + "1");
		stream.limit(4).forEach(System.out::println);;
		
		//DOMANDA 2
		Predicate<? super String> predicate = s -> s.startsWith("g"); // con ? super String posso passargli anche un object in input al predicate
		
		//DOMANDA 6
		Stream<String> s = Stream.generate(() -> "meow");
		s.limit(4).forEach(System.out::println);
		
		//DOMANDA 14
		Stream<Integer> s1 = Stream.of(1);
		IntStream is = s1.mapToInt(x -> x);
		DoubleStream ds = is.mapToDouble(x -> x);
		//Stream<Integer> s2 = ds.mapToInt(x -> x); //mapToInt ritorna un IntStream e non uno Stream<Integer> !!!
		Stream<Double> s3 = ds.mapToObj(x -> x);
		s3.forEach(System.out::println);
		
		//DOMANDA 20
		List<Integer> l = IntStream.range(1, 6)
				.mapToObj(i->i)
				.collect(Collectors.toList());
		l.forEach(element -> System.out.println(element));
	}

}
