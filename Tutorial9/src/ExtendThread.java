// ExtendThread.java

public class ExtendThread {

    public static void main(String[] args) {

        // Create and start threads A, B, and C
        PrintNameThread threadA = new PrintNameThread("A");
        PrintNameThread threadB = new PrintNameThread("B");
        PrintNameThread threadC = new PrintNameThread("C");

        threadA.start(); // Start thread A
        threadB.start(); // Start thread B
        threadC.start(); // Start thread C
    }
}


