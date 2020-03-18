package ocp.chapter2.designPattern;

//lazy initialization. L'oggeto viene crato soltanto quando ne abbiamo bisogno la prima volta.
public class SingletonVersion3 {
	private static SingletonVersion3 instance;
	
	private SingletonVersion3 () {};
	
	public static synchronized SingletonVersion3 getInstance() {
		if (instance == null) {
			instance = new SingletonVersion3();
		}
		
		return instance;
	}
}
