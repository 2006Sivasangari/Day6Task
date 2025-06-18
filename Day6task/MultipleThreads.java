package Day6task;
public class MultipleThreads {
  
    static class MessagePrinter implements Runnable {
        private final String message;

        public MessagePrinter(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
      
        Runnable printer1 = new MessagePrinter("Hello from Thread 1");
        Runnable printer2 = new MessagePrinter("Hello from Thread 2");
        Runnable printer3 = new MessagePrinter("Hello from Thread 3");

       
        Thread thread1 = new Thread(printer1);
        Thread thread2 = new Thread(printer2);
        Thread thread3 = new Thread(printer3);

      
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

