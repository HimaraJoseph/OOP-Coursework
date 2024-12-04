public class retrieve {
    public static void main(String[] args) {
        String ret = "Hello, World!";
        System.out.println("Modified string is: "+ ret.replace('r','a'));

        System.out.println(ret.replaceFirst("World", "Himara"));
    }
}
