public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int retrievalRate;

    public Customer(TicketPool ticketPool, int retrievalRate) {
        this.ticketPool = ticketPool;
        this.retrievalRate = retrievalRate;
    }

    @Override
    public void run() {
        try {
            while (true) {
                ticketPool.purchaseTicket();
                System.out.println("Customer: Purchased a ticket. Tickets in pool: " + ticketPool.getPoolSize());
                Thread.sleep(1000 / retrievalRate); // Simulate retrieval rate
            }
        } catch (InterruptedException e) {
            System.out.println("Customer interrupted.");
        }
    }
}

