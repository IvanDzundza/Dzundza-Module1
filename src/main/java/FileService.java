import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    // Метод для читання тексту з файлу
    public String readFile(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath));
    }

    // Метод для запису тексту у файл
    public void writeFile(String filePath, String content) throws IOException {
        Files.writeString(Paths.get(filePath), content);
    }

    // Метод для створення імені файлу з позначкою
    public String getOutputFilePath(String inputFilePath, String suffix) {
        Path path = Paths.get(inputFilePath);
        String fileName = path.getFileName().toString();
        String newFileName = fileName.replaceAll("(\\.[^.]+)?$", suffix + "$1");
        return path.getParent().resolve(newFileName).toString();
    }
}