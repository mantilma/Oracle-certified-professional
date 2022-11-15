package ocp.chapter2.designPattern;

//lazy initialization. L'oggetto viene creato soltanto quando ne abbiamo bisogno la prima volta.
public class SingletonVersion3 {
	private static SingletonVersion3 instance;
	
	private SingletonVersion3 () {}; //sempre il costruttore privato
	
	public static synchronized SingletonVersion3 getInstance() { //meotdo da richiamare per farci ritornare il singleton con sua creazione se questa non già stata fatta!
		if (instance == null) {
			instance = new SingletonVersion3();
		}
		
		return instance;
	}
}
