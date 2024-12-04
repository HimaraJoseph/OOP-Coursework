import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class TicketPool {
    private final BlockingQueue<Integer> ticketPool;

    public TicketPool(int maxCapacity) {
        this.ticketPool = new ArrayBlockingQueue<>(maxCapacity);
    }

    // Add a ticket to the pool (thread-safe)
    public void addTicket() throws InterruptedException {
        ticketPool.put(1); // Add a ticket to the pool
    }

    // Purchase a ticket from the pool (thread-safe)
    public void purchaseTicket() throws InterruptedException {
        ticketPool.take(); // Remove a ticket from the pool
    }

    // Get the current size of the pool
    public int getPoolSize() {
        return ticketPool.size();
    }
}

