package ocp.chapter2.designPattern;

public class SingletonVersion1 {
	/* 1 private static final property
	 * static cause we need a global point of access
	 * final we prevent to create other singleton object within the class itself.
	 */
	private static final SingletonVersion1 obj = new SingletonVersion1();
	// private costruttore ed è questo la base del singlteno perchè non posso invocare il costruttore al di fuori e pertanto creare nuovi oggetti a piacimento.
	private SingletonVersion1 () {};
	
	// method per la restituzione del singleton
	public SingletonVersion1 getInstance() {
		return obj;
	};
	
	//altri metodi
	public synchronized void prova () {
		System.out.println("prova syncronized thread safe");
	};
}

