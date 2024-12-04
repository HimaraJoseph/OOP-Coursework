// PrintNameThread.java

public class PrintNameThread extends Thread {

    // Constructor to set the thread's name
    public PrintNameThread(String threadName) {
        super(threadName);  // Call the parent class (Thread) constructor with the thread name
    }

    // Overriding the run method to define the behavior when the thread starts
    @Override
    public void run() {
        // Print the thread name 10 times
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread name: " + this.getName());
        }
    }
}

