public class CaesarCipher {

    // Метод для шифрування тексту
    public String encrypt(String text, int shift) {
        return processText(text, shift);
    }

    // Метод для дешифрування тексту
    public String decrypt(String text, int shift) {
        return processText(text, -shift);
    }

    // Метод для обробки тексту (шифрування/дешифрування)
    private String processText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26; // Робимо зсув циклічним
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char processedChar = (char) ((character - base + shift + 26) % 26 + base);
                result.append(processedChar);
            } else if (".,«»\"':!? ".indexOf(character) >= 0) {
                result.append(character);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}