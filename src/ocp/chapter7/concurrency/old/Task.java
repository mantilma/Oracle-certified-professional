package ocp.chapter7.concurrency.old;

public class Task implements Runnable{

	@Override
	public void run() {
		System.out.println("this is a task");
		
	}

}
