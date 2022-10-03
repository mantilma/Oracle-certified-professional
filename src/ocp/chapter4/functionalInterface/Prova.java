package ocp.chapter4.functionalInterface;

import java.time.LocalDate;
import java.util.function.Supplier;

public class Prova {
	public static void main (String[] args) {
		
	//solito discorso: posso farlo con anonymous inner class
		Supplier<LocalDate> s1 = new Supplier<>() {

			@Override
			public LocalDate get() {
				// TODO Auto-generated method stub
				return LocalDate.now();
			}
			
		};
		
		System.out.println(s1.get());
		
		//con espressione lambda
		
		Supplier<LocalDate> s2 = () -> LocalDate.now();
		System.out.println(s2.get());
		
		//con method reference che è una ulteriore abbreviazione dell'espressione lambda
		Supplier<LocalDate> s3 = LocalDate::now;
		System.out.println(s3.get());
		
 	}
}
