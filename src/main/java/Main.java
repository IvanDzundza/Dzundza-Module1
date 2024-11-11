public class Main {
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("Usage: java -jar myApp.jar <command> <filePath> [key]");
            return;
        }

        String command = args[0];
        String filePath = args[1];
        String key = args.length == 3 ? args[2] : "";

        Runner runner = new Runner();

        try {
            runner.run(command, filePath, key);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
