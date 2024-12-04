public class Strings {
    public static void main(String[] args) {
        // Number of strings to concatenate
        int numStrings = 100000;

        // Measure memory usage and time for concatenation using the '+' operator
        long startTime = System.nanoTime();
        String resultPlus = "";
        for (int i = 0; i < numStrings; i++) {
            resultPlus += "Hello";  // Concatenating using '+'
        }
        long endTime = System.nanoTime();
        long durationPlus = endTime - startTime;

        // Measure memory usage for the '+' concatenation method
        Runtime runtime = Runtime.getRuntime();
        long memoryBeforePlus = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory usage before concatenation using '+': " + memoryBeforePlus / 1024 / 1024 + " MB");

        // Measure time after concatenation using '+'
        long memoryAfterPlus = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory usage after concatenation using '+': " + memoryAfterPlus / 1024 / 1024 + " MB");

        System.out.println("Time taken using '+': " + durationPlus / 1000000 + " milliseconds");

        // Measure memory usage and time for concatenation using StringBuilder
        startTime = System.nanoTime();
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < numStrings; i++) {
            resultBuilder.append("Hello");  // Concatenating using StringBuilder
        }
        endTime = System.nanoTime();
        long durationBuilder = endTime - startTime;

        // Measure memory usage for StringBuilder concatenation method
        long memoryBeforeBuilder = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory usage before concatenation using StringBuilder: " + memoryBeforeBuilder / 1024 / 1024 + " MB");

        // Measure time after concatenation using StringBuilder
        long memoryAfterBuilder = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory usage after concatenation using StringBuilder: " + memoryAfterBuilder / 1024 / 1024 + " MB");

        System.out.println("Time taken using StringBuilder: " + durationBuilder / 1000000 + " milliseconds");
    }
}

