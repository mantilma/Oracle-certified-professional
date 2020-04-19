package ocp.chapter3.methodReferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

// method reference: short notation for lambda expression
public class Main {
	public static void main (String args[]) {
		
		//1 TIPO: instance method reference to be determined at runtime
		// anonymous inner class
		Predicate<String> predicate = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				// TODO Auto-generated method stub
				return t.isEmpty();
			}
			
		};
		System.out.println(predicate.test("prova"));
		
		//lambda
		Predicate<String> predicate2 = t -> t.isEmpty();
		System.out.println(predicate2.test("prova"));
		
		//method reference: dichiarazione instance di tipo String: method
		Predicate<String> predicate3 = String::isEmpty;
		System.out.println(predicate3.test("prova"));
		
		
		
		//2 TIPO: instance method reference on particular instance
		// anonymous inner class
		Predicate<String> predicate4 = new Predicate<String>() {
			private String str = "abc";
			@Override
			public boolean test(String t) {
				return str.startsWith(t);
			}
			
		};
		System.out.println(predicate4.test("a"));		
		
		//lambda
		String str = "abc";//the instance
		Predicate<String> predicate5 = t -> str.startsWith(t);
		System.out.println(predicate5.test(str));
		
		//method reference: dichiarazione instance:method
		Predicate<String> predicate6 = str::startsWith;
		System.out.println(predicate6.test("b"));
		
		
		
		//3 TIPO: Constructor method instance
		// anonymous inner class
		Supplier<ArrayList<Integer>> s = new Supplier<ArrayList<Integer>>() {
			@Override
			public ArrayList<Integer> get() {
				// TODO Auto-generated method stub
				return new ArrayList<>();
			}
			
		};
		
		ArrayList<Integer> arrayList = s.get();
		arrayList.add(5);
		System.out.println(arrayList);
		
		//lambda
		Supplier<ArrayList<Integer>> s1 = () -> new ArrayList<Integer>();
		arrayList = s1.get();
		arrayList.add(6);
		System.out.println(arrayList);
		
		//method reference
		Supplier<ArrayList<Integer>> s2 = ArrayList<Integer>::new;
		arrayList = s2.get();
		arrayList.add(7);
		System.out.println(arrayList);
		
		
		
		//4 TIPO: Static methods instance
		// anonymous inner class
		Consumer<ArrayList<Integer>> c = new Consumer<ArrayList<Integer>>() {

			@Override
			public void accept(ArrayList<Integer> t) {
				// TODO Auto-generated method stub
				Collections.sort(t);
			}
			
		};
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(2);
		numbers.add(1);
		System.out.println(numbers);
		c.accept(numbers);
		System.out.println(numbers);
		
		//lambda
		Consumer<ArrayList<Integer>> c1 = t -> Collections.sort(t);
		numbers.add(2);
		numbers.add(1);
		System.out.println(numbers);
		c1.accept(numbers);
		System.out.println(numbers);
		
		//method reference
		Consumer<ArrayList<Integer>> c2 = Collections::sort;
		numbers.add(2);
		numbers.add(1);
		System.out.println(numbers);
		c2.accept(numbers);
		System.out.println(numbers);
	}
}
