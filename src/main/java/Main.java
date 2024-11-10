public class Main {
    public static void main (String[] args) throws IOException {
        FileService fileService = new FileService();
        Chiper chiper = new Ceasar(Constants.ALPHABET_EN);
        Runner runner = new Runner(chiper, fileService);
        runner.run(args);
    }
}