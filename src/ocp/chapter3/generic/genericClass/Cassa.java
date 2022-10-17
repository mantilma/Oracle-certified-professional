package ocp.chapter3.generic.genericClass;

//sto dicendo la cassa può avere qualsiasi tipo di Tipo. Questo pèerò mi limita i metodi che ho a disposizione qui in questa classe perchè
//potrò utilizzare solo quelli di Object!!!
public class Cassa<T> {
	private T contenuto;

	public T getContenuto() {
		return contenuto;
	}

	public void setContenuto(T contenuto) {
		this.contenuto = contenuto;
	}
	
	public void testMetodiADisposizione() {
		//this.contenuto. //ho a disposizione solo i metodi di object!
	}

}
