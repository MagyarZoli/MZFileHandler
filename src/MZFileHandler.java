import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    /**
     * <h3>My File Read</h3>
     * @param fileName file-t amit szeretne beolvasni
     * @param fileRead {@code String[]} amibe szeretné, hogy feltöltse a {@code fileName} tartalmát
     * <p>megjegyzés a tömb megadása paraméterként elöbb megfelelő méretűt kell ledekralálni, hogy feltudja tölteni</p>
     * @param nextLine <ul><li> {@code true} akkor {@code nextLine()} methodussal tölti fel a {@code fileRead}</li>
     * <li>{@code false} akkor a {@code next()} methodussal tölti fel a {@code fielRead}</li></ul>
     * @return fileRead
     * @throws FileNotFoundException file nem található!
     */
    static String[] mzFileRead(String fileName, String[] fileRead, boolean nextLine)
    throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        Scanner scanner2 = new Scanner(file);
        int count = 0;
        if(file.canRead()){
            if(nextLine){
                while(scanner.hasNext()){
                    String s = scanner.nextLine();//!
                    count++;
                }
                scanner.close();
                count = 0;
                while(scanner2.hasNextLine()){
                    fileRead[count] = scanner2.nextLine();
                    count++;
                }
            }
            else{
                while(scanner.hasNext()){
                    String s = scanner.next();//!
                    count++;
                }
                scanner.close();
                fileRead = new String[count];
                count = 0;
                while(scanner2.hasNext()){
                    fileRead[count] = scanner2.next();
                    count++;
                }
            }
        }
        scanner2.close();
        return fileRead;
    }
    /**
     * <h3>My File Read</h3> Overloaded
     * @param fileName file-t amit szeretne beolvasni
     * @param fileRead {@code ArrayList<String>} amibe szeretné, hogy feltöltse a {@code fileName} tartalmát
     * @param nextLine <ul><li> {@code true} akkor {@code nextLine()} methodussal tölti fel a {@code fileRead}</li>
     * <li>{@code false} akkor a {@code next()} methodussal tölti fel a {@code fielRead}</li></ul>
     * @return fileRead
     * @throws FileNotFoundException file nem található!
     */
    static ArrayList<String> mzFileRead(String fileName, ArrayList<String> fileRead, boolean nextLine)
    throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        if(file.canRead()){
            if(nextLine){
                while(scanner.hasNextLine()){
                    fileRead.add(scanner.nextLine());
                }
            }
            else{
                while(scanner.hasNext()){
                    fileRead.add(scanner.next());
                }
            }
        }
        scanner.close();
        return fileRead;
    }  
}