package ocp.chapter5.esercizi;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Test {
	public static void main (String[] args) {
		//ESERCIZIO 15
		String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
		String m2 = Duration.ofMinutes(1).toString();
		String s = Duration.of(60, ChronoUnit.SECONDS).toString();
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(s);
		System.out.println(m1==m2);
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(s));
	}
}
