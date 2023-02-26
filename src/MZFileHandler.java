import java.io.File;
import java.io.IOException;

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
}