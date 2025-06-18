package Day6task;


	class Task implements Runnable {
	    private final String taskName;

	    public Task(String taskName) {
	        this.taskName = taskName;
	    }

	    @Override
	    public void run() {
	        try {
	            System.out.println(taskName + " started.");
	            Thread.sleep(1000); // Simulate task duration
	            System.out.println(taskName + " completed.");
	        } catch (InterruptedException e) {
	            System.err.println(taskName + " was interrupted.");
	        }
	    }
	}

	public class ThreadCoordination {
		
	    public static void main(String[] args) {
	        Thread thread1 = new Thread(new Task("Task 1"));
	        Thread thread2 = new Thread(new Task("Task 2"));
	        Thread thread3 = new Thread(new Task("Task 3"));

	        thread1.start();
	        try {
	            thread1.join();
	        } catch (InterruptedException e) {
	            System.err.println("Main thread was interrupted.");
	        }

	        thread2.start();
	        try {
	            thread2.join(); 
	        } catch (InterruptedException e) {
	            System.err.println("Main thread was interrupted.");
	        }

	        thread3.start();
	        try {
	            thread3.join();
	        } catch (InterruptedException e) {
	            System.err.println("Main thread was interrupted.");
	        }

	        System.out.println("All tasks completed.");
	    }
	}

