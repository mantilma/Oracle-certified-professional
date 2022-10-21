package ocp.chapter7.concurrency.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Approccio con executor service
public class ZooInfo {
	
	public static void main(String[] args) {
		//1 - Creo un pool con un solo thread. 
		//In realtà creare un pool con un solo thread serve a poco ma è a scopo illustrativo.
		ExecutorService service = null;
		
		try {
			service = Executors.newSingleThreadExecutor(); 
			System.out.println("begin");
		
		//2 - creato il pool devo inviare task al pool che poi se la vedrà lui a quale thread assegnare i task e come gestire il tutto
			service.execute(() -> System.out.println("Printing zoo inventory"));
			service.execute(() -> {
									for (int i=0; i<100; i++) 
										System.out.println(i);
									}
					);
			service.execute(() -> System.out.println("Printing"));
			System.out.println("end");		
		}
		
		finally {
			//3 - devo chiudere il pool altrimenti il programma rimane appeso. La chiusura avviene dopo aver completato
			//tutti i task già in coda. Non posso più inviare altri task al pool
			if (service != null) service.shutdown();
			//poiche pool in chiusura non posso più inviare task. Avrò una eccezione RejectionExecutionException
			//service.execute(() -> System.out.println("Lancia eccezione"));
			
			//ritorna true poichè lo shutdown è iniziato
			System.out.println(service.isShutdown());
			
			//ritorna true se tutti i task sono completati
		}
	}
}
