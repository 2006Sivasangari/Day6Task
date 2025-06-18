package Day6MainProg;
class TicketCounter {
    private int availableTickets = 10;

    public boolean bookTicket(String passengerName, int numberOfTickets) {
        synchronized (this) {
            System.out.println(passengerName + " is trying to book " + numberOfTickets + " ticket(s)...");

            try {
                // Simulate delay
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }

            if (numberOfTickets <= availableTickets) {
                availableTickets -= numberOfTickets;
                System.out.println("✅ " + passengerName + " successfully booked " + numberOfTickets + " ticket(s).");
                System.out.println("🎫 Remaining Tickets: " + availableTickets);
                return true;
            } else {
                System.out.println("❌ Sorry " + passengerName + ", not enough tickets.");
                System.out.println("🎫 Remaining Tickets: " + availableTickets);
                return false;
            }
        }
    }
}

class TicketBookingThread extends Thread {
    private TicketCounter ticketCounter;
    private String passengerName;
    private int ticketsToBook;

    public TicketBookingThread(TicketCounter ticketCounter, String passengerName, int ticketsToBook) {
        this.ticketCounter = ticketCounter;
        this.passengerName = passengerName;
        this.ticketsToBook = ticketsToBook;
    }

    public void run() {
        ticketCounter.bookTicket(passengerName, ticketsToBook);
    }

    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        TicketBookingThread t1 = new TicketBookingThread(counter, "Alice", 4);
        TicketBookingThread t2 = new TicketBookingThread(counter, "Bob", 5);
        TicketBookingThread t3 = new TicketBookingThread(counter, "Charlie", 3);

        t1.start();
        t2.start();
        t3.start();
    }
}
