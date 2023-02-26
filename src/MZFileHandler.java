import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

/**
 * <h3>MZ Filr Handler</h3>
 * Magyar Zoltán áltat készített methodusok: fájl létrehozásra, olvasás és írás.
 * Class tartalmazza a {@code mzFileCreate()}, {@code mzFileRead()}, {@code mzFileWrite()}
 */
public class MZFileHandler {
     
    /**
     * <h3>My File Create</h3>
     * @param fileName file neve, amit létre akar hozni
     * @param fileType file típusa
     * @param reCreate <ul><li>{@code true} felülírja a file-t</li>
     * <li>{@code false} file csak 1-szer hozza létre</li></ul>
     * @throws IOException file nem jött létre!
     */
    static void mzFileCreate(String fileName, String fileType, boolean reCreate)
    throws IOException{
        File file = new File(fileName+"."+fileType);
        if(reCreate){
            file.delete();
        }
        file.createNewFile();

    }
    /**
     * <h3>My File Read</h3> Overloaded
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
     * <h3>My File Read</h3> Overloaded
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

    /** <h3>My File Write</h3> Overloaded
     * @param <Thing>
     * @param fileName file amibe szeretne írni
     * @param fileWrite amit szeretne beleírni a {@code fileName} -be
     * @throws IOException
     */
    static <Thing> void mzFileWrite(String fileName, Thing fileWrite)
    throws IOException{
        FileWriter file = new FileWriter(fileName);
        file.write(String.valueOf(fileWrite));
        file.close();
    }
    /**
     * <h3>My File Write</h3> Overloaded
     * @param <Thing>
     * @param fileName file amibe szeretne írni
     * @param fileWrite tömb amit szeretne beleírni a {@code fileName} -be
     * @throws IOException
     */
    static <Thing> void mzFileWrite(String fileName, Thing[] fileWrite)
    throws IOException{
        FileWriter file = new FileWriter(fileName);
        for(Thing i : fileWrite){
            file.write(String.valueOf(i));
        }
        file.close();
    }
    /**
     * <h3>My File Write</h3> Overloaded
     * @param <Thing>
     * @param fileName file amibe szeretne írni
     * @param fileWrite {@code ArrayList} szeretne beleírni a {@code fileName} -be
     * @throws IOException
     */
    static <Thing> void mzFileWrite(String fileName, ArrayList<Thing> fileWrite)
    throws IOException{
        FileWriter file = new FileWriter(fileName);
        for(Thing i : fileWrite){
            file.write(String.valueOf(i));
        }
        file.close();
    }
}