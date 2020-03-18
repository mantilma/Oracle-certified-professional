package ocp.chapter2.designPattern;

public class SingletonVersion2 {
	private static final SingletonVersion2 obj;
	
	//singleton with static inizialization. Questa implementazione mi permette di aggiungere additional step
	//quando creo l'oggetto singleton
	static {
		obj = new SingletonVersion2();
	}
	
	private SingletonVersion2 () {};
	
	private SingletonVersion2 getInstance() {
		return obj;
	};
}
