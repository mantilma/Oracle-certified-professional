package ocp.chapter4.optional;

import java.util.Optional;

public class Average {
	public static Optional<Double> getAverage (int... scores){
		if (scores.length == 0) return Optional.empty();
		
		double sum = 0;
		for (int score: scores) sum+=score;
		
		return Optional.of((Double) sum / scores.length);

	}
	
	public static void main (String[] args) {
		Optional<Double> o = getAverage(90, 100);
		if (o.isPresent()) System.out.println(o.get());
	}
}
