package ocp.chapter3.generic.genericClass;

public class Cassa<T> {
	private T contenuto;

	public T getContenuto() {
		return contenuto;
	}

	public void setContenuto(T contenuto) {
		this.contenuto = contenuto;
	}

}
