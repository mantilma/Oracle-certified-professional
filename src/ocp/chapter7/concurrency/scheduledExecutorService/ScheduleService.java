package ocp.chapter7.concurrency.scheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleService {

	public static void main(String[] args) {
		//creazione pool per schedulazione di task
		ScheduledExecutorService service = null;
		
		try {
			//anche qui creo un pool con un solo thread ma posso creare anche con piu thread con:
			//newScheduledThreadPool(int nthreads)
			 service = Executors.newSingleThreadScheduledExecutor(); 
			 
			 //il task viene processato dopo 5 secondi di ritardo. 1 volta. Passo un task Runnable
			 ScheduledFuture<?> sv = service.schedule(() -> System.out.println("Runnable Task 1"), 5, TimeUnit.SECONDS);
			 
			//il task viene processato dopo 10 secondi di ritardo. 1 volta. Passo un task Callable
			 ScheduledFuture<String> sv2 = service.schedule(() -> {
				 System.out.println("Callable Task");
				 return "ok";
			 }, 10, TimeUnit.SECONDS);
			 
			 //il task viene processato ripetutamente ogni 3 secondi
			 ScheduledFuture<?> sv3 = service.scheduleAtFixedRate(() -> System.out.println("Runnable Task 2"), 3, 3, TimeUnit.SECONDS);
		
			 //il task processato dopo 10 soltanto però che è terminato il precedente
			 ScheduledFuture<?> sv4 =  service.scheduleWithFixedDelay(() -> System.out.println("Runnable Task 3"), 4, 4, TimeUnit.SECONDS);
		}
		
		finally {
			
			
		}
	}

}
