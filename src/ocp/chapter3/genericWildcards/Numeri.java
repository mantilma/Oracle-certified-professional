package ocp.chapter3.genericWildcards;

/*
 * posso utilizzare la wildcard di upperBound anche nella definizione di una classe per controllare i tipi che possono essere specificati
 * e permettendomi di invocare eventualmente metodi in questo caso della classe number. Cosa che non potrei fare se mettessi il tipo Generico T senza upper bound.
 */
public class Numeri <T extends Number> {
	T t;
	
	public void getNumber() {
		t.doubleValue(); // ho il vantaggio di utilizzare un metodo della classe Number!
	}
}
