import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MZFileHandler {
     
    /**
     * <h3>My File Read</h3>
     * @param fileName file-t amit szeretne beolvasni
     * @param fileRead {@code String} amibe szeretné, hogy feltöltse a {@code fileName} tartalmát
     * @param nextLine <ul><li> {@code true} akkor {@code nextLine()} methodussal tölti fel a {@code fileRead}</li>
     * <li>{@code false} akkor a {@code next()} methodussal tölti fel a {@code fielRead}</li></ul>
     * @return fileRead
     * @throws FileNotFoundException file nem található!
     */
    static String mzFileRead(String fileName, String fileRead, boolean nextLine)
    throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        if(file.canRead()){
            if(nextLine){
                while(scanner.hasNextLine()){
                    fileRead += scanner.nextLine();
                }
            }
            else{
                while(scanner.hasNext()){
                    fileRead += scanner.next();
                }
            }
        }
        scanner.close();
        return fileRead;
    }  
}