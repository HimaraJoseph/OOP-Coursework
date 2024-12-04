import java.util.Scanner;

public class Configuration {
    private final int totalTickets;
    private final int ticketReleaseRate;
    private final int customerRetrievalRate;
    private final int maxTicketCapacity;

    // Constructor
    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    // Getters
    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    // Setup configuration via CLI
    public static Configuration setupConfiguration() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Real-Time Ticketing System Configuration!");

        System.out.print("Enter total number of tickets: ");
        int totalTickets = validatePositiveIntInput(scanner);

        System.out.print("Enter ticket release rate (tickets per second): ");
        int ticketReleaseRate = validatePositiveIntInput(scanner);

        System.out.print("Enter customer retrieval rate (tickets per second): ");
        int customerRetrievalRate = validatePositiveIntInput(scanner);

        System.out.print("Enter maximum ticket pool capacity: ");
        int maxTicketCapacity = validatePositiveIntInput(scanner);

        if (maxTicketCapacity > totalTickets) {
            System.out.println("Maximum capacity exceeds total tickets. Adjusting to total tickets.");
            maxTicketCapacity = totalTickets;
        }

        return new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
    }

    // Helper method to validate positive integer input
    private static int validatePositiveIntInput(Scanner scanner) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input > 0) {
                    break;
                } else {
                    System.out.print("Please enter a positive number: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a positive number: ");
            }
        }
        return input;
    }
}

