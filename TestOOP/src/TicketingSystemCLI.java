import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TicketingSystemCLI {

    // Configuration class to store the settings
    static class Configuration {
        private int totalTickets;
        private int ticketReleaseRate;
        private int customerRetrievalRate;
        private int maxTicketCapacity;

        // Getters and Setters
        public int getTotalTickets() {
            return totalTickets;
        }

        public void setTotalTickets(int totalTickets) {
            this.totalTickets = totalTickets;
        }

        public int getTicketReleaseRate() {
            return ticketReleaseRate;
        }

        public void setTicketReleaseRate(int ticketReleaseRate) {
            this.ticketReleaseRate = ticketReleaseRate;
        }

        public int getCustomerRetrievalRate() {
            return customerRetrievalRate;
        }

        public void setCustomerRetrievalRate(int customerRetrievalRate) {
            this.customerRetrievalRate = customerRetrievalRate;
        }

        public int getMaxTicketCapacity() {
            return maxTicketCapacity;
        }

        public void setMaxTicketCapacity(int maxTicketCapacity) {
            this.maxTicketCapacity = maxTicketCapacity;
        }

        @Override
        public String toString() {
            return "Configuration{" +
                    "totalTickets=" + totalTickets +
                    ", ticketReleaseRate=" + ticketReleaseRate +
                    ", customerRetrievalRate=" + customerRetrievalRate +
                    ", maxTicketCapacity=" + maxTicketCapacity +
                    '}';
        }
    }

    // Main CLI functionality
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Configuration config = new Configuration();

        System.out.println("Real-Time Event Ticketing System Configuration");

        // Prompt user for configuration settings
        config.setTotalTickets(promptForInteger(scanner, "Enter the total number of tickets: "));
        config.setTicketReleaseRate(promptForInteger(scanner, "Enter the ticket release rate: "));
        config.setCustomerRetrievalRate(promptForInteger(scanner, "Enter the customer retrieval rate: "));
        config.setMaxTicketCapacity(promptForInteger(scanner, "Enter the maximum ticket capacity: "));

        // Display and confirm the configuration
        System.out.println("Configuration completed:");
        System.out.println(config);

        // Save the configuration to a JSON file
        saveConfiguration(config, "config.json");

        // Optionally, load the configuration to verify
        Configuration loadedConfig = loadConfiguration("config.json");
        System.out.println("Loaded Configuration:");
        System.out.println(loadedConfig);

        scanner.close();
    }

    // Helper function to prompt for an integer input with validation
    private static int promptForInteger(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value <= 0) {
                    throw new NumberFormatException("Value must be greater than zero.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }
        return value;
    }

    // Save configuration to a JSON file
    private static void saveConfiguration(Configuration config, String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(config, writer);
            System.out.println("Configuration saved to " + filename);
        } catch (IOException e) {
            System.out.println("Failed to save configuration: " + e.getMessage());
        }
    }

    // Load configuration from a JSON file
    private static Configuration loadConfiguration(String filename) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, Configuration.class);
        } catch (IOException e) {
            System.out.println("Failed to load configuration: " + e.getMessage());
            return null;
        }
    }
}

