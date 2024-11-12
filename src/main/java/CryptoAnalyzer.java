package main.java;

public class CryptoAnalyzer {

    private final CaesarCipher caesarCipher = new CaesarCipher();

    // Метод для атаки "грубої сили"
    public String bruteForce(String encryptedText) {
        StringBuilder result = new StringBuilder();
        result.append("Possible decryptions:\n");
        for (int shift = 1; shift < 26; shift++) {
            String decryptedText = caesarCipher.decrypt(encryptedText, shift);
            result.append("Shift ").append(shift).append(": ").append(decryptedText).append("\n");
        }
        return result.toString();
    }
}
