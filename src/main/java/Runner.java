import java.io.IOException;

public class Runner {

    private final CaesarCipher caesarCipher = new CaesarCipher();
    private final FileService fileService = new FileService();
    private final CryptoAnalyzer cryptoAnalyzer = new CryptoAnalyzer();

    public void run(String command, String filePath, String key) throws IOException {
        String inputText = fileService.readFile(filePath);
        String outputText;
        String outputFilePath;

        switch (command.toUpperCase()) {
            case "ENCRYPT":
                int encryptKey = Integer.parseInt(key);
                outputText = caesarCipher.encrypt(inputText, encryptKey);
                outputFilePath = fileService.getOutputFilePath(filePath, "[ENCRYPTED]");
                break;
            case "DECRYPT":
                int decryptKey = Integer.parseInt(key);
                outputText = caesarCipher.decrypt(inputText, decryptKey);
                outputFilePath = fileService.getOutputFilePath(filePath, "[DECRYPTED]");
                break;
            case "BRUTE_FORCE":
                outputText = cryptoAnalyzer.bruteForce(inputText);
                outputFilePath = fileService.getOutputFilePath(filePath, "[BRUTE_FORCE]");
                break;
            default:
                throw new IllegalArgumentException("Invalid command. Use ENCRYPT, DECRYPT, or BRUTE_FORCE.");
        }

        fileService.writeFile(outputFilePath, outputText);
        System.out.println("Output saved to: " + outputFilePath);
    }
}