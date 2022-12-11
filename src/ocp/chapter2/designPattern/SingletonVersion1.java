package ocp.chapter2.designPattern;

public class SingletonVersion1 {
	/* 1 - private static final property
	 * static cause we need a global point of access
	 * final we prevent to create other singleton object within the class itself.
	 */
	private static final SingletonVersion1 obj = new SingletonVersion1();
	// 2 - private costruttore ed è questo la base del singlton perchè non posso invocare il costruttore al di fuori e pertanto creare nuovi oggetti a piacimento.
	private SingletonVersion1 () {};
	
	// 3 - method per la restituzione del singleton
	public SingletonVersion1 getInstance() {
		return obj;
	};
	
	//4 - altri metodi parola chiave syncronized per accesso thread safe, ovvero previene che due processi accedano allo stesso meotodo nello stesso istante
	public synchronized void prova () {
		System.out.println("prova syncronized thread safe");
	};
}

