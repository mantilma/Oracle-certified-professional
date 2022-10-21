package ocp.chapter7.concurrency.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Approccio con executor service
public class ZooInfo {
	
	public static void main(String[] args) {
		//1 - Creo un pool con un solo thread. 
		//In realtà creare un pool con un solo thread serve a poco se voglio concurrency e parallelismo.
		//diciamo che questo pool è utilizzato se io voglio avere la certezza che task1 viene processato prima
		//del task 2, task 2 prima del task 3 ecc... ed anche a scopi didattici
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
			// inviare task anziche con execute con il metodo submit che mi restituisce un future che contiene info sul task
			Future<?> future = service.submit(() -> System.out.println("Printing"));
			System.out.println(future.isDone());
			
			System.out.println("end");		
		}
		
		finally {
			//3 - devo chiudere il pool altrimenti il programma rimane appeso. La chiusura avviene dopo aver completato
			//tutti i task già in coda. Non posso più inviare altri task al pool
			if (service != null) service.shutdown();
			//poiche pool in chiusura non posso più inviare task. Avrò una eccezione RejectionExecutionException
			//service.execute(() -> System.out.println("Lancia eccezione"));
			
			//ritorna true poichè lo shutdown è iniziato ma finche non completo tutti i task già in coda non è completato
			System.out.println(service.isShutdown());
			
			//ritorna true se tutti i task sono completati coda vuota quindi shutdown è terminato
			System.out.println(service.isTerminated());
			
			
			
		}
	}
}
