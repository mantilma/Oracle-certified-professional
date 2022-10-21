package ocp.chapter7.concurrency.scheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleService {

	public static void main(String[] args) {
		//schedulazione di task
		ScheduledExecutorService service = null;
		
		try {
			 service = Executors.newSingleThreadScheduledExecutor();
			 
			 //il task viene processato dopo 10 secondi di ritardo. 1 volta. Passo a Runnable
			 ScheduledFuture<?> sv = service.schedule(() -> System.out.println("Runnable Task"), 5, TimeUnit.SECONDS);
			 
			//il task viene processato dopo 10 secondi di ritardo. 1 volta. Passo a Callable
			 ScheduledFuture<String> sv2 = service.schedule(() -> {
				 System.out.println("Callable Task");
				 return "ok";
			 }, 10, TimeUnit.SECONDS);
			 
			 //il task viene processato ripetutamente ogni 10 secondi
		
		}
		
		finally {
			
			
		}
	}

}
