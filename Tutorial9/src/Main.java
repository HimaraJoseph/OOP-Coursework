
public class ExtendThread {

    public static void main(String[] args) {

        // create a thread A
        PrintNameThread threadA = new PrintNameThread("A");
        threadA.start();
    }
}