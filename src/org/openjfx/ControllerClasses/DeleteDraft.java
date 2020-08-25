package org.openjfx.ControllerClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DeleteDraft {

    public static boolean removeSongFromFile(List<String> userSongs) {

        String filePath = System.getProperty("user.home");
        String filename = "HitSongDNA_user_song_data.hsd";
        filePath += File.separator + "Documents" + File.separator + filename;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            if(userSongs.size()>0) {
                writer.write(userSongs.get(0));

                for (int i = 1; i < userSongs.size() ; i++) {
                    writer.append(userSongs.get(i));
                }

            }else{writer.write("");}
        } catch (IOException e) {
            // Exception handling
        }
        return true;
    }

}
