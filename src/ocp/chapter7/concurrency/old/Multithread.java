package ocp.chapter7.concurrency.old;

//approccio vecchio prima di java 5 senza executorservice. utilizzo interfaccia runnable.
public class Multithread {
	
	public static void main (String[] args) {
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println(coreCount);
		
		//io creo un thread che prende nel costruttore un Task che è una implementazione della interfaccia funzionale Runnable
		Thread t1 = new Thread(new Task());
		t1.start();
		
		//visto che runnable è una interfaccia funzionale avrei potuto utilizzare una lambda expression
		Thread t2 = new Thread(() -> System.out.println("this is a task lambda"));
		t2.start();
		
	}
	
	

}
