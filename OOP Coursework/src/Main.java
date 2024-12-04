import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Setup configuration via CLI
        Configuration config = Configuration.setupConfiguration();

        // Initialize the ticket pool
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

        // Create and start vendor and customer threads
        Thread vendorThread = new Thread(new Vendor(ticketPool, config.getTicketReleaseRate(), config.getTotalTickets()));
        Thread customerThread = new Thread(new Customer(ticketPool, config.getCustomerRetrievalRate()));

        vendorThread.start();
        customerThread.start();

        // Add shutdown hook for graceful termination
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nSystem shutting down...");
            vendorThread.interrupt();
            customerThread.interrupt();
        }));
    }
}
