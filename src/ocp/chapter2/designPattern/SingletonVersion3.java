package ocp.chapter2.designPattern;

//ESEMPIO DI LAZY INITIALIZATION. L'oggetto viene creato soltanto quando ne abbiamo bisogno la prima volta.
public class SingletonVersion3 {
	// 1 questa proprietà non può essere più final come nei due casi precedenti di singleton, perchè se lo fosse avrei bisogno di inizializzarlo
	//o in linea o nel costruttore o con l inizializzazione statica. Visto che ora sposto l inizializzazione nel metodo getInstance devo eliminare
	//final altrimenti errore di compilazione
	private static SingletonVersion3 instance;
	
	private SingletonVersion3 () {}; //sempre il costruttore privato
	
	public static synchronized SingletonVersion3 getInstance() { //meotdo da richiamare per farci ritornare il singleton con sua creazione se questa non già stata fatta!
		if (instance == null) {
			instance = new SingletonVersion3();
		}
		
		return instance;
	}
}
