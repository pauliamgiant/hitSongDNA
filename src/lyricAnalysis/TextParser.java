package lyricAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextParser {

    List<String> songLines;

    /**
     * Loads Lyric text from a text file
     */

    public TextParser() {
        songLines = new ArrayList<String>();
    }


    public List<String> getLines() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/org/openjfx/Resources/lyrics.txt"));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if(!line.equals("")) {
                songLines.add(line);
            }
        }
        return songLines;
    }


}
