package Interface;

import java.io.File;


//generic Interface
public interface FileHandler<Star> {

    //skrive objekter til en fil...
    void writeObjectsToFile(Star t, File file);


    //lese objekter fra en fil...
    Star readObjectsFromFile(File file);
}
