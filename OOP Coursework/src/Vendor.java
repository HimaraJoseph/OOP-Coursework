public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int releaseRate;
    private int ticketsRemaining;

    public Vendor(TicketPool ticketPool, int releaseRate, int totalTickets) {
        this.ticketPool = ticketPool;
        this.releaseRate = releaseRate;
        this.ticketsRemaining = totalTickets;
    }

    @Override
    public void run() {
        try {
            while (ticketsRemaining > 0) {
                ticketPool.addTicket();
                ticketsRemaining--;
                System.out.println("Vendor: Added a ticket. Remaining tickets: " + ticketsRemaining);
                Thread.sleep(1000 / releaseRate); // Simulate release rate
            }
        } catch (InterruptedException e) {
            System.out.println("Vendor interrupted.");
        }
    }
}

