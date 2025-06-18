package Day6task;

public class ExtendingThreadClass {
   
    static class NumberPrinter extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.err.println("Thread interrupted: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        
        NumberPrinter printer = new NumberPrinter();
        printer.start();
    }
}
