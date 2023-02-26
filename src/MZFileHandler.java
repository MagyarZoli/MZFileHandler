import java.io.FileWriter;
import java.io.IOException;

public class MZFileHandler {
     
    /**
     * <h3>My File Write</h3> Overloaded
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
}